import category.CategoryDTO;
import category.CategoryService;
import expense.Expense;
import expense.ExpenseDTO;
import income.IncomeDTO;
import income.IncomeService;
import income.CategorizedIncomeDto;
import summary.SummaryService;
import util.HibernateUtil;
import expense.ExpenseService;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        IncomeService incomeService = new IncomeService();
        ExpenseService expenseService = new ExpenseService();
        CategoryService categoryService = new CategoryService();
        SummaryService summaryService = new SummaryService();

        int exit = 1;
        while (exit == 1) {

            System.out.println("Podaj operacje do wykonania");
            System.out.println("1. Dodaj nowy wydatek");
            System.out.println("2. Dodaj nowy przychód");
            System.out.println("3. Usuń isniejący wydatek");
            System.out.println("4. Usuń istniejący przychód");
            System.out.println("5. Wyświetl wszystkie przychody i wydatki");
            System.out.println("6. Wyświetl wszystkie wydatki");
            System.out.println("7. Wyświetlenie wydatków na podstawie zakresu dat");
            System.out.println("8. Wyświetlenie wszystkich wydatków na podstawie wybranej kategorii");
            System.out.println("9. Wyświetlenie sumy wydatków oraz ich ilości w danej kategorii (grupowanie po kategorii wydatków)");
            System.out.println("10. Wyświetlenie wszystkich przychodów");
            System.out.println("11. Wyświetlenie Saldo");
            System.out.println("12. Dodanie nowej kategorii");
            System.out.println("13. Usunięcie istniejącej kategorii");
            System.out.println("0. Wyjdź z programu");
            Scanner in = new Scanner(System.in);
            int selectedOperation = in.nextInt();


            switch (selectedOperation) {
                case 1 -> {

                    System.out.println("Podaj wartość wydatku, format XXXXX,XX");
                    Double amount = in.nextDouble();
                    System.out.println("Dodaj komentarz");
                    in.nextLine();
                    String comment = in.nextLine();
                    System.out.println("Podaj id kategorii");
                    categoryService.showAll();
                    long category = in.nextLong();
                    ExpenseDTO wydatek = new ExpenseDTO(amount, comment, category);
                    expenseService.add(wydatek);


                }
                case 2 -> {

                    System.out.println("Podaj wartość przychodu");
                    double amount = in.nextDouble();
                    System.out.println("Dodaj komentarz");
                    in.nextLine();
                    String comment = in.nextLine();
                    IncomeDTO przychod = new IncomeDTO(amount, comment);
                    incomeService.add(przychod);
                }
                case 3 -> {

                    System.out.println("Usuwanie isntejacego wydatku");
                    expenseService.showAll();
                    System.out.println("Wybierz ID wydatku ktory chcesz usunac");
                    Integer id = in.nextInt();
                    List<Expense> expenseList = entityManager.createNativeQuery("select * from expense where category_id = " + id, Expense.class).getResultList();
                    if (expenseList.isEmpty()) {
                        System.out.println("Nie ma takiego wydatku");
                    } else {
                        expenseService.remove(id);
                    }
                }
                case 4 -> {
                    incomeService.showAll();
                    System.out.println("Podaj ID przychodu który chcesz usunac");
                    int id = in.nextInt();
                    incomeService.remove(id);
                }
                case 5 -> {
                    System.out.println("Wyświetlanie wszystkich wydatków i przychodów");
                    incomeService.showAll();
                    expenseService.showAll();

                }
                case 6 -> {
                    expenseService.showAll();
                }
                case 7 -> {
                    System.out.println("Podaj pierwszą date YYYYMMDD");
                    in.nextLine();
                    String firstDate = in.nextLine();
                    System.out.println("Podaj drugą date YYYYMMDD");
                    String secondDate = in.nextLine();
                    expenseService.showFromDateToDate(firstDate, secondDate);
                }
                case 8 -> {
                    categoryService.showAll();
                    System.out.println("Wybierz id kategorii");
                    int categoryId = in.nextInt();
                    List<Expense> expenseList = entityManager.createNativeQuery("select * from expense where category_id = " + categoryId, Expense.class).getResultList();
                    expenseList.forEach(System.out::println);
                }
                case 9 -> {
                    String sql = "SELECT \n" +
                            "COUNT(expense.id) AS ilosc_wydatkow,\n" +
                            "SUM(expense.amount) AS amount,\n" +
                            "category.category AS category_name\n" +
                            "FROM expense\n" +
                            "JOIN category on expense.category_id = category.id\n" +
                            "GROUP BY category_name\n" +
                            "ORDER BY category_name ASC";
                    List<Object[]> resultList = entityManager.createNativeQuery(sql).getResultList();
                    List<CategorizedIncomeDto> collect = resultList.stream().map(objects -> new CategorizedIncomeDto((BigInteger) objects[0], (BigDecimal) objects[1], (String) objects[2])).collect(Collectors.toList());
                    collect.forEach(System.out::println);
                }
                case 10 -> {
                    incomeService.showAll();
                }
                case 11 -> {
                    System.out.println(summaryService.saldo());

                }
                case 12 -> {
                    System.out.println("Podaj nazwe nowej kategorii");
                    in.nextLine();
                    String category = in.nextLine();
                    CategoryDTO categoryDTO = new CategoryDTO(category);
                    categoryService.add(categoryDTO);
                }
                case 13 -> {
                    System.out.println("Usuwanie isntejacej kategorii");
                    categoryService.showAll();
                    System.out.println("Wybierz ID kategorii ktory chcesz usunac");
                    Integer id = in.nextInt();
                    List<Expense> expenseList = entityManager.createNativeQuery("select * from expense where category_id = " + id, Expense.class).getResultList();
                    if (expenseList.isEmpty()) {
                        categoryService.remove(id);
                    } else {
                        System.out.println("Nie można usunąć kategorii, ktora ma przypisane wydatki");
                    }
                    ;
                }
                case 0 -> {
                    exit = 0;
                }

            }


        }
    }
}

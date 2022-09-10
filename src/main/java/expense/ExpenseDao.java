package expense;

import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.IllegalFormatException;
import java.util.List;

public class ExpenseDao {

    public void insert(Expense expense) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist((expense));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(int id) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Expense expense = entityManager.find(Expense.class, id);
        System.out.println(expense);
        entityManager.remove(expense);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void showAll() {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        List<Expense> expenseList = entityManager.createNativeQuery("select * from expense", Expense.class).getResultList();
        expenseList.forEach(System.out::println);
    }

    public void showFromDateToDate(String first, String second) {
        if (first.length() == 8 && second.length() == 8) {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            List<Expense> expenseList = entityManager.createNativeQuery("select * from expense where expence_add_date >= " + first + " and expence_add_date <= " + second, Expense.class).getResultList();
            expenseList.forEach(System.out::println);
        } else {
            throw new IllegalArgumentException("Błędny format danych");
        }
    }

    public List<Expense> listByCategoryId(int id) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

        return entityManager.createNativeQuery("select * from expense where category_id = " + id, Expense.class).getResultList();
    }
}

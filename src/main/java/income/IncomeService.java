package income;

import expense.Expense;
import expense.ExpenseDTO;
import expense.ExpenseDao;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class IncomeService {
    EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
    private IncomeDao incomeDao = new IncomeDao();

    public void add(IncomeDTO incomeDTO) {
        if (incomeDTO.getComment() != null && incomeDTO.getAmount() > 0) {
            Income income = new Income(incomeDTO.getAmount(), incomeDTO.getComment(), incomeDTO.getIncomeAddDate());
            incomeDao.insert(income);
        } else {
            throw new IllegalArgumentException("Błędne dane");
        }
    }

    public void remove(int id) {
        incomeDao.delete(id);
    }
    public void showAll() {
        incomeDao.showAll();
    }
    public List<Object[]> showGrouped(){
        String sql = "SELECT \n" +
                "COUNT(expense.id) AS ilosc_wydatkow,\n" +
                "SUM(expense.amount) AS amount,\n" +
                "category.category AS category_name\n" +
                "FROM expense\n" +
                "JOIN category on expense.category_id = category.id\n" +
                "GROUP BY category_name\n" +
                "ORDER BY category_name ASC";
        return entityManager.createNativeQuery(sql).getResultList();
    }
    public List<Income> listByCategory(int id) {
        return incomeDao.listByCategory(id);
    }
}

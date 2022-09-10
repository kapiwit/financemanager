package income;

import category.Category;
import expense.Expense;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class IncomeDao {

    public void insert(Income income) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist((income));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(int id) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Income income = entityManager.find(Income.class, id);
        System.out.println(income);
        entityManager.remove(income);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void showAll() {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        List<Income> incomeList = entityManager.createNativeQuery("select * from income", Income.class).getResultList();
        incomeList.forEach(System.out::println);
    }
    public List<Object[]> showGrouped() {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
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
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        return entityManager.createNativeQuery("select * from income where id = " + id, Income.class).getResultList();
    }
}

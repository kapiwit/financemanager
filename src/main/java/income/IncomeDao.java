package income;

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

}

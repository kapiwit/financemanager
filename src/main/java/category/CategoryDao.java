package category;

import income.Income;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    public static void showAll(){
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        List<Category> categoryList = entityManager.createNativeQuery("select * from category", Category.class).getResultList();
        categoryList.forEach(System.out::println);
    }
    public void delete(int id) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, id);
        System.out.println(category);
        entityManager.remove(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void insert(Category category) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist((category));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

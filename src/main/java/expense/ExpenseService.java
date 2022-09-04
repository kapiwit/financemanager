package expense;

import util.HibernateUtil;

import javax.persistence.EntityManager;

public class ExpenseService {
    EntityManager entityManager  = HibernateUtil.getSessionFactory().createEntityManager();
    private ExpenseDao expenseDao = new ExpenseDao();
    public void add(ExpenseDTO expenseDTO) {
        if (expenseDTO.getComment() != null && expenseDTO.getAmount() > 0 && expenseDTO.getExpenseAddDate() != null && expenseDTO.getCategoryId() != null){
        Expense expense = new Expense(expenseDTO.getAmount(), expenseDTO.getComment(),expenseDTO.getExpenseAddDate() ,expenseDTO.getCategoryId());
        expenseDao.insert(expense);
        } else {
            throw new IllegalArgumentException("Błędne dane");
        }
    }
    public void remove(Integer id){
        expenseDao.delete(id);
    }
    public void showAll() {
        expenseDao.showAll();
    }
    public void showFromDateToDate(String first, String second){
        expenseDao.showFromDateToDate(first, second);
    }
}

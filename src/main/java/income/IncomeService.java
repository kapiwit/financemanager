package income;

import expense.Expense;
import expense.ExpenseDTO;
import expense.ExpenseDao;
import util.HibernateUtil;

import javax.persistence.EntityManager;

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
}

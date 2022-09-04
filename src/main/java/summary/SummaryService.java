package summary;

import income.CategorizedIncomeDto;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SummaryService {
    EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
    public double saldo() {
        String sql = "select amount from income";
        String sql2 = "select amount from expense";
        List<Object> resultList = entityManager.createNativeQuery(sql).getResultList();
        List<Object> resultList2 = entityManager.createNativeQuery(sql2).getResultList();
        double positive = resultList.stream().map(Object::toString).mapToDouble(string -> Double.parseDouble(string)).sum();
        double negative = resultList2.stream().map(Object::toString).mapToDouble(string -> Double.parseDouble(string)).sum();
        return positive - negative;
    }
}

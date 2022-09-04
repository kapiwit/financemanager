package income;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class CategorizedIncomeDto implements Serializable {
    private final BigInteger id;
    private final BigDecimal amount;
    private final String categoryId;

    @Override
    public String toString() {
        return "SummaryDto{" +
                "Ilosc wydatkow=" + id +
                ", Kwota=" + amount +
                ", Nazwa kategorii='" + categoryId + '\'' +
                '}';
    }
}

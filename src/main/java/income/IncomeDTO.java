package income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
public class IncomeDTO implements Serializable {
    private final double amount;
    private final String comment;
    private final LocalDate incomeAddDate;

    public IncomeDTO(double amount, String comment) {
        this.amount = amount;
        this.comment = comment;
        this.incomeAddDate = LocalDate.now();
    }
}

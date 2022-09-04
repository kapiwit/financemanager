package expense;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
public class ExpenseDTO implements Serializable {
    private final double amount;
    private final String comment;
    private final LocalDate expenseAddDate;
    private final Long categoryId;

    public ExpenseDTO(double amount, String comment, Long categoryId) {
        this.amount = amount;
        this.comment = comment;
        this.expenseAddDate = LocalDate.now();
        this.categoryId = categoryId;
    }


}

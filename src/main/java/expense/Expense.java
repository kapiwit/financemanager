package expense;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
@NoArgsConstructor
@Getter
@Setter

public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount", precision = 38, scale = 2)
    private double amount;

    @Column(name = "comment")
    private String comment;

    @Column(name = "expence_add_date")
    private LocalDate expenseAddDate;

    @Column(name = "category_id")
    private Long categoryId;

    public Expense(double amount, String comment, LocalDate expenseAddDate, Long categoryId) {
        this.amount = amount;
        this.comment = comment;
        this.expenseAddDate = expenseAddDate;
        this.categoryId = categoryId;
    }


    public Expense(double amount, Long categoryId) {
        this.amount = amount;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Wydatek o id=" + id +
                ", Kwota=" + amount +
                ", Komentarz='" + comment + '\'' +
                ", Data dodania wydatku=" + expenseAddDate +
                ", Numer Kategorii=" + categoryId +
                '}';
    }
}
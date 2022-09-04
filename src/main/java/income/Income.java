package income;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@NoArgsConstructor
@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount", precision = 38, scale = 2)
    private double amount;

    @Column(name = "comment")
    private String comment;

    @Column(name = "income_add_date")
    private LocalDate incomeAddDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getIncomeAddDate() {
        return incomeAddDate;
    }

    public void setIncomeAddDate(LocalDate incomeAddDate) {
        this.incomeAddDate = incomeAddDate;
    }

    public Income(double amount, String comment, LocalDate incomeAddDate) {
        this.amount = amount;
        this.comment = comment;
        this.incomeAddDate = incomeAddDate;
    }

    @Override
    public String toString() {
        return "Przychód o id=" + id +
                ", kwocie=" + amount +
                ", komentarzu='" + comment + '\'' +
                ", dacie dodania=" + incomeAddDate +
                '}';
    }
}
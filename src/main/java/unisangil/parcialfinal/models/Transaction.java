package unisangil.parcialfinal.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private TransactionType type;

    @Column(nullable = false)
    private String description;

    //formatted date 2024-11-19T16:16:15.809086 for humans 2024-11-19 16:16:15.809086 format yyyy-MM-dd HH:mm:ss.SSSSSS
    public String getFormattedDate() {
        var date = this.date;
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return date.format(formatter);
    }
}



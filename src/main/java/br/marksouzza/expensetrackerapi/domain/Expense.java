package br.marksouzza.expensetrackerapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tbl_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "expense_name")
    private String name;

    private String description;

    @Column (name = "expense_amount")
    private BigDecimal expenseAmount;

    private String category;
    private Date date;

}

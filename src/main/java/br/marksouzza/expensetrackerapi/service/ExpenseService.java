package br.marksouzza.expensetrackerapi.service;

import br.marksouzza.expensetrackerapi.domain.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
    Expense addExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
    List<Expense> readByCategory(String category, Pageable page);
    List<Expense> readByName(String name, Pageable page);

}

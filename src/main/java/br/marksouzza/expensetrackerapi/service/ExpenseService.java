package br.marksouzza.expensetrackerapi.service;

import br.marksouzza.expensetrackerapi.domain.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense addExpense(Expense expense);

    Expense updateExpense(Long id, Expense expense);

}

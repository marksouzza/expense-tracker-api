package br.marksouzza.expensetrackerapi.implementation;

import br.marksouzza.expensetrackerapi.domain.Expense;
import br.marksouzza.expensetrackerapi.exception.ResourceNotFoundException;
import br.marksouzza.expensetrackerapi.repository.ExpenseRepository;
import br.marksouzza.expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepo;

    @Override
    public Page<Expense> getAllExpenses(Pageable page) {
        return expenseRepo.findAll(page);
    }

    @Override
    public Expense getExpenseById(Long id){
        Optional<Expense> expense = expenseRepo.findById(id);
        if (expense.isPresent()){
            return expense.get();
        }
        throw new ResourceNotFoundException("Expense not found for id: "+id);
    }

    @Override
    public void deleteExpenseById(Long id){
        Optional<Expense> expense = expenseRepo.findById(id);
        expenseRepo.deleteById(id);
    }

    @Override
    public Expense addExpense(Expense expense){
       return expenseRepo.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense){
        Expense existingExpense = getExpenseById(id);
        existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
        existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
        existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
        existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
        return expenseRepo.save(existingExpense);
    }
}

package br.marksouzza.expensetrackerapi.implementation;

import br.marksouzza.expensetrackerapi.domain.Expense;
import br.marksouzza.expensetrackerapi.repository.ExpenseRepository;
import br.marksouzza.expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepo;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    @Override
    public Expense getExpenseById(Long id){
        Optional<Expense> expense = expenseRepo.findById(id);
        if (expense.isPresent()){
            return expense.get();
        }
        throw new RuntimeException("Expense not found for id: "+id);
    }
}

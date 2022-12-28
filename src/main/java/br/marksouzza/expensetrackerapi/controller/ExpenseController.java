package br.marksouzza.expensetrackerapi.controller;

import br.marksouzza.expensetrackerapi.domain.Expense;
import br.marksouzza.expensetrackerapi.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses(Pageable page){
        return expenseService.getAllExpenses(page).toList();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id){
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense){
        Expense newExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Expense updateExpense (@RequestBody Expense expense, @PathVariable Long id){
        return expenseService.updateExpense(id, expense);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteExpenseById(@PathVariable("id") Long id) {
        expenseService.deleteExpenseById(id);
    }

}

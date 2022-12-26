package br.marksouzza.expensetrackerapi.controller;

import br.marksouzza.expensetrackerapi.domain.Expense;
import br.marksouzza.expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public String getExpenseById(@PathVariable("id") Long id){
        return "The expense ID is " + id;
    }

    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam("id") Long id){
        return "Delete the expense object by its id:" +id;
    }
}

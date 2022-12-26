package br.marksouzza.expensetrackerapi.repository;

import br.marksouzza.expensetrackerapi.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository <Expense, Long> {

}

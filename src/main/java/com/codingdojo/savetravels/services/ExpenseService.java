package com.codingdojo.savetravels.services;
import java.util.List;
import java.util.Optional;
import com.codingdojo.savetravels.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;
import com.codingdojo.savetravels.models.Expense;

@Service
public class ExpenseService {
    // adding the expense repository as a dependency
	private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    // returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates an expense
    public Expense createExpense(Expense e) {
        return expenseRepository.save(e);
    }
    // Retrieves an expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    
    // Update an expense with expense object
    public Expense updateExpense(Expense e) {
        return expenseRepository.save(e);
    }
    
    // Deletes a book
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }
}


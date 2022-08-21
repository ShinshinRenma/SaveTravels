package com.codingdojo.savetravels.controllers;
import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
   
    @RequestMapping(value="/")
    	public String index(@ModelAttribute("expense") Expense expense, Model model) {
    		List<Expense> expenses = expenseService.allExpenses();
    		model.addAttribute("expenses", expenses);
    		return "index.jsp";
    	}
    
    @GetMapping("/expenses/new")
    public String newExpense(@ModelAttribute("expense") Expense expense) {
        return "/index.jsp";
    }
    
    @GetMapping("/expenses/{id}")
    public String getOne(@PathVariable("id") Long id, Model model) {
    	Expense expense = expenseService.findExpense(id);
    	model.addAttribute("expense", expense);
    	return "details.jsp";
    }
    
    // Note: We'll be altering this a bit after we introduce data binding.
    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
    	if (result.hasErrors()) {
            return "/index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "/edit.jsp";
    }
    
    @PutMapping(value="/edit/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/";
        }
    }
    
    @DeleteMapping(value="/expenses/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/";
    }
}

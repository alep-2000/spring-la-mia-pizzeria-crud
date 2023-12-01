package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@Autowired
	private PizzaService pizzaService;
	
//	@GetMapping
//	public String getPizzas(Model model) {
//		
//		List<Pizza> pizzas = pizzaService.findAll();
//		
//		model.addAttribute("pizzas", pizzas);
//		
//		return "pizzas";
//	}
	
	@GetMapping
	public String getPizzas(Model model,
			@RequestParam(required = false) String p) {
		
		List<Pizza> pizzas = p == null  
					? pizzaService.findAll()
					: pizzaService.findByNome(p);
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("p", p == null ? "" : p);
		
		return "pizzas";
	}
	
	@GetMapping("/pizzas/{id}")
	public String getPizza(Model model,
			@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza";
	}
}


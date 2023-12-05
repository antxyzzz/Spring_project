package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	public String doGet() {
		return "calculator.html";

	}

	@PostMapping("calculator")

	public String doGet(
			@RequestParam("number1") int number1,
			@RequestParam("number2") int number2,
			@RequestParam("operator") String operator,
			Model model) {
		int result = 0;

		switch (operator) {
		case "plus":
			result = calculatorService.plus(number1, number2);
			break;
		case "minus":
			result = calculatorService.minus(number1, number2);
			break;
		case "multi":
			result = calculatorService.multi(number1, number2);
			break;
		case "divide":
			result = calculatorService.divide(number1, number2);
			break;
		}

		model.addAttribute("result", result);
		return "calculator.html";
	}
}
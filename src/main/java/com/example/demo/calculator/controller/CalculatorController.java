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

	public String doPost(
			@RequestParam("number1") int number1,
			@RequestParam("number2") int number2,
			@RequestParam("operator") String operator,
			Model model) {
		int result = calculatorService.calculate(number1, number2, operator);
		model.addAttribute("result", result);
		return "calculator.html";
	}
}
package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MinusController {

	@GetMapping("minus")
	public String doGet() {
		return "minus.html";

	}

	@PostMapping("minus")
	public String doGet(@RequestParam("number1") int number1, @RequestParam("number2") int number2, Model model) {
		int result = number1 - number2;
		model.addAttribute("result", result);
		return "minus.html";
	}
}

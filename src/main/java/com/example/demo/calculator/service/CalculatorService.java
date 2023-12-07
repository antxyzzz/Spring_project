package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int calculate(int number1, int number2, String operator) {

		switch (operator) {
		case "plus":
			return plus(number1, number2);
		case "minus":
			return minus(number1, number2);
		case "multi":
			return multi(number1, number2);
		case "divide":
			return divide(number1, number2);
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}

	public int plus(int number1, int number2) {
		return number1 + number2;
	}

	public int minus(int number1, int number2) {
		return number1 - number2;
	}

	public int multi(int number1, int number2) {
		return number1 * number2;
	}

	public int divide(int number1, int number2) {
		if (number2 != 0) {
			return number1 / number2;
		} else {
			throw new ArithmeticException("Cannot divide by zero");
		}
	}

}
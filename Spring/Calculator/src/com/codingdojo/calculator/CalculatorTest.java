package com.codingdojo.calculator;

public class CalculatorTest {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		calculator.performOperation(10.5, 5.2, "+");
		calculator.getResults();
		
		calculator.performOperation(10, 5, "-");
		calculator.getResults();
		
		calculator.performOperation(-2, -5, "+");
		calculator.getResults();
	}

}

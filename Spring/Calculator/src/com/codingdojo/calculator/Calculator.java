package com.codingdojo.calculator;

@SuppressWarnings("serial")
class Calculator implements java.io.Serializable, CalculatorInterface {
	//Member variables must be private, but accessible using get and set; Must have a zero argument constructor; Must implement the serializable interface
	
	private double operand1;
	private double operand2;
	private String operation;
	private double result;
	
	public Calculator() {
	}
	public double getOperand1() {
		return operand1;
	}
	public void setOperand1(double operand1) {
		this.operand1 = operand1;
	}
	public double getOperand2() {
		return operand2;
	}
	public void setOperand2(double operand2) {
		this.operand2 = operand2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public double performOperation(double operand1, double operand2, String operation) {
		setOperand1(operand1);
		setOperand2(operand2);
		setOperation(operation);
		if(operation == "-") {
			this.result = operand1 - operand2;
			return result;
		} else {
			this.result = operand1 + operand2;
			return result;
		}
		
	}

	public void getResults() {
		System.out.println("The total is " + result);
		
	}
}

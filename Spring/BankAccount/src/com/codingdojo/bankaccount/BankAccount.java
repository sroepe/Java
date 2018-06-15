package com.codingdojo.bankaccount;

import java.util.*;

class BankAccount {
	private String accountNumber = "";
	private double checkingBalance;
	private double savingsBalance;
	
	public static int numberOfAccounts = 0;
	public static double totalAmountOfAccounts = 0;
	
	private String randomNumber() {
		Random randAcct = new Random();
		String n = Integer.toString(randAcct.nextInt(2000000001) + 1000000001);
		System.out.println(n);
		return n;
	}
	public BankAccount() {
		numberOfAccounts ++;
		this.checkingBalance = 0.00;
		this.savingsBalance = 0.00;
		totalAmountOfAccounts += this.checkingBalance + this.savingsBalance;
		this.accountNumber = randomNumber();
		System.out.println(numberOfAccounts);
		System.out.println(totalAmountOfAccounts);
	}
	
	public Double getCheckBal() {
		System.out.println("Your current available checkingbalance is " + savingsBalance + ".");
		return checkingBalance;
	}
	
	public Double getSaveBal() {
		System.out.println("Your current available savings balance is " + savingsBalance + ".");
		return savingsBalance;
	}
	
	public Double getTotalBal() {
		System.out.println("Your total available balance is " + totalAmountOfAccounts + ".");
		return totalAmountOfAccounts;
	}
	
	public Double deposit(double amt, boolean isChecking) {
		if(isChecking == true) {
			checkingBalance += amt;
			totalAmountOfAccounts += checkingBalance;
			System.out.println("Amount of " + amt + " deposited into your checking account. Your total available balance is " + totalAmountOfAccounts + ".");
		} else {
			savingsBalance += amt;
			totalAmountOfAccounts += savingsBalance;
			System.out.println("Amount of " + amt + " deposited into your savings account. Your total available balance is " + totalAmountOfAccounts + ".");
		}
		
		return totalAmountOfAccounts;
	}
	
	public Double withdraw(double amt, boolean isChecking) {
		if((isChecking == true) && (amt < checkingBalance)) {
			checkingBalance -= amt;
			totalAmountOfAccounts -= amt;
			System.out.println("Amount of " + amt + " withdrawn from your checking account. Your total available balance is " + totalAmountOfAccounts + ".");
		} else if(amt < savingsBalance) {
			savingsBalance -= amt;
			totalAmountOfAccounts -= amt;
			System.out.println("Amount of " + amt + " withdrawn from your savings account. Your total available balance is " + totalAmountOfAccounts + ".");
		} else {
			System.out.println("There are insufficient funds in the specified account account to complete this withdrawal.  Your current account balance is " + totalAmountOfAccounts + ".");
		}
		return totalAmountOfAccounts;
	}
			
}
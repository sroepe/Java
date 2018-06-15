package com.codingdojo.bankaccount;

class BankAccountTest {

	public static void main(String[] args) {
		BankAccount acct1 = new BankAccount();
		
		System.out.println(acct1);
		
		acct1.getCheckBal();
		acct1.getSaveBal();
		
		acct1.deposit(25.00, true);
		acct1.getCheckBal();
		acct1.deposit(300.00, false);
		acct1.getSaveBal();
		
		acct1.withdraw(299.00, false);
		acct1.withdraw(0.99, false);
		
		acct1.getSaveBal();
		
		acct1.getTotalBal();
		
		
		

	}

}

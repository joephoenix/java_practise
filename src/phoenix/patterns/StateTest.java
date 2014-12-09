package phoenix.patterns;

import phoenix.patterns.p19State.Account;

public class StateTest {

	public static void main(String[] args) {
		Account account = new Account("John Smith");

		// 进行交易
		// 存钱
		account.deposit(1000.00);
		account.deposit(200.00);
		account.deposit(600.00);

		// 付利息
		account.payInterest();

		// 取钱
		account.withdraw(1000.00);
		account.withdraw(500.00);
		account.withdraw(500.00);
		account.withdraw(500.00);

		// 付利息
		account.payInterest();
	}

}

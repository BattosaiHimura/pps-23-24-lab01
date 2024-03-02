package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account with ATM capabilites allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount.
 * Transaction fees are applied for any valid deposit or withdrawal via ATM.
 */
public class SimpleBankAccountWithAtm implements BankAccount {

    private BankAccount bankAccount;

    private static final double TRANSACTION_FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.bankAccount = new SimpleBankAccount(holder, balance);
    }

    @Override
    public AccountHolder getHolder() {
        return this.bankAccount.getHolder();
    }

    @Override
    public double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        this.bankAccount.deposit(userID, amount);
        this.applyTransactionFee(userID);
    }

    @Override
    public void withdraw(int userID, double amount) {
        this.bankAccount.withdraw(userID, amount);
        this.applyTransactionFee(userID);
    }

    private void applyTransactionFee(int userID) {
        this.bankAccount.withdraw(userID, TRANSACTION_FEE);
    }
}

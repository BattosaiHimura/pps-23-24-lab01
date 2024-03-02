import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

class SimpleBankAccountWithAtmTest {
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
        bankAccount.deposit(accountHolder.getId(), 101);
    }

    @Test
    void testDepositWithAtm() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(199, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.deposit(2, 50);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(29, bankAccount.getBalance());
    }
    
    @Test
    void testWrongWithdrawWithAtm() {
        bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }
}

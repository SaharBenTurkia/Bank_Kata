package Test;

import com.kata.bank.*;
import org.junit.runner.RunWith;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class BankAccountTest {

    public static final LocalDateTime transactionTime = LocalDateTime.now();
    private Transaction expectedDeposit = transaction(transactionTime, 100);
    private Transaction expectedWithdrawal = transaction(transactionTime, -100);
    private StatementPrinting statementPrinting = new StatementPrinting();
    private BankAccount account = new BankAccount();
    private Client client = new Client();

    @Test public void make_deposit_transaction() {
        Transaction transaction = client.addTransaction(TransactionType.DEPOSIT,100);
        List<Transaction> transactions = new ArrayList();
        transactions.add(transaction);
        client.setTransactions(transactions);

        transactions = client.getTransactions();

        assertEquals(client.getTransactions().size(), 1);
        assertEquals(transactions.get(0).getAmount(), expectedDeposit.getAmount());
        assertEquals(transactions.get(0).getType(), expectedDeposit.getType());
    }

    @Test
    public void make_withdrawal_transaction() {
        Transaction transaction = client.addTransaction(TransactionType.WITHDRAWAL,-100);
        List<Transaction> transactions = new ArrayList();
        transactions.add(transaction);
        client.setTransactions(transactions);

        transactions = client.getTransactions();

        assertEquals(client.getTransactions().size(), 1);
        assertEquals(transactions.get(0).getAmount(), expectedWithdrawal.getAmount());
        assertEquals(transactions.get(0).getType(), expectedWithdrawal.getType());
    }

    @Test
    public void check_history_transaction() {
        List<Transaction> transactions = new ArrayList();
        Transaction transaction1 = client.addTransaction(TransactionType.WITHDRAWAL,-100);
        transactions.add(transaction1);
        Transaction transaction2 = client.addTransaction(TransactionType.WITHDRAWAL,-50);
        transactions.add(transaction2);
        Transaction transaction3 = client.addTransaction(TransactionType.DEPOSIT,200);
        transactions.add(transaction3);
        client.setTransactions(transactions);

        account.setStatementPrinting(statementPrinting);
        client.setBankAccount(account);

        transactions = client.getTransactions();

        assertEquals(client.getTransactions().size(), 3);
        assertEquals(transactions.stream().filter(t -> t.getType().equals(TransactionType.WITHDRAWAL)).map(t -> t.getAmount()).collect(Collectors.summingDouble(Double::doubleValue)), 150);
        assertEquals(transactions.stream().filter(t -> t.getType().equals(TransactionType.DEPOSIT)).map(t -> t.getAmount()).collect(Collectors.summingDouble(Double::doubleValue)), 200);
        assertEquals(transactions.stream().filter(t -> t.getType().equals(TransactionType.WITHDRAWAL)).count(), 2);
        assertEquals(transactions.stream().filter(t -> t.getType().equals(TransactionType.DEPOSIT)).count(), 1);

        assertEquals(client.getBankAccount().getStatementPrinting().printBalance(transaction1), transaction1.getType()
                + " || " + transaction1.getAmount()
                + " || " + transaction1.getDateTime());

    }

    private Transaction transaction(LocalDateTime date, int amount) {
        return new Transaction(date, amount);
    }
}
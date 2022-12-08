package Application.Design;

import Application.BankClient.Client;
import Application.Operations.Atm;
import Application.Operations.Card;
import Application.Operations.Deposit;
import Application.Operations.Exchange;
import Application.Operations.Loan;
import Application.Operations.Operation;
import Application.Operations.Transaction;

import java.util.*;

public interface ModelInterface{

    int getClientMoney(int clientMoney,Operation operation);
    boolean transactionMoreMoney(Operation operation, Client client);
    void clientMoneyTransaction(Client client, Operation operation);
    boolean transactionLessMoney(Operation operation, Client client);
    void setTransactionAmount(Transaction transaction, Random random);
    boolean isTransaction(Operation operation,Transaction transaction);
    void setLoanMoneyClient(Client client, Operation operation);
    void setLoanId(Loan loan, Random random);
    void setLoanAmount(Loan loan,Random random);
    boolean isLoan(Operation operation, Loan loan);
    boolean exchangeMoreMoney(Operation operation,Client client);
    void euroExchanged2(Operation operation, Exchange exchange);
    void clientMoneyExchange2(Client client, Operation operation);
    boolean exchangeRateMore(Exchange exchange);
    void euroExchanged1(Operation operation, Exchange exchange);
    void clientMoneyExchange1 (Client client, Operation operation);
    boolean exchangeRateLess(Exchange exchange);
    boolean exchangeLessMoney(Operation operation, Client client);
    void setExchangeRate(Exchange exchange, Random random);
    void setExchangeAmount(Exchange exchange, Random random);
    boolean isExchange(Operation operation, Exchange exchange);
    boolean depositMoreMoney(Operation operation, Client client);
    void clientDepositLeft(Client client,Operation operation);
    boolean depositLessMoney(Operation operation, Client client);
    void setDepositId(Deposit deposit, Random random);
    void setDepositAmount(Operation operation, Random random);
    boolean isDeposit(Operation operation, Deposit deposit);
    boolean cardLessMoney(Operation operation, Client client);
    boolean cardMoreMoney(Operation operation, Client client);
    void clientCardMoney(Client client, Operation operation);
    void setPinCode(Card card,Random random);
    void setCardAmount(Card card, Random random);
    boolean isCard(Operation operation, Card card);
    void clientPutmoney(Client client, Random random);
    int getPutmoney( Random random);
    boolean atmMoreMoney(Operation operation, Client client);
    void clientMoney1(Client client, Operation operation);
    boolean moneyCheck(Operation operation, Client client);
    int getRandomChoice(Random random);
    void getAtmAmount(Random random, Atm atm);
    boolean isAtm(Operation operation, Atm atm);
    Operation getOperation(Random random, List<Operation> operations);
    int getNrofOperations(Random random);
    void getIdnp(Random random, Client client);
    void getMoney(Random random, Client client);
    int getNrofClients (Random random);
    List<Operation> getOperation(Atm atm, Card card, Exchange exchange, Loan loan, Transaction transaction, Deposit deposit);
    Scanner getScanner();
    Random getRandom();
    Deposit getDeposit();
    Transaction getTransaction();
    Atm getAtm();
    Loan getLoan();
    Exchange getExchange();
    Card getCard();
    Client getClient();

    boolean isEquals(String stop);
}
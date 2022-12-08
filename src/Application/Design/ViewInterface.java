package Application.Design;

import Application.BankClient.Client;
import Application.Operations.Exchange;
import Application.Operations.Loan;
import Application.Operations.Transaction;
import Application.Operations.Card;
import Application.Operations.Atm;
import Application.Operations.Operation;
import Application.Operations.Deposit;
import java.util.*;

public interface ViewInterface{

    void totalMoneySpent(int clientMoney);
    String getString(Scanner scanner);
    void exit();
    void monthCount(int i);
    void border();
    void transactionNoMoney();
    void moneyAfterTransaction(Client client);
    void succesfulTransaction();
    void makeTransaction(Operation operation);
    void moneyAfterLoan(Client client, Operation operation);
    void takeLoan1(Operation operation);
    void exchangeNoMoney();
    void clientexchangeMoney2(Client client,Operation operation);
    void euroGot2(Operation operation);
    void clientexchangeMoney1(Client client,Operation operation);
    void euroGot1(Operation operation);
    void exchangeRateSmall();
    void exchangeAmount(Operation operation);
    void exchangeRate(Exchange exchange);
    void depositNoMoney(Operation operation);
    void moneyleftClientDeposit(Client client);
    void moneyOnDeposit(Operation operation);
    void clientDeposit(Operation operation);
    void newDepositId(Deposit deposit);
    void clientCardNoMoney();
    void clientCardPutmoney(Client client);
    void moneyOnCard(int putmoney);
    void cardNoMoney();
    void clientMoneyCard1(Client client);
    void takeCardMoney(Operation operation);
    void viewPinCode(Card card);
    void pinCode();
    void clientMoneyAtm1(Client client);
    void putMoney(int putmoney);
    void notEnoughAtm();
    void clientMoneyAtm(Client client);
    void takeAtmMoney1(Operation operation);
    void getOperationName(Operation operation);
    void requireText();
    void clientEnter(Client client);
    void dayCount(int i);
}


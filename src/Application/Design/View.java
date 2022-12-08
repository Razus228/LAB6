package Application.Design;

import Application.Operations.Exchange;
import Application.Operations.Loan;
import Application.Operations.Transaction;
import Application.Operations.Card;
import Application.Operations.Atm;
import Application.BankClient.Client;
import Application.Operations.Operation;
import Application.Operations.Deposit;
import Application.Design.Model;
import Application.Design.ModelInterface;


import java.util.*;

public class View implements ViewInterface{

    @Override
    public void totalMoneySpent(int clientMoney){
        System.out.println("Money spent by Clients" + " " + clientMoney);
    }
    @Override
    public String getString(Scanner scanner) {
        String stop;
        stop = scanner.next();
        return stop;
    }
    @Override
    public void exit(){System.out.println("Press 0 to exit");}
    @Override
    public void monthCount(int i){
        System.out.println(i/30 + " " + "Month");
    }
    @Override
    public void border(){ System.out.println("***********************************");}
    @Override
    public void transactionNoMoney(){
        System.out.println("Transaction is not completed, not enough money");
    }
    @Override
    public void moneyAfterTransaction(Client client){
        System.out.println("Client now has" + " " + client.getMoney() + " " + " lei's left");
    }
    @Override
    public void succesfulTransaction(){
        System.out.println("Transaction completed");
    }
    @Override
    public void makeTransaction(Operation operation){
        System.out.println("Client wants to make a transaction of" + "  " + operation.getAmount());
    }
    @Override
    public void moneyAfterLoan(Client client, Operation operation){
        System.out.println("Client has" + " " + client.getMoney() + " " + "lei's and has to return to the bank" + " " + operation.getAmount());
    }
    @Override
    public void takeLoan1(Operation operation){
        System.out.println("Client takes a loan of" + " " + operation.getAmount() + " " + "lei's");
    }
    @Override
    public void exchangeNoMoney(){System.out.println("Client doesn't have money to exchange");}
    @Override
    public void clientexchangeMoney2(Client client,Operation operation){
        System.out.println("Client has" + " " + client.getMoney() + " " + "lei and" + " " + operation.getAmount() + " " + "euro");
    }
    @Override
    public void euroGot2(Operation operation){
        System.out.println("Client got" + " " + operation.getAmount() + " " + "euro");
    }
    @Override
    public void clientexchangeMoney1(Client client,Operation operation){
        System.out.println("Client has" + " " + client.getMoney() + " " + "lei and" + " " + operation.getAmount() + " " + "euro");
    }
    @Override
    public void euroGot1(Operation operation){
        System.out.println("Client got" + " " + operation.getAmount() + " " + "euro");
    }
    @Override
    public void exchangeRateSmall(){System.out.println("Client is gone because of the exchange rate");}
    @Override
    public void exchangeAmount(Operation operation){
        System.out.println("Client wants to exchange" + " " + operation.getAmount() + " " + "lei's");
    }
    @Override
    public void exchangeRate(Exchange exchange){
        System.out.println("Exchange rate is" + " " + exchange.getExchangeRateEuro());
    }
    @Override
    public void depositNoMoney(Operation operation){
        System.out.println("Client wants to deposit" + " " + operation.getAmount() + " " + " lei, but he doesn't have enough money");
    }
    @Override
    public void moneyleftClientDeposit(Client client){
        System.out.println("Client has" + " " + client.getMoney() + " " + "lei's");
    }
    @Override
    public void moneyOnDeposit(Operation operation){
        System.out.println("Client has" + " " + operation.getAmount() + " " + "lei's in bank");
    }
    @Override
    public void clientDeposit(Operation operation){
        System.out.println("Client deposits" + " " + operation.getAmount() + " " + "lei's");
    }
    @Override
    public void newDepositId(Deposit deposit){
        System.out.println("New deposit with id:" + " " + deposit.getId());
    }
    @Override
    public void clientCardNoMoney(){ System.out.println("Client doesn't have enough money");}
    @Override
    public void clientCardPutmoney(Client client){
        System.out.println("Client has" + " " + client.getMoney() + " " + "left");
    }
    @Override
    public void moneyOnCard(int putmoney){
        System.out.println("Client has" + " " + putmoney + " " + "on card");
    }
    @Override
    public void cardNoMoney(){System.out.println("tried to take, but Not enough money");}
    @Override
    public void clientMoneyCard1(Client client){
        System.out.println("Client has" + " " + client.getMoney() + " " + "left");
    }
    @Override
    public void takeCardMoney(Operation operation){
        System.out.println("takes" + " " + operation.getAmount() + " " + "money");
    }
    @Override
    public void viewPinCode(Card card){
        System.out.println("Pin code has been set" + " " + card.getPinCode());
    }
    @Override
    public void pinCode(){System.out.println("Enter pin code");}
    @Override
    public void clientMoneyAtm1(Client client){
        System.out.println("Client has" + " " + client.getMoney() + " ");
    }
    @Override
    public void putMoney(int putmoney){
        System.out.println("put" + " " + putmoney + " " + "money");
    }
    @Override
    public void notEnoughAtm(){ System.out.println("tried to take, but Not enough money");}
    @Override
    public void clientMoneyAtm(Client client){
        System.out.println("Client has" + " " + client.getMoney() + " " + "left");
    }
    @Override
    public void takeAtmMoney1(Operation operation){
        System.out.println("takes" + " " + operation.getAmount() + " " + "money");
    }
    @Override
    public void getOperationName(Operation operation){
        System.out.println(operation.getName());
    }
    @Override
    public void requireText(){
        System.out.println("Does :");
    }

    @Override
    public void clientEnter(Client client){
        System.out.println("Client with:" + " " + client.getIdnp() + " " + "id and " + client.getMoney() + " " + "lei" + " " + " enters the bank");
    }

    @Override
    public void dayCount(int i){
        System.out.println("Day" + " " + i);
    }

}


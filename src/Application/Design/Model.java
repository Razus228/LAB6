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

public class Model implements ModelInterface {

    public int getClientMoney(int clientMoney,Operation operation){
        clientMoney += operation.getAmount();
        return clientMoney;
    }

    @Override
    public boolean transactionMoreMoney(Operation operation, Client client){
        return operation.getAmount() > client.getMoney();
    }

    @Override
    public void clientMoneyTransaction(Client client, Operation operation){
        client.setMoney(client.getMoney() - operation.getAmount());
    }

    @Override
    public boolean transactionLessMoney(Operation operation, Client client){
        return operation.getAmount() < client.getMoney();
    }

    @Override
    public void setTransactionAmount(Transaction transaction, Random random){
        transaction.setAmount(random.nextInt(1000,5000));
    }

    @Override
    public boolean isTransaction(Operation operation,Transaction transaction){
        return operation.getClass().equals(Transaction.class);
    }

    @Override
    public void setLoanMoneyClient(Client client, Operation operation){
        client.setMoney(client.getMoney() + operation.getAmount());
    }

    @Override
    public void setLoanId(Loan loan, Random random){
        loan.setLoanId(random.nextInt(11111,99999));
    }

    @Override
    public void setLoanAmount(Loan loan,Random random){
        loan.setAmount(random.nextInt(1000,5000));
    }

    @Override
    public boolean isLoan(Operation operation, Loan loan){
        return operation.getClass().equals(Loan.class);
    }

    @Override
    public boolean exchangeMoreMoney(Operation operation,Client client){
        return operation.getAmount() > client.getMoney();
    }

    @Override
    public void euroExchanged2(Operation operation, Exchange exchange){
        operation.setAmount(operation.getAmount() / exchange.getExchangeRateEuro());
    }

    @Override
    public void clientMoneyExchange2(Client client, Operation operation){
        client.setMoney(client.getMoney() - operation.getAmount());
    }
    @Override
    public boolean exchangeRateMore(Exchange exchange){
        return exchange.getExchangeRateEuro() < 19.5;
    }


    @Override
    public void euroExchanged1(Operation operation, Exchange exchange){
        operation.setAmount(operation.getAmount() / exchange.getExchangeRateEuro());
    }

    @Override
    public void clientMoneyExchange1 (Client client, Operation operation){
        client.setMoney(client.getMoney() - operation.getAmount());
    }

    @Override
    public boolean exchangeRateLess(Exchange exchange){
        return exchange.getExchangeRateEuro() < 19.5;
    }

    @Override
    public boolean exchangeLessMoney(Operation operation, Client client){
        return operation.getAmount() <= client.getMoney();
    }
    @Override
    public void setExchangeRate(Exchange exchange, Random random){
        exchange.setExchangeRateEuro(random.nextFloat(19,20));
    }

    @Override
    public void setExchangeAmount(Exchange exchange, Random random){
        exchange.setAmount(random.nextInt(1000,5000));
    }

    @Override
    public boolean isExchange(Operation operation, Exchange exchange){
        return operation.getClass().equals(Exchange.class);
    }

    @Override
    public boolean depositMoreMoney(Operation operation, Client client){
        return operation.getAmount() > client.getMoney();
    }

    @Override
    public void clientDepositLeft(Client client,Operation operation){
        client.setMoney(client.getMoney() - operation.getAmount());
    }

    @Override
    public boolean depositLessMoney(Operation operation, Client client){
        return operation.getAmount() <= client.getMoney();
    }

    @Override
    public void setDepositId(Deposit deposit, Random random){
        deposit.setId(random.nextInt(11111,99999));
    }

    @Override
    public void setDepositAmount(Operation operation, Random random){
        operation.setAmount(random.nextInt(1000,5000));
    }

    @Override
    public boolean isDeposit(Operation operation, Deposit deposit){
        return operation.getClass().equals(Deposit.class);
    }

    @Override
    public boolean cardLessMoney(Operation operation, Client client){
        return operation.getAmount() <= client.getMoney();
    }

    @Override
    public boolean cardMoreMoney(Operation operation, Client client){
        return operation.getAmount() > client.getMoney();
    }

    @Override
    public void clientCardMoney(Client client, Operation operation){
        client.setMoney(client.getMoney() - operation.getAmount());
    }

    @Override
    public void setPinCode(Card card,Random random){
        card.setPinCode(random.nextInt(1111,9999));
    }

    @Override
    public void setCardAmount(Card card,Random random){
        card.setAmount(random.nextInt(1,5000));
    }

    public boolean isCard(Operation operation, Card card){
        return operation.getClass().equals(Card.class);
    }

    @Override
    public void clientPutmoney(Client client, Random random){
        client.setMoney(client.getMoney() - getPutmoney(random));
    }

    @Override
    public int getPutmoney(Random random){
        int putmoney = 0;
        putmoney = random.nextInt(1,2000);
        return putmoney;
    }

    @Override
    public boolean atmMoreMoney(Operation operation, Client client){
        return operation.getAmount() > client.getMoney();
    }

    public void clientMoney1 (Client client, Operation operation){
        client.setMoney(client.getMoney() + operation.getAmount());
    }
    @Override
    public boolean moneyCheck(Operation operation, Client client){
        return operation.getAmount() <= client.getMoney();
    }

    @Override
    public int getRandomChoice(Random random){
        int randomchoice;
        randomchoice = random.nextInt(1,8);
        return randomchoice;
    }

    @Override
    public void getAtmAmount(Random random,Atm atm){
        atm.setAmount(random.nextInt(1000,9999));
    }

    @Override
    public boolean isAtm(Operation operation, Atm atm){
       return operation.getClass().equals(Atm.class);
    }

    @Override
    public Operation getOperation(Random random, List<Operation> operations){
        return operations.get(random.nextInt(operations.size()));
    }

    @Override
    public int getNrofOperations(Random random){
        int nrofOperations;
        nrofOperations = random.nextInt(1,2);
        return nrofOperations;
    }

    @Override
    public void getIdnp(Random random, Client client) {client.setIdnp(random.nextInt(1000,9999));}

    @Override
    public void getMoney(Random random, Client client) {
        client.setMoney(random.nextInt(0,10000));
    }

    @Override
    public int getNrofClients(Random random) {
        int nrofClients;
        nrofClients = random.nextInt(1,9);
        return nrofClients;
    }

    @Override
    public List<Operation> getOperation(Atm atm, Card card, Exchange exchange, Loan loan, Transaction transaction, Deposit deposit){
        return new ArrayList<>(List.of(atm, card, exchange, deposit, loan, transaction));
    }

    @Override
    public Scanner getScanner() {return new Scanner(System.in);}

    @Override
    public Random getRandom() {return new Random();}

    @Override
    public Deposit getDeposit() {
        return new Deposit("Take Deposit",0,0);
    }

    @Override
    public Transaction getTransaction() {
        return new Transaction(0,"Make Transaction");
    }

    @Override
    public Atm getAtm() {
        return new Atm(0,0,0,"Use Atm");
    }

    @Override
    public Loan getLoan() {
        return new Loan(0,"Take Loan",0);
    }

    @Override
    public Exchange getExchange() {
        return new Exchange(0,"Exchange", 0);
    }
    @Override
    public Card getCard(){return new Card(0,0,0,0,"Use Card");}
    @Override
    public Client getClient(){return new Client(0,0);}

    @Override
    public boolean isEquals(String stop) {return stop.equals("0");}





}

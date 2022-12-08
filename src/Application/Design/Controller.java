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

public class Controller implements ControllerInterface{

    ModelInterface model = new Model();
    ViewInterface view = new View();


    public void display(){
        Client client = model.getClient();
        Card card = model.getCard();
        Exchange exchange = model.getExchange();
        Loan loan = model.getLoan();
        Atm atm = model.getAtm();
        Transaction transaction = model.getTransaction();
        Deposit deposit = model.getDeposit();
        Random random = model.getRandom();
        Scanner scanner = model.getScanner();
        int nrofClient = 0;
        int nrofOperations = 0;
        int clientMoney = 0;
        String stop;
        List<Operation> operations = model.getOperation(atm, card, exchange, loan, transaction, deposit);
        boolean b = true;
        for (int i = 1; b; i++){
            view.dayCount(i);
            nrofClient = model.getNrofClients(random);
            for (int j = 1; j <= nrofClient; j++){
                model.getMoney(random,client);
                model.getIdnp(random,client);
                view.clientEnter(client);

                nrofOperations = model.getNrofOperations(random);
                view.requireText();
                for (int k = 1; k <= nrofOperations; k++){
                    Operation operation = model.getOperation(random,operations);
                    view.getOperationName(operation);
                    if (model.isAtm(operation,atm)){
                        model.getAtmAmount(random, atm);
                        int randomchoice = model.getRandomChoice(random);
                            if (randomchoice > 5){
                                if (model.moneyCheck(operation, client)){
                                    view.takeAtmMoney1(operation);

                                    model.clientMoney1(client, operation);

                                    view.clientMoneyAtm(client);
                                } else if (model.atmMoreMoney(operation, client)){
                                    view.notEnoughAtm();
                                }
                            }
                            else {
                                int putmoney = model.getPutmoney(random);

                                model.clientPutmoney(client,random);

                                view.putMoney(putmoney);

                                view.clientMoneyAtm1(client);
                            }
                    }
                    if (model.isCard(operation,card)){
                        model.setCardAmount(card, random);
                        view.pinCode();
                        model.setPinCode(card,random);
                        view.viewPinCode(card);
                        int randomchoice = model.getRandomChoice(random);
                        if (randomchoice > 5) {
                            if (model.cardLessMoney(operation,client)) {
                                view.takeCardMoney(operation);
                                model.clientCardMoney(client, operation);
                                view.clientMoneyCard1(client);
                            } else if (model.cardMoreMoney(operation, client))
                                view.cardNoMoney();
                        }
                        else if (model.cardLessMoney(operation,client)){
                            int putmoney = model.getPutmoney(random);
                            model.clientPutmoney(client,random);
                            view.putMoney(putmoney);
                            view.moneyOnCard(putmoney);
                            view.clientCardPutmoney(client);
                        }
                        else if (model.cardMoreMoney(operation,client)){
                            view.clientCardNoMoney();
                        }
                    }
                    if (model.isDeposit(operation,deposit)){
                        model.setDepositAmount(operation,random);
                        model.setDepositId(deposit,random);
                        view.newDepositId(deposit);
                        int randomchoice = model.getRandomChoice(random);
                        if (randomchoice > 4){
                            if (model.depositLessMoney(operation,client)){
                                view.clientDeposit(operation);
                                model.clientDepositLeft(client,operation);
                                view.moneyOnDeposit(operation);
                                view.moneyleftClientDeposit(client);
                            } else if (model.depositMoreMoney(operation,client)){
                                view.depositNoMoney(operation);
                            }
                        }
                    }
                    if (model.isExchange(operation,exchange)){
                        model.setExchangeAmount(exchange,random);
                        model.setExchangeRate(exchange,random);
                        view.exchangeRate(exchange);
                        view.exchangeAmount(operation);
                        if (model.exchangeLessMoney(operation,client)){
                            if (model.exchangeRateLess(exchange)){
                                int randomchoice = model.getRandomChoice(random);
                                if (randomchoice > 5) {
                                    view.exchangeRateSmall();
                                }
                                else {
                                    model.clientMoneyExchange1(client,operation);
                                    model.euroExchanged1(operation,exchange);
                                    view.euroGot1(operation);
                                    view.clientexchangeMoney1(client,operation);
                                }
                            }
                            else if (model.exchangeRateMore(exchange)){
                                model.clientMoneyExchange2(client,operation);
                                model.euroExchanged2(operation,exchange);
                                view.euroGot2(operation);
                                view.clientexchangeMoney2(client,operation);
                            }
                        } else if (model.exchangeMoreMoney(operation,client)){
                            view.exchangeNoMoney();
                        }
                    }
                    if (model.isLoan(operation,loan)){
                        model.setLoanAmount(loan,random);
                        model.setLoanId(loan,random);
                        view.takeLoan1(operation);
                        model.setLoanMoneyClient(client,operation);
                        view.moneyAfterLoan(client,operation);
                    }
                    if (model.isTransaction(operation,transaction)){
                        model.setTransactionAmount(transaction,random);
                        view.makeTransaction(operation);
                        if (model.transactionLessMoney(operation,client)){
                            view.succesfulTransaction();
                            model.clientMoneyTransaction(client,operation);
                            view.moneyAfterTransaction(client);
                        }
                        else if (model.transactionMoreMoney(operation,client)) {
                            view.transactionNoMoney();
                        }
                    }
                    clientMoney = model.getClientMoney(clientMoney, operation);
                }
            }
            view.border();
            if (i % 30 == 0){
                view.border();
                view.monthCount(i);
                view.exit();
                stop = view.getString(scanner);
                if (model.isEquals(stop)){
                    view.border();
                    view.totalMoneySpent(clientMoney);
                    b = false;
                }
            }
        }
    }

}
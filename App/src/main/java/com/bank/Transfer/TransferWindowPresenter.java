package com.bank.Transfer;

import com.bank.DAO.ClientDAO;
import com.bank.DAO.ClientDAO_DB;
import com.bank.InformationWindow.BoxWindow;
import com.bank.Menu.Client;
import com.bank.Menu.MenuWindowPresenter;
import com.bank.Menu.MenuWindowPresenterFactory;

import java.math.BigDecimal;
import java.util.Optional;

public class TransferWindowPresenter {
    private final TransferWindowView view;
    private Client client;
    public TransferWindowPresenter(TransferWindowView view) {
        this.view = view;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void showCreator(){
        view.showCreator();
    }

    public void goBackToMenu() {
        MenuWindowPresenter presenter = new MenuWindowPresenterFactory(view.getParent()).create();
        presenter.setClient(client);
        presenter.showCreator();
    }

    public void transferMoney(String money, String title, String where) {
        //check the fields
        if(!validateFields(money, title, where)) return;

        BigDecimal money_to_transfer;
        money_to_transfer = new BigDecimal(money).multiply(BigDecimal.valueOf(100));

        Optional<char[]> authorization_pass = BoxWindow.getAuthorization(); //get the password
        if(authorization_pass.isEmpty()) return;

        ClientDAO database = new ClientDAO_DB();
        boolean isTransferred = database.transferMoney(client, authorization_pass.get(), where, money_to_transfer);
        if(isTransferred){
            updateClientMoney(money_to_transfer);
        }
        else {
            BoxWindow.infoBox("Coś poszło nie tak :/", "Błąd");
        }
    }

    private boolean validateFields(String money, String title, String where){
        if(!money.matches("^[0-9.]+$")){
            BoxWindow.infoBox("Podano wartość pieniedzy jest nie poprawna", "Błąd");
            return false;
        }
        else{
            BigDecimal givenMoney = new BigDecimal(money);
            if(givenMoney.compareTo(client.getMoney()) > 0){
                //Client doesn't have that much money
                BoxWindow.infoBox("Nie masz wystarczająco dużo pieniedzy", "Błąd");
                return false;
            }
        }
        if(!title.matches("^[a-zA-Z0-9.,_]{3,25}+$")){
            BoxWindow.infoBox("Podany tytuł jest nie prawidłowy", "Błąd");
            return false;
        }
        if(!where.matches("^[A-Z0-9]{12}")){
            BoxWindow.infoBox("Podano nie prawidły number banku", "Błąd");
            return false;
        }
        return true;
    }

    private void updateClientMoney(BigDecimal transferred_money) {
        client = new Client(
                client.getClientID(),
                client.getNick(),
                client.getName(),
                client.getLast_name(),
                client.getEmail(),
                client.getPhone(),
                client.getMoney().subtract(transferred_money),
                client.getAc_number()
        );
    }
}

package com.bank.Menu;

import com.bank.AccountDetails.AccountDetailsPresenter;
import com.bank.AccountDetails.AccountDetailsPresenterFactory;
import com.bank.AccountDetails.ClientDetails;
import com.bank.Login.LoginWindowPresenter;
import com.bank.Login.LoginWindowPresenterFactory;
import com.bank.Transfer.TransferWindowPresenter;
import com.bank.Transfer.TransferWindowPresenterFactory;


public class MenuWindowPresenter {
    private final MenuWindowView view;
    private Client client;
    public MenuWindowPresenter(MenuWindowView view) {
        this.view = view;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public void showCreator(){ view.showCreator(client); }

    public void account() {
        AccountDetailsPresenter accountDetailsPresenter = new AccountDetailsPresenterFactory()
                .create(client, this);
        accountDetailsPresenter.showAccount();
    }

    public void update(ClientDetails clientDetails){
        client = new Client(
                client.getClientID(),
                clientDetails.getNick(),
                clientDetails.getName(),
                clientDetails.getLast_name(),
                clientDetails.getEmail(),
                clientDetails.getPhone(),
                clientDetails.getMoney(),
                clientDetails.getAc_number()
        );
        view.showCreator(client);
    }

    public void transfer() {
        TransferWindowPresenter presenter = new TransferWindowPresenterFactory(view.getParent()).create();
        presenter.setClient(client);
        presenter.showCreator();
    }

    public void logout() {
        LoginWindowPresenter loginWindowPresenter =new LoginWindowPresenterFactory(view.getParent()).create();
        loginWindowPresenter.showLogin();
    }
}

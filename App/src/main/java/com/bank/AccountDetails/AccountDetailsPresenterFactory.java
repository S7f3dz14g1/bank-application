package com.bank.AccountDetails;

import com.bank.Menu.Client;
import com.bank.Menu.MenuWindowPresenter;

public class AccountDetailsPresenterFactory {

    public AccountDetailsPresenter create(Client client, MenuWindowPresenter menu){
        AccountDetailsView view = new AccountDetailsView();
        AccountDetailsPresenter presenter = new AccountDetailsPresenter(view, client, menu);
        view.setPresenter(presenter);
        return presenter;
    }
}

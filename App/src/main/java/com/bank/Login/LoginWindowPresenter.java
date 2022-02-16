package com.bank.Login;


import com.bank.DAO.ClientDAO_DB;
import com.bank.InformationWindow.BoxWindow;
import com.bank.Menu.Client;
import com.bank.Menu.MenuWindowPresenter;
import com.bank.Menu.MenuWindowPresenterFactory;
import com.bank.Registration.RegistrationWindowPresenter;
import com.bank.Registration.RegistrationWindowPresenterFactory;


public class LoginWindowPresenter {
    private final LoginWindowView view;

    public LoginWindowPresenter(LoginWindowView view) {
        this.view = view;
    }

    public void showLogin() {
        view.showCreator();
    }

    public void login(String login, char[] password) {
        Client client = new ClientDAO_DB().getClient(login, password);
        if(client != null){
            showMenu(client);
        }
        else{
            BoxWindow.infoBox("Nie poprawny login lub hasło", "Błąd logowania");
        }
    }

    public void showRegistration(){
        RegistrationWindowPresenter registrationWindowPresenter=new RegistrationWindowPresenterFactory(view.getParent()).create();
        registrationWindowPresenter.showCreator();
    }

    public void showMenu(Client client){
        MenuWindowPresenter menuWindowPresenter = new MenuWindowPresenterFactory(view.getParent()).create();
        menuWindowPresenter.setClient(client);
        menuWindowPresenter.showCreator();
    }


}

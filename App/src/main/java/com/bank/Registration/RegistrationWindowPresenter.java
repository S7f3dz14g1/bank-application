package com.bank.Registration;

import com.bank.DAO.ClientDAO_DB;
import com.bank.InformationWindow.BoxWindow;
import com.bank.Login.LoginWindowPresenter;
import com.bank.Login.LoginWindowPresenterFactory;

import java.util.Random;

public class RegistrationWindowPresenter {
    private RegistrationWindowView view;

    private ClientDAO_DB clientDAO_db=new ClientDAO_DB();

    public RegistrationWindowPresenter(RegistrationWindowView presenter) {
        this.view = presenter;
    }

    public void showCreator(){ view.showCreator(); }

    public String generateBankNumber(){
        Random random=new Random();
        int bankNumber =random.nextInt(999999999);
        return "450"+bankNumber;
    }

    private boolean validateFields() {
        if(!view.getPassword1().getText().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,12}$")){
            BoxWindow.infoBox("Podane hasło jest nie poprawne", "Błąd");
            return false;
        }
        if(!view.getPassword1().getText().equals(view.getPassword2().getText())){
            BoxWindow.infoBox("Podane hasła nie są identyczne", "Błąd");
            return false;
        }
        if(!view.getLogin().getText().matches("^[a-zA-Z0-9]{3,12}+$")){
            BoxWindow.infoBox("Podany login jest nie poprawny", "Błąd");
            return false;
        }
        if(clientDAO_db.checkUserName(view.getLogin().toString())){
            BoxWindow.infoBox("Podany login istnieje. Podaj inny", "Błąd");
            return false;
        }
        if(!view.getName().getText().matches("^[a-zA-Z\\\\p{L}]{3,20}+$")){
            BoxWindow.infoBox("Podane imie jest błędne", "Błąd");
            return false;
        }
        if(!view.getLastName().getText().matches("^[a-zA-Z\\\\p{L}]{3,25}+$")){
            BoxWindow.infoBox("Podane nazwisko jest błędne", "Błąd");
            return false;
        }
        if(!view.getMail().getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            BoxWindow.infoBox("Podany email jest nie poprawny", "Błąd");
            return false;
        }
        if (clientDAO_db.checkEmail(view.getMail().toString())) {
            BoxWindow.infoBox("Podany emeil istnieje. Podaj inny", "Błąd");
            return false;
        }
        if(!view.getPhone().getText().matches("^[0-9]{9,12}+$")){
            BoxWindow.infoBox("Podany numer telefonu jest nie poprawny", "Błąd");
            return false;
        }
        return true;
    }

    public void registration(){
        if(validateFields()){

            //Create account number and check if it's unique
            String account_number = generateBankNumber();
            while(clientDAO_db.checkAccountNumber(account_number)){
                account_number = generateBankNumber();
            }

            NewClient newClient = new NewClient(
                    view.getLogin().getText(),
                    view.getPassword1().getText(),
                    view.getName().getText(),
                    view.getLastName().getText(),
                    view.getMail().getText(),
                    view.getPhone().getText(),
                    account_number
            );
            if(clientDAO_db.addClient(newClient)){
                BoxWindow.infoBox("Konto zostało założone","Potwierdzenie");
            }
            else{
                BoxWindow.infoBox("Coś poszło nie tak :/","Błąd");
            }
            //Back to login window

            backToLoginWindow();
        }
    }

    public void backToLoginWindow() {
        LoginWindowPresenter loginWindowPresenter =new LoginWindowPresenterFactory(view.getParent()).create();
        loginWindowPresenter.showLogin();
    }
}

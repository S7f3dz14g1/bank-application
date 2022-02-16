package com.bank.AccountDetails;

import com.bank.DAO.ClientDAO;
import com.bank.DAO.ClientDAO_DB;
import com.bank.InformationWindow.BoxWindow;
import com.bank.Menu.Client;
import com.bank.Menu.MenuWindowPresenter;

import java.util.Optional;

public class AccountDetailsPresenter {
    final private AccountDetailsView view;
    final private MenuWindowPresenter menu;
    private boolean edit;
    private ClientDetails clientDetails;
    private ClientDetails clientDetailsBackUp;
    public AccountDetailsPresenter(AccountDetailsView view, Client client, MenuWindowPresenter menu) {
        this.view = view;
        this.edit = false;
        this.menu = menu;
        clientDetails = new ClientDetails(
                client.getNick(),
                client.getName(),
                client.getLast_name(),
                client.getEmail(),
                client.getPhone(),
                client.getMoney(),
                client.getAc_number()
        );
        clientDetailsBackUp = new ClientDetails(
                client.getNick(),
                client.getName(),
                client.getLast_name(),
                client.getEmail(),
                client.getPhone(),
                client.getMoney(),
                client.getAc_number()
        );
    }

    public void showAccount() {
        view.showCreator(clientDetails);
    }

    public void editButtonClicked() {
        if(edit){
            cancelChanges();
            turnOffEditableMode();
        }
        else{
            turnOnEditableMode();
        }
    }

    private void turnOffEditableMode(){
        view.setFieldsDisable();
        view.getSaveButton().setDisable(true);
        changeEditButton();
        edit = false;
    }

    private void turnOnEditableMode(){
        view.setFieldsEditable();
        changeEditButton();
        edit = true;
    }

    private void cancelChanges() {
        view.getNameField().setText(clientDetailsBackUp.getName());
        view.getLastNameField().setText(clientDetailsBackUp.getLast_name());
        view.getEmailField().setText(clientDetailsBackUp.getEmail());
        view.getPhoneField().setText(clientDetailsBackUp.getPhone());
    }

    public void fieldWasChanged() {
        view.getSaveButton().setDisable(false);
    }

    private void changeEditButton() {
        if (!edit)
            view.getEditButton().setText("Anuluj");
        else
            view.getEditButton().setText("Edytuj");
    }

    protected void saveData() {
        turnOffEditableMode();
        if(!validateFields()) return;

        Optional<char[]> authorization_pass = BoxWindow.getAuthorization();
        if(authorization_pass.isEmpty()) return;
        updateClientObject();

        ClientDAO database = new ClientDAO_DB();

        if(database.updateClient(clientDetails, authorization_pass.get()))
            menu.update(clientDetails);
        else cancelChanges();
    }

    private boolean validateFields() {
        if(!view.getNameField().getText().matches("^[a-zA-Z\\\\p{L}]{3,20}+$")){
            BoxWindow.infoBox("Podane imie jest nie poprawne", "Błąd");
            return false;
        }
        if(!view.getLastNameField().getText().matches("^[a-zA-Z\\p{L}]{3,25}+$")){
            BoxWindow.infoBox("Podane nazwisko jest nie poprawne", "Błąd");
            return false;
        }
        if(!view.getEmailField().getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            BoxWindow.infoBox("Podany email jest nie poprawny", "Błąd");
            return false;
        }
        if(!view.getPhoneField().getText().matches("^[0-9]{9,12}+$")){
            BoxWindow.infoBox("Podany numer telefonu jest nie poprawny", "Błąd");
            return false;
        }
        return true;
    }

    private void updateClientObject(){
        clientDetails = new ClientDetails(
                clientDetails.getNick(),
                view.getNameField().getText(),
                view.getLastNameField().getText(),
                view.getEmailField().getText(),
                view.getPhoneField().getText(),
                clientDetails.getMoney(),
                clientDetails.getAc_number()
        );
    }
}

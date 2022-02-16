package com.bank.AccountDetails;

import com.bank.BankHelper;
import com.bank.Menu.Client;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.math.BigDecimal;

public class AccountDetailsView {
    private AccountDetailsPresenter presenter;
    private TextField nameField;
    private TextField lastNameField;
    private TextField emailField;
    private TextField phoneField;
    private Button saveButton;
    private Button editButton;


    public void setPresenter(AccountDetailsPresenter presenter) {
        this.presenter = presenter;
    }

    public void showCreator(ClientDetails clientDetails) {
        nameField = new TextField(clientDetails.getName());
        lastNameField = new TextField(clientDetails.getLast_name());
        emailField = new TextField(clientDetails.getEmail());
        phoneField = new TextField(clientDetails.getPhone());
        setFieldsDisable();

        setListeners();

        editButton = new Button("Edytuj");
        editButton.setMinWidth(50);

        editButton.setOnMouseClicked(event -> {
            presenter.editButtonClicked();
        });

        saveButton = new Button("Zapisz");
        saveButton.setOnMouseClicked(event -> {
            presenter.saveData();
        });
        saveButton.setDisable(true);


        BigDecimal money = BankHelper.formatMoney(clientDetails.getMoney());

        String account_number = BankHelper.formatAccountNumber(clientDetails.getAc_number());


        GridPane content = new GridPane();
        content.setStyle("-fx-font-size: 14");
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(10, 15, 10, 15));
        content.setHgap(5);
        content.setVgap(5);
        content.addRow(0, new Label("Imie:"), nameField);
        content.addRow(1, new Label("Nazwisko:"), lastNameField);
        content.addRow(2, new Label("Email:"), emailField);
        content.addRow(3, new Label("Telefon:"), phoneField);
        content.addRow(4, new Label(""));
        content.addRow(5, new Label("Saldo:"), new Label(money.toString() + " PLN"));
        content.addRow(6, new Label("Nr. konta:"), new Label(account_number));
        content.addRow(7, new Label(""));
        content.addRow(8, editButton, saveButton);

        Dialog<Client> itemDialog = new Dialog<>();
        itemDialog.setTitle("Wiadomość");
        itemDialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

        itemDialog.getDialogPane().setContent(content);
        itemDialog.show();
    }

    private void setListeners() {
        nameField.textProperty().addListener((observable -> presenter.fieldWasChanged()));
        lastNameField.textProperty().addListener((observable -> presenter.fieldWasChanged()));
        emailField.textProperty().addListener((observable -> presenter.fieldWasChanged()));
        phoneField.textProperty().addListener((observable -> presenter.fieldWasChanged()));
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setFieldsEditable() {
        String css = ".text-field:readonly {" +
                "   -fx-background-color: #E0E0E2;\n" +
                "   -fx-border-color: #94BBDA;\n" +
                "   -fx-text-fill: #000000;\n" +
                "}";
        setFieldFormat(false, css);
    }

    public void setFieldFormat(Boolean disabled, String css) {
        nameField.setDisable(disabled);
        lastNameField.setDisable(disabled);
        emailField.setDisable(disabled);
        phoneField.setDisable(disabled);
        nameField.setStyle(css);
        lastNameField.setStyle(css);
        emailField.setStyle(css);
        phoneField.setStyle(css);
    }

    public void setFieldsDisable() {
        String css = ".text-field:disabled {\n" +
                "   -fx-background-color: #E0E0E2;\n" +
                "   -fx-border-color: #94BBDA;\n" +
                "   -fx-text-fill: #000000;\n" +
                "}";
        setFieldFormat(true, css);
    }

    protected TextField getNameField() {
        return nameField;
    }

    protected TextField getEmailField() {
        return emailField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    protected TextField getPhoneField() {
        return phoneField;
    }
}


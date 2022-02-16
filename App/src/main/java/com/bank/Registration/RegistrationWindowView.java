package com.bank.Registration;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class RegistrationWindowView {
    private RegistrationWindowPresenter presenter;
    private Pane parent;
    
    public RegistrationWindowView(Pane pane) {
        this.parent = pane;
    }

    public void setPresenter(RegistrationWindowPresenter presenter) {
        this.presenter = presenter;
    }

    Button registration_button = new Button("Rejestracja");
    Button back_button = new Button("Wstecz");
    TextField login_field = new TextField();
    PasswordField password_field1 = new PasswordField();
    PasswordField password_field2 = new PasswordField();
    TextField email_field = new TextField();
    TextField name_field = new TextField();
    TextField last_name_field = new TextField();
    TextField phone_field = new TextField();

    public void showCreator(){

        registration_button.setOnMouseClicked(event -> {
            presenter.registration();
        });
        back_button.setOnMouseClicked(event ->presenter.backToLoginWindow());

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.addRow(0, new Label("Login:"), login_field);
        gridPane.addRow(1, new Label("Hasło:"), password_field1);
        gridPane.addRow(2, new Label("Hasło:"), password_field2);
        gridPane.addRow(3, new Label("Imie:"), name_field);
        gridPane.addRow(4, new Label("Nazwisko:"), last_name_field);
        gridPane.addRow(5, new Label("Nr_tel:"), phone_field);
        gridPane.addRow(6, new Label("Mejl:"), email_field);
        gridPane.addRow(7, registration_button,back_button);
        parent.getChildren().clear();
        parent.getChildren().add(gridPane);

    }
    protected Pane getParent(){ return parent; }


    protected TextField getLogin(){return  login_field;}
    protected TextField getPassword1(){return  password_field1;}
    protected TextField getPassword2(){return  password_field2;}
    protected TextField getName(){return  name_field;}
    protected TextField getLastName(){return  last_name_field;}
    protected TextField getPhone(){return  phone_field;}
    protected TextField getMail(){return  email_field;}
}

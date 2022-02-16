package com.bank.Login;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class LoginWindowView {
    private final Pane parent;
    private LoginWindowPresenter presenter;

    public LoginWindowView(Pane parent) {
        this.parent = parent;
    }

    public void setPresenter(LoginWindowPresenter presenter) {
        this.presenter = presenter;
    }

    public void showCreator(){
        TextField login_field = new TextField();
        PasswordField password_field = new PasswordField();

        Button login_button = new Button("Login");
        Button registration_button = new Button("Registration");


        login_button.setOnMouseClicked(event -> {
            presenter.login(login_field.getText(), password_field.getText().toCharArray());
        });

        parent.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                presenter.login(login_field.getText(), password_field.getText().toCharArray());
        });

        registration_button.setOnMouseClicked(event -> {
            presenter.showRegistration();
        });

        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(112, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.addRow(0, new Label("Login:"), login_field);
        gridPane.addRow(1, new Label("Password:"), password_field);
        gridPane.addRow(2);
        gridPane.addRow(3, login_button,registration_button);


        parent.getChildren().clear();
        parent.getChildren().add(gridPane);
    }

    protected Pane getParent(){ return parent; }
}

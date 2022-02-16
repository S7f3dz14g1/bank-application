package com.bank.Menu;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MenuWindowView {
    private final Pane parent;
    private MenuWindowPresenter presenter;
    public MenuWindowView(Pane parent) {
        this.parent = parent;
    }

    public void setPresenter(MenuWindowPresenter presenter) {
        this.presenter = presenter;
    }

    public void showCreator(Client client){
        Button show_button = new Button("Konto");
        Button transfer_button = new Button("Przelew");
        Button logout_button = new Button("Wyloguj");

        show_button.setPrefWidth(70);
        transfer_button.setPrefWidth(70);
        logout_button.setPrefWidth(70);

        show_button.setOnMouseClicked(event -> { presenter.account();});
        transfer_button.setOnAction(event -> {presenter.transfer();});
        logout_button.setOnMouseClicked(event -> {presenter.logout();});

        show_button.setAlignment(Pos.CENTER);
        transfer_button.setAlignment(Pos.CENTER);
        logout_button.setAlignment(Pos.CENTER);

        Label welcome = new Label(String.format("Witaj %s", client.getName()));

        welcome.setStyle("-fx-font-size: 18;" +
                "-fx-font-weight: bold;");
        welcome.setAlignment(Pos.CENTER);

        Label bank_menu = new Label("Menu Banku:");
        bank_menu.setStyle("-fx-font-size: 15;");

        bank_menu.setMinHeight(55);


        GridPane.setHalignment(show_button, HPos.CENTER);
        GridPane.setHalignment(transfer_button, HPos.CENTER);
        GridPane.setHalignment(logout_button, HPos.CENTER);
        GridPane.setHalignment(welcome, HPos.CENTER);
        GridPane.setHalignment(bank_menu, HPos.CENTER);

        GridPane header = new GridPane();
        header.setAlignment(Pos.TOP_CENTER);
        header.setPadding(new Insets(15));
        header.addRow(0, welcome);


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15, 10, 10, 5));
        gridPane.setVgap(8);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        //gridPane.addRow(0, welcome);
        gridPane.addRow(1, bank_menu);
        gridPane.addRow(2, show_button);
        gridPane.addRow(3, transfer_button);
        gridPane.addRow(4, logout_button);

        parent.getChildren().clear();
        parent.getChildren().addAll(header, gridPane);
    }

    protected Pane getParent() {
        return parent;
    }
}

package com.bank.Transfer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.swing.text.MaskFormatter;
import javax.xml.validation.Validator;

public class TransferWindowView {
    private final Pane parent;
    private TransferWindowPresenter presenter;

    public TransferWindowView(Pane parent) {
        this.parent = parent;
    }

    public void setPresenter(TransferWindowPresenter presenter) {
        this.presenter = presenter;
    }


    public void showCreator() {

        TextField money = new TextField();
        TextField title = new TextField();
        TextField where = new TextField();

        Label przelew = new Label("Przelew");
        przelew.setStyle("-fx-font-size: 18;"+
                "-fx-font-weight: bold;");

        GridPane header = new GridPane();
        header.setAlignment(Pos.TOP_CENTER);
        header.setPadding(new Insets(15));
        header.addRow(0, przelew);


        Button transfer_button = new Button("Zatwierdz");
        transfer_button.setOnAction(event -> {presenter.transferMoney(money.getText(), title.getText(), where.getText());});
        Button cancel = new Button("Wróc");
        cancel.setOnAction(event -> {presenter.goBackToMenu();});


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.addRow(0, new Label(""));
        gridPane.addRow(1, new Label("Nr konta: "), where);
        gridPane.addRow(2, new Label("Tytuł: "), title);
        gridPane.addRow(3, new Label("Ile: "), money);
        gridPane.addRow(4, transfer_button, cancel);


        parent.getChildren().clear();
        parent.getChildren().addAll(header, gridPane);
    }

    protected Pane getParent() {
        return parent;
    }
}

package com.bank.InformationWindow;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;


public class BoxWindow {

    public static void infoBox(String infoMessage, String titleBar)
    {
        infoBox(infoMessage, titleBar, null);
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    static public Optional<char[]> getAuthorization(){
        Dialog<char[]> dialog = new Dialog<>();
        dialog.setTitle("Autoryzacja");
        dialog.setHeaderText("Proszę podać hasło");

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Zatwierdz", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        //Create password field
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        PasswordField password = new PasswordField();
        password.setPromptText("Hasło");

        grid.add(new Label("Hasło:"), 0, 0);
        grid.add(password, 1, 0);


        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);


        password.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.length() < 8);
        });

        dialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(password::requestFocus);
        

        //Return password on click
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return password.getText().toCharArray();
            }
            return null;
        });

        return dialog.showAndWait();
    }
}

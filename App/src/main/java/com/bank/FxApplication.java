package com.bank;

import com.bank.Login.LoginWindowPresenter;
import com.bank.Login.LoginWindowPresenterFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane rootLayout = new VBox();

        Scene scene = new Scene(rootLayout);
        rootLayout.setStyle("-fx-font-size: 13;");
        LoginWindowPresenterFactory loginWindowPresenterFactory = new LoginWindowPresenterFactory(rootLayout);
        LoginWindowPresenter loginWindowPresenter = loginWindowPresenterFactory.create();
        loginWindowPresenter.showLogin();

        primaryStage.setResizable(false);
        primaryStage.setWidth(340);
        primaryStage.setHeight(380);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank");
        primaryStage.show();
    }
}
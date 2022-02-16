package com.bank.Login;

import javafx.scene.layout.Pane;

public class LoginWindowPresenterFactory {
    private final Pane root;

    public LoginWindowPresenterFactory(Pane rootLayout) {
        this.root = rootLayout;
    }

    public LoginWindowPresenter create(){
        LoginWindowView view = new LoginWindowView(root);
        LoginWindowPresenter presenter  = new LoginWindowPresenter(view);
        view.setPresenter(presenter);
        return presenter;
    }
}

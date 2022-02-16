package com.bank.Registration;

import javafx.scene.layout.Pane;

public class RegistrationWindowPresenterFactory {
    private final Pane root;

    public RegistrationWindowPresenterFactory(Pane root) {this.root = root;
    }

    public RegistrationWindowPresenter create(){
        RegistrationWindowView view = new RegistrationWindowView(root);
        RegistrationWindowPresenter presenter =new RegistrationWindowPresenter(view);
        view.setPresenter(presenter);
        return presenter;
    }
}

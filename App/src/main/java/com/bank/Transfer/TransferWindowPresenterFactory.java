package com.bank.Transfer;

import javafx.scene.layout.Pane;

public class TransferWindowPresenterFactory {
    private final Pane parent;

    public TransferWindowPresenterFactory(Pane parent) {
        this.parent = parent;
    }

    public TransferWindowPresenter create(){
        TransferWindowView view = new TransferWindowView(parent);
        TransferWindowPresenter presenter = new TransferWindowPresenter(view);
        view.setPresenter(presenter);
        return presenter;
    }
}

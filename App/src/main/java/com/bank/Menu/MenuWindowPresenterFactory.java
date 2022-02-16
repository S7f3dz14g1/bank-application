package com.bank.Menu;

import javafx.scene.layout.Pane;

public class MenuWindowPresenterFactory {
    private final Pane parent;
    public MenuWindowPresenterFactory(Pane parent) {
        this.parent = parent;
    }

    public MenuWindowPresenter create(){
        MenuWindowView view = new MenuWindowView(parent);
        MenuWindowPresenter presenter = new MenuWindowPresenter(view);
        view.setPresenter(presenter);
        return presenter;
    }
}

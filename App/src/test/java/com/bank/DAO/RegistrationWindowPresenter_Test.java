package com.bank.DAO;

import com.bank.Registration.RegistrationWindowPresenter;
import com.bank.Registration.RegistrationWindowPresenterFactory;
import com.bank.Registration.RegistrationWindowView;
import javafx.scene.layout.Pane;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationWindowPresenter_Test {

    @Test
     public void sprawdz_czy_ma_12_znakow(){
        RegistrationWindowPresenter presenter = new RegistrationWindowPresenterFactory(new Pane()).create();
        assertThat(presenter.generateBankNumber().length()).isEqualTo(12);

}


}

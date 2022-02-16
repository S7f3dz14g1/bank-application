package com.bank.DAO;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientDAO_DB_Test {
    @Test
    public void sprawdzenieGdyAdresIstnieje(){
        String number="PL4900012990";
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.checkAccountNumber(number)).isTrue();
    }

    @Test
    public void sprawdzenieGdyAdresNieIstnieje(){
        String number="PL4900012999";
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.checkAccountNumber(number)).isTrue();
    }

    @Test
    public void sprawdzenieGdyNIckIstnieje(){
        String Nick="Adam55";
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.checkUserName(Nick)).isTrue();
    }

    @Test
    public void sprawdzenieGdyNIckNieIstnieje(){
        String Nick="Adam56";
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.checkUserName(Nick)).isTrue();
    }

    @Test
    public void sprawdzenieGdyMejlNieIstnieje(){
        String Emeil="kowalski@gmail.com";
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.checkUserName(Emeil)).isTrue();
    }

    @Test
    public void sprawdzenieGdyMejlIstnieje(){
        String Emeil="kowal@gmail.com";
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.checkUserName(Emeil)).isTrue();
    }

    @Test
    public void sprawdzenieGdyDaneLogowaniaSaDobre(){
        String nick="Adam55";
        char[] password= new char[]{'1', '2', '3', '4', 'a', 'd', 'm', 'i', 'n'};
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.getClient(nick,password));
    }

    @Test
    public void sprawdzenieGdyHasloJestZle(){
        String nick="Adam55";
        char[] password= new char[]{'2', '2', '3', '4', 'a', 'd', 'm', 'i', 'n'};
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.getClient(nick,password));
    }

    @Test
    public void sprawdzenieGdyLoginJestZle(){
        String nick="Adam56";
        char[] password= new char[]{'1', '2', '3', '4', 'a', 'd', 'm', 'i', 'n'};
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.getClient(nick,password));
    }

    @Test
    public void sprawdzenieGdyWszystkoJestZle(){
        String nick="Adam55";
        char[] password= new char[]{'2', '2', '3', '4', 'a', 'd', 'm', 'i', 'n'};
        ClientDAO_DB clientDAO_db=new ClientDAO_DB();
        assertThat(clientDAO_db.getClient(nick,password));
    }
}

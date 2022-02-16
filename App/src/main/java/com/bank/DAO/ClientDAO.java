package com.bank.DAO;

import com.bank.AccountDetails.ClientDetails;

import com.bank.Menu.Client;
import com.bank.Registration.NewClient;

import java.math.BigDecimal;

public interface ClientDAO {
    Client getClient(String login, char[] password);
    boolean updateClient(ClientDetails student, char[] password);
    boolean transferMoney(Client client, char[] password, String ac_number, BigDecimal money);
    boolean addClient(NewClient newClient);
    boolean checkUserName(String user);
    boolean checkEmail(String email);
    boolean checkAccountNumber(String number);
}

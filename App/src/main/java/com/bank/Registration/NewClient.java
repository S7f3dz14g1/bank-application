package com.bank.Registration;

public class NewClient {
    final private String nick;
    final private String password1;
    final private String name;
    final private String last_name;
    final private String email;
    final private String phone;
    final private String account_number;


    public NewClient(String nick, String password1, String name, String last_name, String email, String phone, String account_number) {
        this.nick = nick;
        this.password1 = password1;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.account_number = account_number;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword1() {
        return password1;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAccountNumber() {
        return account_number;
    }
}

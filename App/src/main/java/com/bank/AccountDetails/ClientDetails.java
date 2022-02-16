package com.bank.AccountDetails;

import java.math.BigDecimal;

public class ClientDetails {
    final private String nick;
    final private String name;
    final private String last_name;
    final private String email;
    final private String phone;
    final private BigDecimal money;
    final private String ac_number;

    public ClientDetails(String nick, String name, String last_name, String email, String phone, BigDecimal money, String ac_number) {
        this.nick = nick;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.money = money;
        this.ac_number = ac_number;
    }

    public String getNick() {
        return nick;
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

    public BigDecimal getMoney() {
        return money;
    }

    public String getAc_number() {
        return ac_number;
    }
}

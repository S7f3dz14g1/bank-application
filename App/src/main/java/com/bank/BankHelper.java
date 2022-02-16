package com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankHelper {
    public static BigDecimal formatMoney(BigDecimal money) {
        BigDecimal rest = new BigDecimal("100");
        return money.divide(rest, 2, RoundingMode.HALF_UP);
    }

    public static String formatAccountNumber(String number) {
        return number.substring(0, 4) + " " + number.substring(4, 8) + " " + number.substring(8);
    }
}

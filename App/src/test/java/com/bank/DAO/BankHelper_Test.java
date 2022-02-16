package com.bank;

import com.bank.BankHelper;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;



public class BankHelper_Test{
    @Test
    public void metodaWiecejNiz0(){
        //gdy liczba jest większa niż 0
        //given
        BigDecimal bigDecimal1=new BigDecimal(1000);
        BigDecimal bigDecimal2=new BigDecimal(10.00);

        //when
        BigDecimal result=BankHelper.formatMoney(bigDecimal1);

        //then
        assertThat(bigDecimal1).isEqualTo(bigDecimal2);
    }

    @Test
    public void metodaMniejNiz0(){
        //gdy liczba jest mnijesza niż zero
        //given
        BigDecimal bigDecimal1=new BigDecimal(-112);
        BigDecimal bigDecimal2=new BigDecimal(1.12);

        //when
        BigDecimal result=BankHelper.formatMoney(bigDecimal1);

        //then
        assertThat(result).isEqualTo(bigDecimal2);
    }

}

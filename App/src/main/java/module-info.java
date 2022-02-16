module BankApp.main {
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.java;
   // requires org.assertj.core;
    opens com.bank;
}
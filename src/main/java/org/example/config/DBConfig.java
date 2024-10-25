package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private DBConfig() {
        throw new UnsupportedOperationException();
    }

    static String getUrl(){
        return "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    }

    static String getUser(){
        return "pf1910";
    }

    static String getPassword(){
        return "fiap24";
    }
}

package org.ancholib.utils;

import org.ancholib.AnchoLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {

    static Connection conn;

    static String url;
    static String username;
    static String password;

    DataBaseManager(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static boolean testConnection(){
        if(url == null){
            System.out.println(AnchoLib.getPrefix() + "DataBase URL was not set.");
            return false;
        }
        if(username == null){
            System.out.println(AnchoLib.getPrefix() + "DataBase Username was not set.");
            return false;
        }
        if(password == null){
            System.out.println(AnchoLib.getPrefix() + "DataBase Password was not set.");
            return false;
        }
        return true;
    }

    public static Connection establishConnection(){
        if(testConnection() == false) return null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            System.out.println(AnchoLib.getPrefix() + "There was an error that occurred when trying to connect to the DataBase.");
            System.out.println(AnchoLib.getPrefix() + "Please make sure your credentials are correct.");
        }
        return null;
    }
}

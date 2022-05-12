/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class Ex1 {

    public static void main(String[] args) {
        try {
           String dbDriver = "org.postgresql.Driver";
            String dbURL = "jdbc:postgresql://localhost:5432/postgres";
            // Database name to access

            String dbUsername = "postgres";
            String dbPassword = "shree9592";

            Class.forName(dbDriver);
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            new Gui("ex2", conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

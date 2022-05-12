/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex6;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class DBConn {

    static Connection conn = null;

    public static Connection getConnection() {
        try {
            if(conn == null)
            {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "shree9592");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
/**
 *
 * @author admin
 */
public class LoginCheck {
    public static boolean validate(int userid ,String password)
    {
        System.out.println("user id = " + userid);
        try {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "shree9592");
            System.out.println("connection done");
            
            PreparedStatement pstmt = conn.prepareStatement("select * from ajt.students where userid = ? and password = ?");
            pstmt.setInt(1,(userid));
            pstmt.setString(2,password);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

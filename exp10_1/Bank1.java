package exp10_1;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

/**
 *
 * @author admin
 */
public class Bank1 extends UnicastRemoteObject implements Bank {

    Bank1() throws RemoteException{
        super();
    }
    
    Connection conn = DBConn.getConnection();
    PreparedStatement pstmt = null;

    
    
    public void deposite(int acc_no, int money) {
        try {
            pstmt = conn.prepareStatement("select * from bank where acc_no = ?");
            pstmt.setInt(1, acc_no);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                pstmt = conn.prepareStatement("update bank set balance = ? where acc_no = ?");
                pstmt.setInt(1, rs.getInt("balance") + money);
                pstmt.executeUpdate();
            }
            printData(acc_no);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void withdraw(int acc_no, int money) {
        try {
            pstmt = conn.prepareStatement("select * from bank where acc_no = ?");
            pstmt.setInt(1, acc_no);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                pstmt = conn.prepareStatement("update bank set balance = ? where acc_no = ?");
                pstmt.setInt(1, rs.getInt("balance") - money);
                pstmt.executeUpdate();
            }
            printData(acc_no);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void showBalance(int acc_no)  {
        try {
            pstmt = conn.prepareStatement("select * from bank where acc_no = ?");
            pstmt.setInt(1, acc_no);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println( rs.getInt("balance") + "");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    private void printData(int acc_no) {
        try {
            pstmt = conn.prepareStatement("select * from bank where acc_no = ?");
            pstmt.setInt(1, acc_no);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("\n Name : " + rs.getString("name") + "\n Account Number : " + rs.getInt("acc_no") + "\n Balance : " + rs.getInt("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

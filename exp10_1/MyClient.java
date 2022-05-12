package exp10_1;


import java.rmi.*;

public class MyClient {

    public static void main(String args[]) throws Exception {
        Bank b = (Bank) Naming.lookup("rmi://localhost:6999/maniya");
        
        
       b.deposite(12345, 1000);
       b.withdraw(12345, 500);
       b.showBalance(12345);

    }
}

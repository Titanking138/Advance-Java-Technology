package exp10_1;

import java.rmi.*;

/**
 *
 * @author admin
 */
public interface Bank extends Remote{
    public void deposite(int acc_no,int money) throws RemoteException;
    public void withdraw(int acc_no,int money) throws RemoteException;
    public void showBalance(int acc_no) throws RemoteException;
    
}

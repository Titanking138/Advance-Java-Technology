package exp10_1;
/**
 *
 * @author admin
 */
import java.rmi.*;

public class MyServer {

    public static void main(String args[]) throws Exception {
        Remote r = new BankImpl();
        Naming.rebind("rmi://localhost:6999/maniya", r);
    }
}

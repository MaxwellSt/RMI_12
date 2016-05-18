import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by maxim.stetsenko on 17.05.2016.
 */
public interface BillingService extends Remote {

    void addNewCard(String personName, String card) throws RemoteException;

    void addMoney(String card, double money) throws RemoteException;

    void subMoney(String card, double money) throws RemoteException;

    double getCardBalance(String card) throws RemoteException;
}

/**
 * Created by maxim.stetsenko on 18.05.2016.
 */

import java.rmi.*;

public class BillingClient {


    // выполнение BillingClient
    public static void main(String[] args) throws Exception {

        // создание строки, содержащей URL удаленного объекта
        String objectName = "rmi://localhost/BillingService";
        System.out.println("Starting...\n");
        // соединение с реестром RMI и получение удаленной ссылки
        // на удаленный объект
        BillingService bs = (BillingService) Naming.lookup(objectName);
        System.out.println("done");

        // начисление денежных средств на пластиковые карты
        for (
                int i = 0;
                i < 10000; i++)

        {
            try {
                bs.addMoney("1", 1);
            } catch (RemoteException e) {
                bs.addNewCard("Piter", "1");
            }

            try {
                bs.addMoney("2", 1);
            } catch (RemoteException e) {
                bs.addNewCard("Stefan", "2");
            }

            try {
                bs.addMoney("3", 1);
            } catch (RemoteException e) {
                bs.addNewCard("Nataly", "3");
            }
        }
        // печать текущего баланса обработанных карт
        System.out.println("1:" + bs.getCardBalance("1"));
        System.out.println("2:" + bs.getCardBalance("2"));
        System.out.println("3:" + bs.getCardBalance("3"));
    }
}


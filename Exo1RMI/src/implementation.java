
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class implementation implements moninterface {
    private  static boolean b = true;
    private moninterface ro2;
    private moninterface ro3;
    private moninterface monint;

    protected implementation () throws RemoteException, NotBoundException {
        super();
        String name2 = new String ("TOTO");
        Registry registry2 = LocateRegistry.getRegistry("localhost",1101);
        ro2 = (moninterface) registry2.lookup(name2);

        String name3 = new String ("blabla");
        Registry registry3 = LocateRegistry.getRegistry("localhost",1100);
        ro3 = (moninterface) registry3.lookup(name3);
    }

    public String getEcho (String s) throws RemoteException {
        String string = new String();
        if (b){
            string = ro2.getEcho(s);
            System.out.println("Serveur 2");
        }
        else {
            string = ro3.getEcho(s);
            System.out.println("Serveur 3");
        }
        b = !b;

        return string;
    }


    @Override
    public String envoyerobj(String s) throws RemoteException {
        return null;
    }
}

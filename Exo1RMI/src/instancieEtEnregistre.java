import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class instancieEtEnregistre {

    public static void main (String args[]) throws RemoteException, NotBoundException {

        moninterface monimp = new implementation();

                /*if (System.getSecurityManager() == null) {
                    System.setSecurityManager(new SecurityManager());
                }*/
        try{
            moninterface skeleton = (moninterface) UnicastRemoteObject.exportObject(monimp, 1099);
            String name = new String("monimp");
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name, skeleton);
            System.out.println(" Server waiting...");
        } catch (java.rmi.server.ExportException e) {

                e.printStackTrace();
                UnicastRemoteObject.unexportObject(monimp,true);
                System.out.println("Relance le serveur");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }

}



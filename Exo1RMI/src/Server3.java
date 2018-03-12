import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server3 {

    public static void main (String args[]) {
        try {
            moninterface monimp2 = new implementationS3();

            try {
                /*if (System.getSecurityManager() == null) {
                    System.setSecurityManager(new SecurityManager());
                }*/
                moninterface skeleton = (moninterface) UnicastRemoteObject.exportObject(monimp2, 1100);
                String name = new String("blabla");
                Registry registry = LocateRegistry.createRegistry(1100);
                registry.rebind(name, skeleton);
                System.out.println("Server waiting...");
            } catch (java.rmi.server.ExportException e) {
                try {
                    e.printStackTrace();
                    UnicastRemoteObject.unexportObject(monimp2, true);
                    System.out.println("Relance le serveur");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception f) {
                f.printStackTrace();
            }
        }
        catch (Exception g){
            g.printStackTrace();
        }

    }
}

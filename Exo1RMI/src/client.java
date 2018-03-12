import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class client {
    public static void main (String args[]){
        try{
            /*if (System.getSecurityManager()==null){
                System.setSecurityManager(new SecurityManager());
            }*/
            String name = new String ("monimp");
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            moninterface ro = (moninterface) registry.lookup(name);

            System.out.println(ro.getEcho("Hello !"));
            System.out.println(ro.getEcho("Hello !"));


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

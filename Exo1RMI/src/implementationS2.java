import java.rmi.RemoteException;

public class implementationS2 implements moninterface {

    protected implementationS2 () throws RemoteException {
        super();
    }

    public String getEcho (String s) throws RemoteException {

        System.out.println("Le serveur 2 attend le client ");
        return s+s;
    }

    @Override
    public String envoyerobj(String s) throws RemoteException {
        return null;
    }
}

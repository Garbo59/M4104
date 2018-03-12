import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface moninterface extends Remote {

    public String getEcho (String s) throws RemoteException;
    public String envoyerobj (String s) throws RemoteException;
}

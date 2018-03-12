import java.rmi.RemoteException;

public class implementationS3 implements moninterface {

    private moninterface moninterface;
    protected implementationS3 () throws RemoteException {
        super();
    }

    protected implementationS3 (moninterface mt){
        super();
        moninterface = mt;
    }

    public String getEcho (String s) throws RemoteException {

        System.out.println("Le serveur 3 attend le client");
        return s+s;
    }

    public String envoyerobj (String s) throws RemoteException{
        return moninterface.getEcho(s);
    }

}

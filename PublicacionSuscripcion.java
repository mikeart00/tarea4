import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PublicacionSuscripcion extends Remote {
    
    void registrarse(String usuario) throws RemoteException;
    boolean subscribirse(String topico) throws RemoteException;
    boolean desubscribirse(String topico) throws RemoteException;
}
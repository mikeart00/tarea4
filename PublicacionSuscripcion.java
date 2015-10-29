import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PublicacionSuscripcion extends Remote {
    
    boolean registrarse(String usuario) throws RemoteException;
    boolean suscripcion(String usuario, String topico) throws RemoteException;
    String verificaBuzonNotificaciones(String usuario) throws RemoteException;
    boolean desuscripcion(String usuario, String topico) throws RemoteException;
}
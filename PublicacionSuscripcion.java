import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PublicacionSuscripcion extends Remote {
    
    boolean registrarse(String usuario) throws RemoteException;
    boolean suscripcion(String usuario, String topico) throws RemoteException;
    String verificaBuzonNotificaciones(String usuario) throws RemoteException;
    boolean desuscripcion(String usuario, String topico) throws RemoteException;
    void publicaAnuncio(String usuario, String topico, String mensaje) throws RemoteException;
    boolean hacerOferta(String usuario, String num_mensaje, String precio) throws RemoteException;
    boolean venderProducto(String Usuario, String num_mensaje, String precio, boolean venta) throws RemoteException;
}

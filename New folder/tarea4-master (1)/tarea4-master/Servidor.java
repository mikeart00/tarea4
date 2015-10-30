import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;


public class Usuario {

    int id;
    String nombre_de_usuario;
    
    public Usuario() {
        
    }
}

public class Servidor implements PublicacionSuscripcion {

    
    Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
    
    public Servidor() {}

    public void registrarse(String nombre_de_usuario) {

        //El usuario ya existe
        if(!usuarios.containsKey(nombre_de_usuario)) {
            usuarios.put(nombre_de_usuario, new Usuario());
        }
        
                
                
        
    }

    public static void main(String args[]) {

        try {
            Servidor obj = new Servidor();
            PublicacionSuscripcion stub = (PublicacionSuscripcion) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("PublicacionSuscripcion", stub);

            System.err.println("Servidor Listo");
            
            
        } catch (Exception e) {
            System.err.println("Error en el Servidor: " + e.toString());
            //e.printStackTrace();
        }
    }
}
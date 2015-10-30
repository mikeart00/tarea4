import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    String usuario;
    Registry registry;
    PublicacionSuscripcion ps;
    
    public Cliente(String usuario_arg, String host) {
        this.usuario = usuario_arg;
        
        
        try {
            this.registry = LocateRegistry.getRegistry(host);
            this.ps = (PublicacionSuscripcion) registry.lookup("PublicacionSuscripcion");
            boolean registro_correcto = ps.registrarse(this.usuario);
        } catch (Exception e) {
            System.err.println("ExcepciÃ³n en el Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
    
    public boolean suscripcion(String topico) {
        try {
            return this.ps.suscripcion(this.usuario, topico);
 
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean desuscripcion(String topico) {
        try {
            return this.ps.desuscripcion(this.usuario, topico);
 
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }
    
    public String[] listaTopicos() {
        try {
            return this.ps.listaTopicos(this.usuario);
 
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
    
    
 }

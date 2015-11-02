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
            System.err.println("Excepcion en el Cliente: " + e.toString());
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
    
    public String verificaBuzonNotificaciones() {
        try {
            return this.ps.verificaBuzonNotificaciones(this.usuario);
 
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
            return "Error";
        }
    }
    
    public void publicaAnuncio(String topico, String mensaje) {
        try {
            this.ps.publicaAnuncio(this.usuario, topico, mensaje);
 
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
            return;
        }
    }
    
    public boolean hacerOferta(String noMensaje, String precio) {
        try {
            //int num = Integer.parseInt(noMensaje);
            //float pr = Float.parseFloat(precio);
            
            return this.ps.hacerOferta(this.usuario, noMensaje, precio);
 
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean venderProducto(String noMensaje, String precio, boolean venta, String comprador) {
        try {
            //int num = Integer.parseInt(noMensaje);
            //float pr = Float.parseFloat(precio);
            
            return this.ps.venderProducto(comprador, noMensaje, precio, venta);
 
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }
    
    
    
 }

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;




public class Servidor implements PublicacionSuscripcion {

    
    Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
    Hashtable<String, Grupo> grupos = new Hashtable<String, Grupo>();
    Hashtable<String, Usuario> anuncios = new Hashtable<String, Usuario>();
    int anuncio_id;
    
    public Servidor() {
      anuncio_id = 0;
    }

    public boolean registrarse(String nombre_de_usuario) {

        System.out.println("registrarse: Petición de agregar nombre_de_usuario:  "+nombre_de_usuario);
        //El usuario ya existe
        if(!usuarios.containsKey(nombre_de_usuario)) {
            usuarios.put(nombre_de_usuario, new Usuario(nombre_de_usuario));
            System.out.println("registrarse: Usuario "+nombre_de_usuario+" es nuevo. Agregando a la memoria.");
        } else {
            System.out.println("registrarse: Usuario "+nombre_de_usuario+" ya esta en memoria.");
        }
        
        return true;
    }
    
    public boolean suscripcion(String usuario, String topico) {
        System.out.println("suscripcion: Petición de suscribir usuario:  "+usuario + "a grupo: " + topico);
        
        //Verificar que el topico exista
        if(!grupos.containsKey(topico)) {
            grupos.put(topico, new Grupo(topico));
            System.out.println("suscripcion: Grupo "+topico+" es nuevo. Agregando a la memoria.");
        } else {
            System.out.println("suscripcion: Grupo "+topico+" ya esta en memoria.");
        }
        
        Grupo g;
        g = grupos.get(topico);   
        return g.suscribir(usuarios.get(usuario));
    }
    
    public boolean desuscripcion(String usuario, String topico) {
        return true;
    }

    
    public String verificaBuzonNotificaciones(String usuario) {
        Usuario u = usuarios.get(usuario);
        
        return u.leeNotificacion();
    }
            
    public void publicaAnuncio(String Usuario, String topico, String mensaje)
    {
       Grupo g; 
       Usuario u;
       //Existe el grupo indicado?
       if(!grupos.containsKey(topico)) {
            grupos.put(topico, new Grupo(topico));
            System.out.println("suscripcion: Grupo "+topico+" es nuevo. Agregando a la memoria.");
        }
       
       //El grupo ya existe
       g = grupos.get(topico);
       System.out.println("Mandando anuncio "+mensaje+" a Grupo "+topico+" ");
       
       //agrega el anuncio al pool de anuncios
       ++anuncio_id;
       u = usuarios.get(Usuario);
       anuncios.put(Integer.toString(anuncio_id), u);
       
       //Manda el anuncio
       g.broadcast(new Notificacion(Usuario, mensaje, anuncio_id));
    }        
    
    public boolean hacerOferta(int num_mensaje, float precio)
    {
       Usuario u;
       String msj = Integer.toString(num_mensaje);
       System.out.println("HacerOferta - msj num: "+msj+"");
      
       //Encontrar si ese num de oferta esta registrado
       if(!anuncios.containsKey(msj)) {
         System.out.println("Anuncio no encontrado");
         return false;
       } 
       
       //Ya lo encontramos, ahora hay que obtener el usuario que lo mando.
       u = anuncios.get(msj);
       //Mandarle la oferta al usuario que publico el anuncio
       Notificacion u2 = new Notificacion(u.nombre_de_usuario, num_mensaje, precio); 
       u.agregaNotificacion(u2);
       return false; 
    }    
    
    public boolean venderProducto(String Usuario, int num_mensaje, float precio, boolean venta)
    {
       //Usuario es el usuario al que se le vendera el producto. 
       String msj = Integer.toString(num_mensaje);
       System.out.println("venderproducto - msj num: "+msj+"");
       Notificacion n;
       Usuario comprador;
       
       //Decidir si se hara la venta o no.
       //Existe el usuario
       if(!usuarios.containsKey(Usuario)) {
         System.out.println("Usuario no encontrado"); 
       }
       
       //Existe el anuncio?
       if(!anuncios.containsKey(msj)) {
         System.out.println("Anuncio no encontrado");
         return false;
       }
                   
       comprador = usuarios.get(Usuario);
       
       if(venta == true)
       {
         //Mandar notificacion de que si se realizara la venta  
         n = new Notificacion(comprador.nombre_de_usuario, msj, true);
         comprador.agregaNotificacion(n);
         anuncios.remove(msj);
         System.out.println("Compra completada");  
       }
       else 
       { 
         // mandar notificacion de que se rechazo la oferta  
         n = new Notificacion(comprador.nombre_de_usuario, msj, false);
         comprador.agregaNotificacion(n);
       }
       return true;
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
            e.printStackTrace();
        }
    }
}
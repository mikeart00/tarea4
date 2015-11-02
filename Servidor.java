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

        System.out.println("registrarse: PeticiÃ³n de agregar nombre_de_usuario:  "+nombre_de_usuario);
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
        Grupo g = grupos.get(topico);
        
        return g.suscribir(usuarios.get(usuario));
    }
    
    public boolean desuscripcion(String usuario, String topico) {
        System.out.println("desuscripcion: Petición de desuscribir usuario:  "+usuario + " del grupo: " + topico);
        if(!grupos.containsKey(topico)) {
            System.out.println("desuscripcion: Grupo "+topico+" no existe");
            return false;
        }
        
        Grupo g = grupos.get(topico);
        
        
        return g.desuscribir(usuario);
    }

    
    public String verificaBuzonNotificaciones(String usuario) {
        Usuario u = usuarios.get(usuario);
        
        String resultado = u.leeNotificacion();
        
        if(resultado == null) {
            return "ninguno";
        }
        
        
        return resultado;
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

public boolean hacerOferta(String comprador, String num_mensaje, String precio)
    {
       Usuario vendedor;
       System.out.println("HacerOferta - msj num: "+num_mensaje+"");
      
       //Encontrar si ese num de oferta esta registrado
       if(!anuncios.containsKey(num_mensaje)) {
         System.out.println("Anuncio no encontrado");
         Usuario comp = usuarios.get(comprador);
         comp.agregaNotificacion(new Notificacion ("El anuncio no fue encontrado o ya fue vendido"));
         
         return false;
       } 
       
       //Ya lo encontramos, ahora hay que obtener el usuario que lo mando.
       vendedor = anuncios.get(num_mensaje);
       //Mandarle la oferta al usuario que publico el anuncio
       Notificacion notificacion = new Notificacion(comprador, num_mensaje, precio); 
       vendedor.agregaNotificacion(notificacion);
       return true; 
    }    
    
    public boolean venderProducto(String Usuario, String num_mensaje, String precio, boolean venta)
    {
       //Usuario es el usuario al que se le vendera el producto. 
       
       System.out.println("venderproducto - msj num: "+num_mensaje+"");
       Notificacion n;
       Usuario comprador;
       
       //Decidir si se hara la venta o no.
       //Existe el usuario
       if(!usuarios.containsKey(Usuario)) {
         System.out.println("Usuario no encontrado"); 
       }
       
       //Existe el anuncio?
       if(!anuncios.containsKey(num_mensaje)) {
         System.out.println("Anuncio no encontrado");
         return false;
       }
                   
       comprador = usuarios.get(Usuario);
       
       if(venta == true)
       {
         //Mandar notificacion de que si se realizara la venta  
         n = new Notificacion(comprador.nombre_de_usuario, num_mensaje, true);
         comprador.agregaNotificacion(n);
         anuncios.remove(num_mensaje);
         System.out.println("Compra completada");  
       }
       else 
       { 
         // mandar notificacion de que se rechazo la oferta  
         n = new Notificacion(comprador.nombre_de_usuario, num_mensaje, false);
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
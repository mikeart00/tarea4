import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;




public class Servidor implements PublicacionSuscripcion {

    
    Hashtable<String, Usuario> usuarios = new Hashtable<String, Usuario>();
    Hashtable<String, Grupo> grupos = new Hashtable<String, Grupo>();
    
    public Servidor() {}

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
        System.out.println("suscripcion: Petición de suscribir usuario:  "+usuario + " a grupo: " + topico);
        
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
        System.out.println("suscripcion: Petición de desuscribir usuario:  "+usuario + " del grupo: " + topico);
        Grupo g = grupos.get(topico);
        
        
        return g.desuscribir(usuario);
    }

    public String[] listaTopicos(String usuario) {
        System.out.println("listaTopicos: usuario = "+usuario);
        
        String resultado = "";

        Set<String> keys = grupos.keySet();
        
        Grupo g;
        for(String key: keys){
            g = grupos.get(key);
            if(g.esParteDe(usuario)) {
                if(resultado.equals("")) {
                    resultado = key;
                } else {
                  resultado = resultado + "<;>" + key;
                }
            }
        }
        System.out.println("listaTopicos: usuario = "+usuario + " {" + resultado+"}");
        return resultado.split("<;>");
    }
    
    public String verificaBuzonNotificaciones(String usuario) {
        Usuario u = usuarios.get(usuario);
        
        return u.leeNotificacion();
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
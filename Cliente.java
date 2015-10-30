import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.io.*;

public class Cliente {

    private Cliente() {}
    
    public static void main(String[] args) {

        //String host = (args.length < 1) ? null : args[0];
        
        String host = args[0];
        String usuario = args[1];
        
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            PublicacionSuscripcion ps = (PublicacionSuscripcion) registry.lookup("PublicacionSuscripcion");
            
            
            boolean registro_correcto = ps.registrarse(usuario);
            System.out.println("Registrandose en el sistema. " + registro_correcto);
            
            
            
            
            boolean resultado;
            resultado = ps.suscripcion(usuario, "Mascotas");
            System.out.println("Suscribiendo al topico -Mascotas- " + resultado);
            
            resultado = ps.suscripcion(usuario, "Mascotas");
            System.out.println("Suscribiendo al topico -Mascotas- " + resultado);
            
            resultado = ps.suscripcion(usuario, "Salchichas");
            System.out.println("Suscribiendo al topico -Salchichas- " + resultado);
            
            
 //Borrar despues/////////////////////////////
            registro_correcto = ps.registrarse("Fionis");
            System.out.println("Registrandose en el sistema. " + registro_correcto);
            ps.suscripcion("Fionis", "Mascotas");
            ps.suscripcion("Fionis", "Salchichas");
            
            registro_correcto = ps.registrarse("Toñita");
            System.out.println("Registrandose en el sistema. " + registro_correcto);
            ps.suscripcion("Toñita", "Mascotas");
            ps.suscripcion("Toñita", "Salchichas");
            ////////////////////////////////////////////////
            
            /////////////////////////////////////////
            //El usuario quiere mandar un anuncio a Mascotasa
            System.out.println("Publicando un anuncio");
            ps.publicaAnuncio("Fionis", "Mascotas", "Se venden croquetas palPerro");
            //System.out.println("Despues de publicar un anuncio");
            
            String notificacion = "1";
            
            do {
                notificacion = ps.verificaBuzonNotificaciones(usuario);
                System.out.println("Leyendo notificacion '" + notificacion + "'");
            }  while(notificacion != null);     
            
            do {
                notificacion = ps.verificaBuzonNotificaciones("Fionis");
                System.out.println("Leyendo notificacion Fionis'" + notificacion + "'");
            }  while(notificacion != null); 
            
                        
            System.out.println("Cliente Terminado");

            
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
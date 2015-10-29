
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
            
                        
            System.out.println("Cliente Terminado");

            
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
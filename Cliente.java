
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.io.*;

public class Cliente {

    private Cliente() {}
    
    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            PublicacionSuscripcion ps = (PublicacionSuscripcion) registry.lookup("PublicacionSuscripcion");
            
            
            ps.registrarse("Mike");
            System.out.println("Registrandose en el sistema. Mi id es " + id);
                        
            System.out.println("Trabajo Terminado");

            
        } catch (Exception e) {
            System.err.println("Excepción en el Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
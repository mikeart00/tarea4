
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.io.*;
import java.util.regex.Pattern;
import java.io.*;



public class ClienteApp {
    
    

    private ClienteApp() {}
    
    private static void menu() {
        
        System.out.println("");
        System.out.println("Opciones:");
        System.out.println("  0 Menu de Opciones");
        System.out.println("  1 Suscribirse a un grupo");
        System.out.println("  2 Desuscribirse a un grupo");
        System.out.println("  3 Verificar Buzon");
        System.out.println("  4 Publicar Anuncio");
        System.out.println("  X Salir");
        System.out.println(" ");
    }
        
    private static void suscribirse(Cliente cliente) {
        
        String entrada;
        boolean resultado;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                System.out.print("  [x Menu Anterior] Nombre del Topico? ");
                entrada = br.readLine();
                entrada = entrada.toLowerCase();
                
                switch(entrada) {
                    case "x":
                        return;                  
                    default:
                        System.out.println("  Intentando Suscribir a topico '" + entrada + "'");
                        resultado = cliente.suscripcion(entrada);
                        System.out.println("  ::" + resultado);
                        return;
                }   
            }
        } catch (IOException e) {
            System.out.println("Error al leer la linea");
        }
    }
    
    private static void desuscribirse(Cliente cliente) {
        
        String entrada;
        boolean resultado;
        String[] listaTopicos = cliente.listaTopicos();
        if(listaTopicos[0].equals("")) {
            System.out.println("  Cantidad de topicos suscritos actualmente: 0");
            return;
        }
        System.out.println("  Cantidad de topicos suscritos actualmente: " + listaTopicos.length);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                for(int i=0; i<listaTopicos.length; i++) {
                    System.out.println("  "+ i + " " + listaTopicos[i]);
                    
                }
                
                System.out.print("  [x Menu Anterior] [Número del Topico]? ");
                entrada = br.readLine();
                entrada = entrada.toLowerCase();
                
                if(entrada.equals("x")) {
                    return;
                } else {
                    if(entrada.matches("\\d+")) {
                        int opcion = Integer.parseInt(entrada);
                        if(opcion < listaTopicos.length) {
                            System.out.println("  Intentando desuscribir del topico '" + listaTopicos[opcion] + "'");
                            resultado = cliente.desuscripcion(listaTopicos[opcion]);
                            System.out.println("  ::" + resultado);
                            return;
                        }
                    }
                }
                System.out.println("  ::Opción Invalida");
            }
        } catch (IOException e) {
            System.out.println("Error al leer la linea");
        }
    }
        
    
    public static void main(String[] args) {

        //String host = (args.length < 1) ? null : args[0];
        
        String host = args[0];
        String usuario = args[1];
        String entrada = "";
        Cliente cl = new Cliente(usuario, host);
        
        
        System.out.println("==========================================================*");
        System.out.println("                   Oferton 1.0                    ");
        System.out.println("==========================================================*");
        System.out.println("  Sistema de Ofertas Publicador-Suscriptor.");
        
        
        menu();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                System.out.print(usuario+">");
                entrada = br.readLine();
                entrada = entrada.toLowerCase();
                
                switch(entrada) {
                    case "0":
                        menu();
                        break;
                    case "1":
                        System.out.println("  ::Suscribiendo a un grupo");
                        suscribirse(cl);
                        break;
                    case "2":
                        System.out.println("  ::Desuscribiendo a un grupo");
                        desuscribirse(cl);
                        break;
                    case "3":
                        System.out.println("  ::Checando Buzón de Notificaciones");
                        break;
                    case "4":
                        System.out.println("  ::Publicando");
                        break;
                    case "x":
                        System.out.println("  ::Bye!");
                        return;
                    default:
                        System.out.println("  ::Opción Invalida");
                        menu();
                }   
            }
        } catch (IOException e) {
            System.out.println("Error al leer la linea");
        }
        
        
        
        
    }
}
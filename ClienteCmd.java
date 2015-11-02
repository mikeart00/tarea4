import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.io.*;
import java.util.regex.MatchResult;

public class ClienteCmd {
    
    

    private ClienteCmd() {}
    
    private static void ayuda() {
        
        System.out.println("");
        System.out.println("Uso:");
        System.out.println("  -servidor <s>                  Direccion ip del servidor o localhost");
        System.out.println("  -usuario <s>                   Usuario para conectarse al sistema");
        System.out.println("  -suscripcion <s>               Suscribirse a los anuncions del Topico");
        System.out.println("  -desuscripcion <s>             Desuscribirse a los anuncions del Topico");
        System.out.println("  -publicaAnuncio <s> <s>        Publica un anuncio en el Topico <s> con el mensaje <s>");
        System.out.println("  -hacerOferta <s> <s>           Hacer una oferta en el anuncio Numero <s> por la cantidad <s>");
        System.out.println("  -aceptarOferta <s> <s>         Aceptar la oferta del anuncio <s> del usuario <s>");
        System.out.println("  -rechazarOferta <s> <s>        Rechazar la oferta del anuncio <s> del usuario <s>");
        System.out.println("  -ayuda                         Mostrar ayuda");
        System.out.println("");
        System.out.println("  java ClienteCmd -servidor localhost -usuario Fiona -suscripcion Mascotas");
    }
        
     
    
    public static void main(String[] args) {

   
        String servidor = "localhost";
        String usuario = null;
        String comando = null;
        String topico = null;
        String mensaje = null;
        String id_arg = null;
        String cantidad_arg = null;
        String comprador = null;
        
        
        
        for (int i=0; i<args.length; i++) {
            comando = args[i];
            
            switch(comando) {
                case "-usuario":
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    usuario = args[i];
                    break;
                case "-servidor":
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    servidor = args[i];
                    break;
                case "-suscripcion":
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    topico = args[i];
                    break;
                case "-desuscripcion":
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    topico = args[i];
                    break;
                case "-publicaAnuncio":
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    topico = args[i];
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    mensaje = args[i];
                    break; 
                case "-hacerOferta":
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    id_arg = args[i];
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    cantidad_arg = args[i];
                    break;
                case "-aceptarOferta":
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    id_arg = args[i];
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    comprador = args[i];
                    break;
                case "-rechazarOferta":
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    id_arg = args[i];
                    i++;
                    if(i >= args.length) {
                        ayuda();
                        return;
                    }
                    comprador = args[i];
                    break;
                case "-verificaBuzonNotificaciones":
                    break; 
                case "-ayuda":
                    ayuda();
                    return; 
                default:
                    System.out.println("");
                    System.out.println("  ::Opcion '"+comando+"' no reconocida ");
                    ayuda();
                    return;
            }
        }

        if(usuario.isEmpty()) {
            System.out.println("  Por favor indique un usuario correcto [-usuario]");
            ayuda();
            return;
        }
        usuario = usuario.toLowerCase();

        if(topico != null) {
            topico = topico.toLowerCase();
        }
        
        if(comprador != null) {
            comprador = comprador.toLowerCase();
        }
        
        Cliente cliente = new Cliente(usuario, servidor);
        

        System.out.println("["+usuario+"]");
        switch(comando) {
            case "-suscripcion":
                System.out.println("  Intentando suscribir del topico '" + topico + "'");
                System.out.println("  ::" + cliente.suscripcion(topico));
                break;
            case "-desuscripcion":
                System.out.println("  Intentando desuscribir del topico '" + topico + "'");
                System.out.println("  ::" + cliente.desuscripcion(topico));
                break;
            case "-verificaBuzonNotificaciones":
                System.out.println("  Verificando Buzón de notificaciones");
                System.out.println("  ::" + cliente.verificaBuzonNotificaciones());
                break;
            case "-publicaAnuncio":
                System.out.println("  Publicando anuncio en el topico '" + topico + "'");
                cliente.publicaAnuncio(topico, mensaje);
                break;
            case "-hacerOferta":
                System.out.println("  Haciendo Oferta de $" + cantidad_arg + " sobre anuncio No." + id_arg);
                System.out.println("  ::" + cliente.hacerOferta(id_arg, cantidad_arg));
                break;
            case "-aceptarOferta":
                System.out.println("  Aceptando Oferta " + id_arg + " de " + comprador);
                System.out.println("  ::" + cliente.venderProducto(id_arg, "0.0", true, comprador));
                break;
            case "-rechazarOferta":
                System.out.println("  Rechazando oferta " + id_arg + " de " + comprador);
                System.out.println("  ::" + cliente.venderProducto(id_arg, "0.0", false, comprador));
                break;
                
        }
        
    }
}
import java.util.concurrent.LinkedBlockingQueue;

public class Usuario {

    
    String nombre_de_usuario;
    LinkedBlockingQueue<Notificacion> buzon;
    
    
    public  Usuario(String nombre_de_usuario_arg) {
        this.nombre_de_usuario = nombre_de_usuario_arg;
        this.buzon = new LinkedBlockingQueue<Notificacion>();
    }
    
    public String nombre() {
        return nombre_de_usuario;
    }
    
    public void agregaNotificacion(Notificacion notificacion_arg) {
     try {
        this.buzon.put(notificacion_arg);
     } catch (InterruptedException e){
         System.out.println("Error agregaNotificacion");
     }
    }
    
    public String leeNotificacion() {
        Notificacion n = this.buzon.poll();
        if (n==null) {
            return null;
        }
        
        return n.leer();
    }
 
           
}

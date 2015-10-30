import java.util.*;

public class Grupo {

    int id;
    String topico;
    Hashtable<String, Usuario> usuarios;
    
    public Grupo(String topico_arg) {
        this.topico = topico_arg;
        usuarios = new Hashtable<String, Usuario>();
    }
    
    public boolean suscribir(Usuario usuario) {
        
        System.out.println("Grupo[" + this.topico+ "].subscribir: Usuario "+usuario.nombre()+"");
        if(!usuarios.containsKey(usuario.nombre())) {
            usuarios.put( usuario.nombre(), usuario);
            System.out.println("Grupo[" + this.topico+ "].suscribir: Usuario "+usuario.nombre()+" no existe en este grupo. Agregando");
            //usuario.agregaNotificacion(new Notificacion("El usuario '"+usuario.nombre()+"' ha sido suscrito al topico '"+this.topico+"'"));
            broadcast(new Notificacion("El usuario '"+usuario.nombre()+ "' ha sido suscrito al topico '" +this.topico+"'"));
            
        } else {
            System.out.println("Grupo[" + this.topico+ "].subscribir: Usuario "+usuario.nombre()+" ya existe en este grupo");
            return false;
        }
        
        return true;
    }
    
    public void broadcast(Notificacion notificacion_arg){
        Set<String> keys = usuarios.keySet();
        Usuario u;
        for(String key: keys){
            u = usuarios.get(key);
            u.agregaNotificacion(notificacion_arg);
        }
    }
    
}

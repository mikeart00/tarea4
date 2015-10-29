import java.util.Hashtable;

public class Grupo {

    int id;
    String topico;
    Hashtable<String, Usuario> usuarios;
    
    public Grupo(String topico_arg) {
        this.topico = topico_arg;
        usuarios = new Hashtable<String, Usuario>();
    }
    
    public boolean suscribir(Usuario usuario) {
        
        System.out.println("Grupo.subscribir: Usuario "+usuario+"");
        if(!usuarios.containsKey(usuario.nombre())) {
            usuarios.put( usuario.nombre(), usuario);
            System.out.println("Grupo.subscribir: Usuario "+usuario+" no existe en este grupo. Agregando");
            
        } else {
            System.out.println("Grupo.subscribir: Usuario "+usuario+" ya existe en este grupo");
            return false;
        }
        
        return true;
    }
    
}
public class Usuario {

    int id;
    String nombre_de_usuario;
    
    public  Usuario(String nombre_de_usuario_arg) {
        this.nombre_de_usuario = nombre_de_usuario_arg;
    }
    
    public String nombre() {
        return nombre_de_usuario;
    }
}
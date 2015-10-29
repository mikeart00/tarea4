public class Notificacion {

    
    String mensaje;
    boolean leida;
    
    public  Notificacion(String mensaje_arg) {
        this.mensaje = mensaje_arg;
        this.leida = false;
    }
    
    public boolean leida() {
        return leida;
    }
    
    public String leer () {
        this.leida = true;
        return mensaje;
    }
}
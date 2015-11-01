public class Notificacion {

    
    String mensaje;
    boolean leida;
    String topico;
    
    public  Notificacion(String mensaje_arg) {
        //Notificacionbes a grupos
        this.mensaje = mensaje_arg;
        this.leida = false;
    }
    
    public  Notificacion(String Usuario, String mensaje_arg, int anuncio_id) {
        //Publicar anuncios
        String id = String.valueOf(anuncio_id);
        this.mensaje = "Anuncio num:"+id+"::"+mensaje_arg+"::De:"+Usuario+"::Desea comprarlo?";
        this.leida = false;
    }
    
    public Notificacion(String Usuario, int num_msj, float precio)
    { //hacer ofertas a algun anuncio
       String id = String.valueOf(num_msj);
       String value = String.valueOf(precio);
       this.mensaje = "Oferta recibida::Para anuncio num:"+id+"::De:"+Usuario+"::Por:"+value;
    }        
    
    public Notificacion(String Usuario, String num_mensaje, Boolean venta)
    {  //aceptar o rechazar ofertas
      if(venta)
      {
        this.mensaje = "Oferta aceptada::Anuncio num:"+num_mensaje+"::De:"+Usuario;
      }
      else
      {
        this.mensaje = "Oferta rechazada::Anuncio num:"+num_mensaje+"::De:"+Usuario;
      }
    }     
    
    public boolean leida() {
        return leida;
    }
    
    public String leer () {
        this.leida = true;
        return mensaje;
    }
}
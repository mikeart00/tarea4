echo '+++ vendorefri.sh'
./limpia.sh
echo '#Suscribir a topico mascotas'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion Mascotas
java ClienteCmd -usuario Gaby -servidor localhost -suscripcion mascotas
java ClienteCmd -usuario Gaby -servidor localhost -suscripcion refris
echo '#Publicar anuncio'
java ClienteCmd -usuario Gaby -servidor localhost -publicaAnuncio mascotas 'Se vende refrigerador para perritos'
echo '#Leer notificaciones del grupo'
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
echo '#Fin'
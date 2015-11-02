echo '+++ comprasimple.sh'
./limpia.sh
echo '#Suscribirse a topico mascotas'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion Mascotas
java ClienteCmd -usuario Gaby -servidor localhost -suscripcion mascotas
echo '#Mike publica anuncio'
java ClienteCmd -usuario Mike -servidor localhost -publicaAnuncio Mascotas 'Se vende refri'
echo '#Gaby lee buzon'
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
echo '#Gaby hace oferta'
java ClienteCmd -usuario Gaby -servidor localhost -hacerOferta 1 10.0
echo '#Mike lee buzon'
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
echo '#Mike acepta oferta'
java ClienteCmd -usuario Mike -servidor localhost -aceptarOferta 1 gaby
echo '#Gaby lee buzon'
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

echo '#Fin'
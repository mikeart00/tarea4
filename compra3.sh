echo '#'
echo '#'
echo '### Compra 3 usuarios'
./limpia.sh
echo '#Suscribirse a topico mascotas'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion Mascotas
java ClienteCmd -usuario Gaby -servidor localhost -suscripcion mascotas
java ClienteCmd -usuario Fionis -servidor localhost -suscripcion mascotas
echo '#Mike lee buzon'
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
echo '#Gaby lee buzon'
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
echo '#Fionis lee buzon'
java ClienteCmd -usuario Fionis -servidor localhost -verificaBuzonNotificaciones


echo '#Mike publica anuncio'
java ClienteCmd -usuario Mike -servidor localhost -publicaAnuncio Mascotas 'Se vende salchichas'

echo '#Gaby lee buzon'
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
echo '#Fionis lee buzon'
java ClienteCmd -usuario Fionis -servidor localhost -verificaBuzonNotificaciones
echo '#Mike lee buzon'
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones



echo '#Fionis hace oferta'
java ClienteCmd -usuario Fionis -servidor localhost -hacerOferta 1 5.0

echo '#Gaby hace oferta'
java ClienteCmd -usuario Gaby -servidor localhost -hacerOferta 1 10.0


echo '#Mike lee buzon'
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
echo '#Mike rechaza oferta'
java ClienteCmd -usuario Mike -servidor localhost -rechazarOferta 1 fionis

echo '#Mike lee buzon'
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
echo '#Mike rechaza oferta'
java ClienteCmd -usuario Mike -servidor localhost -aceptarOferta 1 gaby



echo '#Gaby lee buzon'
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

echo '#Fionis lee buzon'
java ClienteCmd -usuario Fionis -servidor localhost -verificaBuzonNotificaciones

echo '#Mike lee buzon'
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones

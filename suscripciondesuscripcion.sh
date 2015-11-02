echo '+++ suscripciondesuscripcion.sh'
./limpia.sh
echo '#Suscribir Mike a topico no existente [Mascotas]'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion Mascotas
echo '#Suscribir Mike a topico que ya esta suscrito'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion Mascotas
echo '#Suscribir Gaby a topico Ya existente [Mascotas]'
java ClienteCmd -usuario Gaby -servidor localhost -suscripcion Mascotas
echo '#Suscribir Gaby a topico Ya existente [masCOtas]'
java ClienteCmd -usuario Gaby -servidor localhost -suscripcion masCOtas
echo '#DeSuscribir Gaby a topico que si estamos suscritos [masCOtas]'
java ClienteCmd -usuario Gaby -servidor localhost -desuscripcion masCOtas
echo '#DeSuscribir Gaby a topico que ya nos habiamos desuscrito [masCOtas]'
java ClienteCmd -usuario Gaby -servidor localhost -desuscripcion masCOtas
echo '#DeSuscribir Gaby a topico que no existe [autos]. Nadie se habia suscrito a ese topico'
java ClienteCmd -usuario Gaby -servidor localhost -desuscripcion autos
echo '#DeSuscribir Fiona cuando no se ha suscrito a ningun topico anteriormente [mascotas] y el topico existe'
java ClienteCmd -usuario Fiona -servidor localhost -desuscripcion mascotas
echo '#DeSuscribir Pancho cuando no se ha suscrito a ningun topico anteriormente [mochilas] y el topico no existe'
java ClienteCmd -usuario Pancho -servidor localhost -desuscripcion mochilas
echo '#Suscribir Pancho al topico [mochilas]'
java ClienteCmd -usuario Pancho -servidor localhost -suscripcion mochilas
echo '#Suscribir Mike a 2 topicos A y B, desuscribirse en orden A y B'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion topicoA
java ClienteCmd -usuario Mike -servidor localhost -suscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoA
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoB
echo '#Suscribir Mike a 2 topicos A y B, desuscribirse en orden B y A'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion topicoA
java ClienteCmd -usuario Mike -servidor localhost -suscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoA
echo '#Suscribir Mike a 2 topicos A y B, desuscribirse en orden B, B y A'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion topicoA
java ClienteCmd -usuario Mike -servidor localhost -suscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoA
echo '#Suscribir Mike a 2 topicos A y B, desuscribirse en orden B, C, B y A'
java ClienteCmd -usuario Mike -servidor localhost -suscripcion topicoA
java ClienteCmd -usuario Mike -servidor localhost -suscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoC
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoB
java ClienteCmd -usuario Mike -servidor localhost -desuscripcion topicoA
echo '#Fin'



java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Mike -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones

java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones
java ClienteCmd -usuario Gaby -servidor localhost -verificaBuzonNotificaciones




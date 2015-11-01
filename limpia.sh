echo '#Limpiado procesos'
ps | grep java | awk '{print $1}' | xargs kill -9
ps | grep rmiregistry | awk '{print $1}' | xargs kill -9
echo '#Iniciando Registro RMI'
rmiregistry &
sleep 1
echo '#Iniciando Proceso Servidor'
java Servidor >> servidor.log 2>&1 &
sleep 1
echo '#Ver servidor.log'
javac *.java
ps | grep java | awk '{print $1}' | xargs kill -9
ps | grep rmiregistry | awk '{print $1}' | xargs kill -9
rmiregistry &
java Servidor &

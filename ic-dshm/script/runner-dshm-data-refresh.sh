#COMMON_LIB_HOME=$HOME/applications/opt-baas-services/baas-dshm-services
echo -----------------------------------------COMMON_LIB_HOME $COMMON_LIB_HOME
export COMMON_LIB_HOME

for file in ${COMMON_LIB_HOME}/libs/**/*.jar;
do CP=${CP}:$file;
echo $file
done

CLASSPATH="${CP}"
export CLASSPATH
echo $CLASSPATH
echo
export JAVA_OPTIONS=" -Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dsun.net.inetaddr.ttl=10"
export MEM_ARGS="-Xms128m -Xmx512m"

export RMI_PORT="86861111"
export RMI_SERVER_NAME="dshm-REDIS-DSHM"
#export RMI_REGISTRY_ADD="10.1.234.164:8686"
export IPAAS_CONFIG_PATH=$COMMON_LIB_HOME/config
export PROCESS_PARM="accounts.dshm.protocol.port=$RMI_PORT"

./runner-dshm-data.sh 
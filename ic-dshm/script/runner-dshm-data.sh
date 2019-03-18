#11894
#rt JAVA_HOME=/opt/freeware/jdk1.7.0_71
PROCESS_NAME="ShmLoad"
PROCESS_PARM="dshm.protocol.port=$RMI_PORT"
CUR_USER=`whoami`
#echo "------------------------------------------"


 CLASSPATH="${IPAAS_CONFIG_PATH}:${CLASSPATH}"
echo ${CLASSPATH}
#MEM_ARGS="-Xms1024m -Xmx1024m -XX:PermSize=512M -XX:MaxPermSize=1024M"
 echo ${DUBBO_PORT}
 echo ${DUBBO_REGISTRY_ADD}
MEM_ARGS="-Xms256m -Xmx512m -XX:PermSize=64M -XX:MaxPermSize=128M"
 #${JAVA_HOME}/bin/java ${MEM_ARGS} -Saas.DSHM.registry.address=${RMI_REGISTRY_ADD} -Dpaas.dubbo.registry.file=./.dubbo-registry.dat -Dpaas.dubbo.protocol.port=#$DUBBO_PORT  ${JAVA_OPTIONS} com.ai.saas.isaas.ebilling.shm/sys/service/DshmServicePublisher > ${HOME}/logs/saas-${RMI_SERVER_NAME}-${RMI_PORT}.log & 2>&1 &
# ${JAVA_HOME}/bin/java
START_CMD="${MEM_ARGS}    ${JAVA_OPTIONS} com.ai.baas.dshm.api.dshmprocess.impl.DshmSVImpl > ${HOME}/logs/opt-baas-logs/dshm_load_SERVER_NAME.log 2>&1 &"
java ${START_CMD}
echo "ipaas dubbo server started!! process param is [$PROCESS_PARM].logs at $HOME/logs/opt-baas-logs/dshm_load_SERVER_NAME.log"

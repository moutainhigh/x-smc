#!/bin/sh
echo "111111111111111111111111111111111111"
for file in ${COMMON_LIB_HOME}/libs/**/*.jar;
do CP=${CP}:$file;
done

DUBBO_CONFIG_PATH=${COMMON_LIB_HOME}/config
LOG_PATH=${COMMON_LIB_HOME}/logs/opt-baas-logs/baas-dshm-dubbo.log
CLASSPATH="${CP}"
CLASSPATH="${DUBBO_CONFIG_PATH}:${CLASSPATH}"
CCSPROP=${COMMON_LIB_HOME}/ccsprop
export CLASSPATH

MEM_ARGS="-Xms256m -Xmx512m -XX:PermSize=64M -XX:MaxPermSize=128M"
JAVA_OPTIONS="-Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dsun.net.inetaddr.ttl=10 -Ddubbo.provider.timeout=20000 -Djava.security.egd=file:/dev/./urandom"

START_CMD1="${MEM_ARGS} ${JAVA_OPTIONS} com.ai.opt.sdk.appserver.LoadConfServiceStart $CCSPROP"
echo ${START_CMD1}
#java ${START_CMD}
echo"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"
START_CMD="${MEM_ARGS} -Dcenter.dubbo.registry.address=${DUBBO_REGISTRY_ADDR} -Ddubbo.protocol.port=${DUBBO_PORT} -Ddubbo.protocol=${DUBBO_PROTOCOL} ${JAVA_OPTIONS} com.ai.opt.sdk.appserver.DubboServiceStart  >> $LOG_PATH & 2 > 1 &"

echo ${JAVA_HOME}
echo ${CLASSPATH}
echo "DUBBO_PORT = [${DUBBO_PORT}"
echo "START_CMD = [${START_CMD}]"
sed -i "s/paas.sdk.mode=.*/paas.sdk.mode=${SDK_MODE}/g" /baas-dshm-service/config/paas/paas-conf.properties
sed -i "s/ccs.appname=.*/ccs.appname=${CCS_NAME}/g" /baas-dshm-service/config/paas/paas-conf.properties
sed -i "s/ccs.zk_address=.*/ccs.zk_address=${ZK_ADDRESS}/g" /baas-dshm-service/config/paas/paas-conf.properties

sed -i "s/jdbc.url=.*/jdbc.url=jdbc:mysql:\/\/${DB_HOST}\/${DB_NAME}?useUnicode=true\&characterEncoding=UTF-8/g" /baas-dshm-service/config/context/jdbc.properties
sed -i "s/jdbc.username=.*/jdbc.username=${DB_USRER}/g" /baas-dshm-service/config/context/jdbc.properties
sed -i "s/jdbc.password=.*/jdbc.password=${DB_PWD}/g" /baas-dshm-service/config/context/jdbc.properties


echo "------------------- baas dshm  service start --------------------"
#java ${START_CMD1}
java ${START_CMD}
echo "------------------- baas dshm service started! -------------------"

1.编译打包
gradle build -x test

2.生成镜像
在本地生成镜像
docker build -t dshm:ai .
docker build -t 10.1.234.164:5000/dshm:ai .
docker push 10.1.234.164:5000/dshm:ai

3. 运行镜像
docker run -d --name baas-dshm --net=host -p 11884:49488 \
-e "DUBBO_REGISTRY_ADDR=10.1.130.84:39181" \
-e "DUBBO_PORT=11884" \
-e "PROTOCOL=dubbo" \
-e "SDK_MODE=1" \
-e "CCS_NAME=aiopt-baas-dshm" \
-e "ZK_ADDRESS=10.1.130.84:39181" \
-e "DB_HOST=10.1.235.245:31306" \
-e "DB_NAME=dev_baas_sys1" \
-e "DB_USRER=sysusr01" \
-e "DB_PWD=sysusr01_123" \
dshm:0.1


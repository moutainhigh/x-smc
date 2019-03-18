# Pull base image
FROM centos:7
MAINTAINER biancx<biancx@asiainfo.com>
#FROM docker.io/mysql:5.7 
WORKDIR /
RUN yum install -y java-1.8.0-openjdk

# deploy user dubbo service
COPY ./build/libs /baas-dshm-service/libs/
COPY ./build/config /baas-dshm-service/config/

#mkdir logs path
RUN cd /baas-dshm-service && mkdir logs && cd /baas-dshm-service/logs && mkdir opt-baas-logs

## copy start script
COPY ./script/baas-dshm-service.sh /baas-dshm-service.sh
COPY ./script/runner-dshm-data-refresh.sh /runner-dshm-data-refresh.sh
COPY ./script/runner-dshm-data.sh /runner-dshm-data.sh
RUN chmod 755 /baas-dshm-service.sh
RUN chmod 755 /runner-dshm-data-refresh.sh
RUN chmod 755 /runner-dshm-data.sh
RUN cd /etc && rm -f localtime && ln -s  /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
# set start parameter for dubbo service
ENV COMMON_LIB_HOME /baas-dshm-service

# Expose ports.
#EXPOSE 10880

# Define default command.
CMD ["./baas-dshm-service.sh"]
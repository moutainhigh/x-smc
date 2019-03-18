
FROM centos:7

MAINTAINER ai-opt

RUN yum install -y java-1.8.0-openjdk

# copy service files
COPY ./build/config runner-customer/config
COPY ./build/libs runner-customer/libs

# copy shell
COPY ./script/runner-customer-service.sh runner-customer
#COPY ./script/runner-customer-cache.sh runner-customer
RUN chmod 755 runner-customer/*.sh

RUN mkdir runner-customer/logs

EXPOSE 10774

ENV APP_HOME /runner-customer

RUN cd /etc && rm -f localtime && ln -s  /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

CMD ["./runner-customer/runner-customer-service.sh"]



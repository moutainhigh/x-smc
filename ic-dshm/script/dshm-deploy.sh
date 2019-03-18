#!/bin/sh

echo "create dshm service on k8s cluster...."

exist=`kubectl get svc --namespace=unit-test |awk '{print $1}'| egrep "^dshm$" `
if [ "$exist" = "" ]
then
  echo "dshm service not exist! NOT need delete "
else
  kubectl delete svc dshm --namespace=unit-test
fi

kubectl create -f ./script/dshm-service.json
echo "dshm service done"

echo "create dshm ReplicationController on k8s cluster...."
exist=`kubectl get ReplicationController --namespace=unit-test | awk '{print $1}' | egrep "^dshm-rc$" `
if [ "$exist" = "" ]
then
  echo "dshm ReplicationController not exist! NOT need delete"
else
  kubectl delete ReplicationController dshm-rc --namespace=unit-test
fi

kubectl create -f ./script/dshm-ReplicationController.json
echo "dshm ReplicationController done"



#!/usr/bin/env bash
filename='names.txt'
regexp="[[:space:]]+0[[:space:]]+"
while read line ;do
  #reading each line
  if [[ $line =~ $regexp ]]; then
  echo $line
  IFS='  ' read -r -a array <<< "$line"
    ipaddress=${array[3]}
    animal=${array[1]}
    store_num=${array[2]}
    #echo $store_num
    #echo $animal
    #echo $ipaddress
    outputx="$(kubectl get pods -n ${animal} -l app=checkoutcassandra -o wide | grep ${store_num})"
    output="${outputx%x}"
  while IFS= read -r x ;
  do #echo $x
  if [[ $x == $ipaddress ]]; then
    IFS='  ' read -r -a array1 <<< "$x"
    echo "kubectl delete pod ${array1[0]} -n $animal" >> delete.txt
    echo "It's there!"
  fi
  done <<< "$output"
  fi
done < $filename
#kubectl get pods -n tiger  -l app=checkoutcassandra -o wide | grep T0154
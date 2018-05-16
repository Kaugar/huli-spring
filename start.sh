#!/bin/bash
baseName="hulispring"

docker stop ${baseName}-mysql
docker rm ${baseName}-mysql
docker run --name ${baseName}-mysql \
              -p 3306:3306 \
              -d \
              ${baseName}-mysql

#-v /Users/martinweltler/Desktop/greenfox/docker-project:/root/ \
docker stop gradle-spring
docker rm gradle-spring
docker run --name gradle-spring \
              -p 8080:8080 \
              -e DATABASE_URL='jdbc:mysql://hulispring-mysql:3306/demo' \
              -e DATABASE_USER='user' \
              -e DATABASE_PASSWORD='pass' \
              --link ${baseName}-mysql:mysql \
              -t \
              gradle-spring

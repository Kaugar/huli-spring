#!/bin/bash
baseName="hulispring"

docker stop ${baseName}-mysql
docker rm ${baseName}-mysql
docker run --name ${baseName}-mysql \
              -p 3306:3306 \
              -d \
              ${baseName}-mysql

docker stop ${baseName}-web
docker rm ${baseName}-web
docker run --name ${baseName}-web \
              -p 8080:8080 \
              --link ${baseName}-mysql:mysql \
              -t \
              ${baseName}-web

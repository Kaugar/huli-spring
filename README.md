# huli-spring
This is a docker image with contains java:8 and gradle environment, and a sample app. With it you can start your own java spring boot project on your machine, without installing the development environment. Just use your favourite IDE.

## Install docker
As Docker is highly scalable it can run on robust servers and on your PC too
provided it has 64bit architecture and OS, et least 4GB (**8GB is recomended**) of RAM, and hardware supported virtualization enabled (Check the Systeminfo, BIOS or UEFI for these informations)  

#### (please use the Stable version!)

### [Windows](https://docs.docker.com/docker-for-windows/install/)

### [Linux](https://github.com/DonBattery/Docker/blob/master/dockerguide.md)

### [Mac](https://docs.docker.com/docker-for-mac/)

## Pull the image from dockerhub:
```
docker pull huli/gradle
```
### run the sample app
Go inside the folder of the demo and run:
```
docker compose-up -t
```

Now start all the container with:
```
./start.sh

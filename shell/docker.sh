#!/bin/bash
USR=""
PWD="123456"
function mysql(){
        docker pull mysql:5.7
        mkdir -p /opt/docker/mysql/data
	rm -rf /opt/docker/mysql/data/*
        docker run --name mysql -e MYSQL_ROOT_PASSWORD=$PWD \
        --privileged \
        -v /opt/docker/mysql/data:/var/lib/mysql \
        -v /opt/docker/mysql/conf:/etc/mysql/conf.d  \
        -p 3306:3306 \
        -d mysql:5.7   
}

function redis(){
	docker pull redis;
	mkdir -p /opt/docker/redis
	DIR=/opt/docker/redis
	CONF=$DIR/conf/redis.conf
	echo "dir /data" > $CONF
	echo "protected-mode no" >> $CONF
	echo "appendonly yes" >> $CONF
	echo "requirepass " $PWD >> $CONF
	docker run --name redis \
	--privileged \
	-v $CONF:/etc/redis/redis.conf \
	-v $DIR/logs:/logs \
	-v $DIR/data:/data \
	-p 6379:6379 \
	-d redis:latest  \
	redis-server /etc/redis/redis.conf
}

function mongod(){
	docker pull mongo:latest
	mkdir -p /opt/docker/mongodb
	DIR=/opt/docker/mongodb
	docker run --name mongo \
	-v $DIR/data:/data \
	-v $DIR/mongod.conf:/etc/mongod.conf \
	-p 27017:27017 \
	-d mongo:latest --auth
}
case $1 in
        mysql)
                if [ -n "$2" ]; then
                        PWD=$2  
                fi
                mysql
        ;;
	redis)
		if [ -n "$2" ]; then
			PWD=$2
		fi
		redis
	;;
	mongo)
		mongod
	;;
        stop)
                case $2 in
                        mysql)
                                docker stop mysql;
                        ;;
                esac
        ;;
        *)
                echo "error"
        ;;
esac


- install

  ~~~ shell
  ### 安装
  yum install docker -y
  ## 启动
  service docker start
  ~~~

- config

  ~~~ shell
  ## 拉取镜像
  docker pull imageName(镜像名称)
  ## 启动容器
  docker run --name mysql(容器名称) --privileged(文件root权限) -d imageName(镜像名称) \
  -v /data/config/mysql:/etc/mysql/conf.d  (目录/文件挂载 主机路径:容器内部路径)
  -p 3307:3306 (端口映射  主机端口:容器端口)
  -e MYSQL_ROOT_PASSWORD=123456  (容器环境变量配置 如数据库密码 MYSQL_ROOT_PASSWORD=123456)
  ~~~

### docker - contain

- [docker.sh](./docker.sh)

- mysql

  ~~~ shell
  ## 拉取
  docker pull mysql:5.7
  mkdir -p /opt/docker/mysql/data
  rm -rf /opt/docker/mysql/data/*
  docker run --name mysql -e MYSQL_ROOT_PASSWORD=$PWD --privileged \ 
  -v /opt/docker/mysql/data:/var/lib/mysql \
  -v /opt/docker/mysql/conf:/etc/mysql/conf.d  \
  -p 3306:3306 \
  -d mysql:5.7  
  ~~~

- redis

  ~~~ shell
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
  ~~~

- mongod

  ~~~ shell
  docker pull mongo:latest
  mkdir -p /opt/docker/mongodb
  DIR=/opt/docker/mongodb
  docker run --name mongo \
  -v $DIR/data:/data \
  -v $DIR/mongod.conf:/etc/mongod.conf \
  -p 27017:27017 \
  -d mongo:latest --auth
  ~~~

- minio

  ~~~ shell
  docker pull minio/minio:RELEASE.2021-03-12T00-00-47Z
  docker run -p 9000:9000  --name minio --restart=always --privileged \
  -e MINIO_ACCESS_KEY=admin \
  -e MINIO_SECRET_KEY=$PWD \
  -v /data/www:/data \
  -v /data/conf/minio:/root/.minio \
  -d minio/minio:RELEASE.2021-03-12T00-00-47Z server /data
  ~~~

  


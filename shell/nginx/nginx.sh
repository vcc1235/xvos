###  安装nginx 
### http://nginx.org/download/nginx-1.18.0.tar.gz
cd 
nginxTar="nginx-1.18.0.tar.gz"
nginxDir="nginx-1.18.0"
nginx="/usr/local/nginx"

echo "Nginx 所需环境"
env(){
  if [ ! -x "openssl" ];then
     yum install zlib zlib-devel gcc-c++ libtool wget openssl openssl-devel -y
     yum install pcre -y
  else
     echo "环境已安装"
  fi
}
download(){
  if [ ! -f $nginxTar ];then
    wget http://nginx.org/download/nginx-1.18.0.tar.gz
  else
    echo "nginx-1.18.0.tar.gz 文件已存在"
  fi
}
install(){
  if [ ! -f $nginxTar ];then
    wget http://nginx.org/download/nginx-1.18.0.tar.gz
  else
    echo "nginx-1.18.0.tar.gz 文件已存在"
  fi
  if [ ! -d "$nginxDir" ];then
    tar -zxvf $nginxTar
  else
    rm -rf $nginxDir
    tar -zxvf $nginxTar
  fi
  cd $nginxDir
  ./configure --prefix=$nginx --with-http_stub_status_module --with-http_ssl_module
  make
  make install
  if [ ! -d "$nginx/sbin" ];then
    echo "搭建失败"
    exit
  else 
    echo "Nginx 搭建成功"
  fi
}
if [ ! -d "$nginx/sbin" ];then
  env
  download
  install
else 
  echo "Nginx 搭建成功"
fi
cd
## 软链接  环境变量
if [ -f "/usr/bin/nginx" ];then
  rm -rf /usr/bin/nginx
fi
ln -s $nginx/sbin/nginx /usr/bin/nginx
## 删除自带 conf
rm -rf /usr/local/nginx/conf/nginx.conf
## 复制已有配置文件  自定义配置
if [ ! -f "/root/nginx.conf" ];then
 echo "/root/nginx.conf 文件不存在"
 exit
fi
cp /root/nginx.conf /usr/local/nginx/conf/nginx.conf
## data/conf 下配置
if [ ! -d "$nginx/conf/vhost" ];then
 echo "创建自定义配置目录"
 mkdir -p $nginx/conf/vhost
fi
## 软连接配置目录
if [ ! -d "/data/conf/nginx" ];then
 echo "创建软连接配置目录"
 mkdir -p /data/conf/nginx
fi
## 日志路径
if [ ! -d "/data/logs/nginx" ];then
 echo "创建日志目录"
 mkdir -p /data/logs/nginx
fi
## 80 端口转发
touch /usr/local/nginx/conf/vhost/server.conf
## 添加 其他端口转发
touch /usr/local/nginx/conf/vhost/www.conf
ln -s /usr/local/nginx/conf/nginx.conf /data/conf/nginx/nginx.conf
ln -s /usr/local/nginx/conf/vhost/server.conf /data/conf/nginx/server.conf
ln -s /usr/local/nginx/conf/vhost/www.conf /data/conf/nginx/www.conf
result=`ps -ef|grep nginx| grep -v 'grep' | grep -v 'worker' | awk '{print $2}'`
pid=`echo $result| awk '{print $1}'`
echo $result
echo $pid
if [ $pid > 0 ];then
echo "Nginx 服务已运行"
nginx -s stop
fi
nginx


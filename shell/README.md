### Shell

- [docker](./docker.md)

- nginx

  - [nginx.sh](./nginx/nginx.sh)
  - [nginx.conf](./nginx/nginx.conf) 
    - nginx.conf 文件放入 /root/目录下
    - 执行 nginx.sh 命令即可
  
  ~~~ shell
  ## reload 重启  stop停止
  nginx -s reload/stop
  ~~~
  
- firewalld

  ~~~ shell
  ## start/stop/restart
  service firewalld start/stop
  ## 添加规则
  ## --add-rich-rule= 规则
  ## --permanent 重启生效  如果没有添加 则不需要重启firewalld,重启会无效
  firewall-cmd --add-rich-rule="rule family="ipv4" source address="192.168.1.0/24" accept" --permanent
  ~~~

- nc 

  ~~~ shell
  ## 安装
  yum install nc -y
  ## 发送端
  nc -nv 192.168.1.1 8888 < 文件路径
  ## 接收端
  nc -lv 8888 > 文件路径
  ~~~

  


#!/bin/sh
date=`/bin/date +"%F %R"`
echo "时间:" $date  >> /data/testsh.info
online=`/usr/bin/who |grep  -v wf` 
echo "当前在线:" $online  >> /data/testsh.info
dfh=`/bin/df -h`
echo "磁盘空间:" $dfh  >> /data/testsh.info 









```
#定义变量basepath为当前目录
basepath=$(cd `dirname $0`; pwd)
jarpath="${basepath}/xxx.jar"
#echo 输入变量 ${}
echo ${jarpath}
# nohup & 后台开始进程
nohup `java -jar ${jarpath}` &>/dev/null &
```
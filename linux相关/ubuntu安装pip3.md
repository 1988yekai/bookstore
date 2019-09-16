## pip安装

1. 添加源

   打开文件：

   ```
   sudo vi /etc/apt/sources.list
   ```

   添加：

   ```
   deb http://cn.archive.ubuntu.com/ubuntu bionic main multiverse restricted universe
   deb http://cn.archive.ubuntu.com/ubuntu bionic-updates main multiverse restricted universe
   deb http://cn.archive.ubuntu.com/ubuntu bionic-security main multiverse restricted universe
   deb http://cn.archive.ubuntu.com/ubuntu bionic-proposed main multiverse restricted universe
   ```

2. 安装 

   ```
   sudo apt-get install python3-pip
   ```

3. #### 升级pip3

   系统虽然给出了更新pip的命令，不过这里不建议大家使用这样的命令，建议使用`sudo pip3 install --upgrade pip`来更新pip3

4. 卸载pip3

   ```
   sudo apt-get remove python3-pip
   ```

   

## pip换国内源：

方案一：

修改配置文件

```
mkdir ~/.pip
```

```
vim ~/.pip/pip.conf
```

\# 然后将下面这两行复制进去就好了
[global]
index-url = https://mirrors.aliyun.com/pypi/simple

\#--------------------------------------------------------------------
国内其他pip源

​    清华：https://pypi.tuna.tsinghua.edu.cn/simple
​    中国科技大学 https://pypi.mirrors.ustc.edu.cn/simple/
​    华中理工大学：http://pypi.hustunique.com/
​    山东理工大学：http://pypi.sdutlinux.org/
​    豆瓣：http://pypi.douban.com/simple/

注意：不管你用的是pip3还是pip，方法都是一样的，都是创建pip文件夹。

方案二：

临时给pip 或 pip3换源

命令格式：sudo pip3 install 包名 -i 镜像源url
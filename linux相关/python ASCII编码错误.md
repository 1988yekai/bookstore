## 在 linux服务器上运行代码报错：

Python3中遇到

UnicodeEncodeError: ‘ascii’ codec can’t encode characters in ordinal not in range(128)

方法一：

[ubuntu 设置字符集 locale（解决乱码问题）](https://www.cnblogs.com/wclwcw/p/6758353.html) https://www.cnblogs.com/wclwcw/p/6758353.html （优选）

18.04 添加中文支持，设置LANG环境变量 https://blog.csdn.net/j___t/article/details/97705231
1. 添加中文支持
`sudo apt-get -y install language-pack-zh-hans`
2. `locale-gen en_US.UTF-8`
3. 设置LANG环境变量
vim ~/.bashrc 添加

   `export LANG=en_US.UTF-8`
执行 source~/.bashrc

方法二：

1. 参考 https://blog.csdn.net/th_num/article/details/80685389

2. 查看编码

   ```
   >>> import sys
   >>> sys.stdout.encoding
   'US-ASCII'
   ```

   而另一台能正常打印的机器是 en_US.UTF-8

3. 解决办法

   3.1 设置环境变量LANG

   在linux或Mac上设置环境变量的方式一样，编辑~/.bash_profile文件（’~’指的是用户登录后的默认目录），添加一行：

   ```
   export LANG="en_US.UTF-8"
   ```

   执行 `source ~/.bash_profile` 立即生效

   3.2 重新定义标准输出

   python文件添加代码：

   ```
   import sys
   import codecs
   sys.stdout = codecs.getwriter("utf-8")(sys.stdout.detach())
   print('中文')
   ```

   

方法三：

1. 添加源（1804）

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

2. 更新 apt-get update

3. 修改bash配置文件

   vim ~/.bashrc 添加

   `export LANG=en_US.UTF-8`

4. 执行 source~/.bashrc

5. 安装汉字支持

   apt-get install language-pack-zh-hans

   修改配置文件

   vim /var/lib/locales/supported.d/local

   ```
   en_US.UTF-8 UTF-8
   zh_CN.UTF-8 UTF-8
   zh_CN.GBK GBK
   zh_CN GB2312
   ```

   执行 locale-gen
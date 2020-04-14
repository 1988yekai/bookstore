## Ubuntu安装openjdk8

1.  apt-get 命令安装

```bash
sudo apt-get install -y openjdk-8-jdk
```

2. 修改当前用户配置文件，只作用于当前用户：`sudo vim ~/.bashrc`

   ```bash
   export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
   export JRE_HOME=${JAVA_HOME}/jre
   export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
   export PATH=.:${JAVA_HOME}/bin:$PATH
   ```

3. 应用变更 `source ~/.bashrc`
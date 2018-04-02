## aliyun maven完整setting

	<?xml version="1.0" encoding="UTF-8"?>
	<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
	          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
	  <!--<localRepository>D:/repositories/maven</localRepository>-->
	  <pluginGroups></pluginGroups>
	  <proxies></proxies>
	  <servers></servers>
	  <mirrors>
	    <mirror>
	      <id>central</id>
	      <mirrorOf>*</mirrorOf>
	      <name>Nexus Aliyun</name>
	      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
	    </mirror>
	  </mirrors>
	  <!-- 注意：以下配置用于指定Maven插件的仓库，不能省略，否则可能出现无法加载Maven插件的问题（如：`com.mysema.maven:apt-maven-plugin`） -->
	  <profiles>
	    <profile>
	      <id>nexus</id>
	      <repositories>
	        <repository>
	          <id>nexus-repo</id>
	          <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
	          <releases><enabled>true</enabled></releases>
	          <snapshots><enabled>true</enabled></snapshots>
	        </repository>
	      </repositories>
	      <pluginRepositories>
	        <pluginRepository>
	          <id>nexus-repo</id>
	          <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
	          <releases><enabled>true</enabled></releases>
	          <snapshots><enabled>true</enabled></snapshots>
	        </pluginRepository>
	      </pluginRepositories>
	    </profile>
	  </profiles>
	  <activeProfiles>
	    <activeProfile>nexus</activeProfile>
	  </activeProfiles>
	</settings>


##我们还可以设置以下的Maven仓库地址，如下：

<mirrors>
    <mirror>
      <id>wso2maven</id>
      <name>wso2 maven</name>
      <url>http://maven.wso2.org/nexus/content/groups/public/</url>
      <mirrorof>central</mirrorof>
    </mirror>
</mirrors>
替换上最上面阿里云Maven仓库地址即可。以下的地址也可以使用：

http://maven.wso2.org/nexus/content/groups/public/
http://jcenter.bintray.com/
http://maven.antelink.com/content/repositories/central/
http://maven.springframework.org/release/
http://maven.antelink.com/content/repositories/central/
http://mavensync.zkoss.org/maven2/
http://repository.jboss.com/maven2/
http://maven.aliyun.com/nexus/content/groups/public
http://uk.maven.org/maven2/
http://repo1.maven.org/maven2/
http://maven.springframework.org/milestone
http://maven.jeecg.org/nexus/content/repositories/
https://repository.apache.org/content/groups/public/
https://repository.jboss.org/nexus/content/repositories/releases/
http://repo.maven.apache.org/maven2
https://oss.sonatype.org/content/repositories
http://repo.spring.io/release/
http://repo.spring.io/snapshot/

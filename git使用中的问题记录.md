#1.  git如何移除某文件的版本控制
参考： http://blog.csdn.net/lxf0613050210/article/details/50749881
1.1：还没有加到版本控制中

     (1)还没有git  add

          在   .gitignore中添加

     (2)已经git add

          先   git  rm  -r  --cached   文件

          在   .gitignore中添加

1.2：已经加到版本控制中

         先   git  rm  -r  --cached   文件  

        在   .gitignore中添加

        最后  gti commit -m  '提交.gitignore'

#2. git pull 命令用法：  
> git pull origin master

#3. git push 命令用法：  
> git push -u origin master 

上面命令将本地的master分支推送到origin主机，同时指定origin为默认主机，后面就可以不加任何参数使用git push了。不带任何参数的git push，默认只推送当前分支，这叫做simple方式。此外，还有一种matching方式，会推送所有有对应的远程分支的本地分支。Git 2.0版本之前，默认采用matching方法，现在改为默认采用simple方式。
#1.  git如何移除某文件的版本控制
参考： http://blog.csdn.net/lxf0613050210/article/details/50749881
1：还没有加到版本控制中

     (1)还没有git  add

          在   .gitignore中添加

     (2)已经git add

          先   git  rm  -r  --cached   文件

          在   .gitignore中添加

2：已经加到版本控制中

         先   git  rm  -r  --cached   文件  

        在   .gitignore中添加

        最后  gti commit -m  '提交.gitignore'
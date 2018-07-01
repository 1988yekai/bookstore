## 1.定义文件
- 1.txt 内容：
```
123
456
789
#start#
321
654
987
#end#
abc
def
```
- 2.txt 内容：
```
aaa
vvv
ccc
```
## 2.需求 使用2.txt中内容替换 #start# 和 #end# 之间内容：
+ 查找标志
> grep -n "#start#" 1.txt | head -1 | cut -d ":" -f 1 #查找第一行

> grep -n "#end#" 1.txt | tail -1 | cut -d ":" -f 1 #查找最后一行

+ sed 删除行
> sed -e "1,2d" -i 1.txt #删除1,2行
+ sed 插入行
> sed -e "2 i aaa" -i 1.txt #i 第2行前插入行aaa

> sed -e "2 a aaa" -i 1.txt #a 第2行后插入行aaa
## 3. shell程序
```
    #!/usr/bin/bash

    startline=`grep -n "#start#" 1.txt | head -1 | cut -d ":" -f 1`
    startline=$(($startline+1))
    endline=`grep -n "#end#" 1.txt | tail -1 | cut -d ":" -f 1`
    endline=$(($endline-1))
    echo $startline $endline
    sed -e "${startline},${endline}d" -i 1.txt

    while read LINE 
    do 
    endline=`grep -n "#end#" 1.txt | tail -1 | cut -d ":" -f 1`
    temp="$endline i $LINE"
    echo $temp
    sed -e "$temp" -i 1.txt
    done < 2.txt
```

## 批量查找替换 find sed, 把2.txt中内容aaa替换bbb
> find . -name 2.txt -exec sed -i -e "s|aaa|bbb|g" {} \;

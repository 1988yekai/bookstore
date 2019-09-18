1. Chrome浏览器下载 https://www.google.com/chrome/ 

2. 安装chrome `yum install -y google-chrome-stable_current_x86_64.rpm`

   安装完成后的目录，安装完成chrome的目录在 `/opt/google/chrome`

3. 卸载 `yum autoremove -y google-chrome`

4. 查看版本 `/opt/google/chrome/chrome --version`

5. root用户运行需加参数 `--no-sandbox`

 
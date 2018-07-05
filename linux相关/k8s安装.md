##使用kubeadm安装Kubernetes v1.10.0
###1. 关于K8S：

Kubernetes是Google开源的容器集群管理系统。它构建于docker技术之上，为容器化的应用提供资源调度、部署运行、服务发现、扩容缩容等整一套功能，本质上可看作是基于容器技术的mini-PaaS平台。

###2. 准备

虚拟机安装 centos7系统
系统安装docker

1.配置好各节点hosts文件
> vim /etc/hosts

2.关闭各节点系统防火墙
> systemctl stop firewalld
> systemctl disable firewalld

3.关闭各节点SElinux
> cat /etc/selinux/config
> SELINUX=disabled

4.关闭各节点swap
> swapoff -a #临时关闭
> vim /etc/fstab #注释掉包含swap的那一行可以永久关闭

5.创建/etc/sysctl.d/k8s.conf文件，添加如下内容：
```
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
net.ipv4.ip_forward = 1

执行如下命令使修改生效：
modprobe br_netfilter
sysctl -p /etc/sysctl.d/k8s.conf
```
###3. 步骤
3.1配置各节点阿里K8S YUM源
```
cat <<EOF > /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=http://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=0
repo_gpgcheck=0
gpgkey=http://mirrors.aliyun.com/kubernetes/yum/doc/yum-key.gpg
    http://mirrors.aliyun.com/kubernetes/yum/doc/rpm-package-key.gpg
EOF
```
3.2在各节点安装kubeadm和相关工具包

    # yum -y remove kube* #卸载可选

yum makecache fast && yum install -y kubelet-1.10.0-0 kubeadm-1.10.0-0 kubectl-1.10.0-0

3.3启动Docker与kubelet服务
```
systemctl enable docker && systemctl start docker
 
systemctl enable kubelet && systemctl start kubelet
```

3.4拉取1.10.0镜像
```
docker pull cnych/kube-apiserver-amd64:v1.10.0
docker pull cnych/kube-scheduler-amd64:v1.10.0
docker pull cnych/kube-controller-manager-amd64:v1.10.0
docker pull cnych/kube-proxy-amd64:v1.10.0
docker pull cnych/k8s-dns-kube-dns-amd64:1.14.8
docker pull cnych/k8s-dns-dnsmasq-nanny-amd64:1.14.8
docker pull cnych/k8s-dns-sidecar-amd64:1.14.8
docker pull cnych/etcd-amd64:3.1.12
docker pull cnych/flannel:v0.10.0-amd64
docker pull cnych/pause-amd64:3.1

docker tag cnych/kube-apiserver-amd64:v1.10.0 k8s.gcr.io/kube-apiserver-amd64:v1.10.0
docker tag cnych/kube-scheduler-amd64:v1.10.0 k8s.gcr.io/kube-scheduler-amd64:v1.10.0
docker tag cnych/kube-controller-manager-amd64:v1.10.0 k8s.gcr.io/kube-controller-manager-    amd64:v1.10.0
docker tag cnych/kube-proxy-amd64:v1.10.0 k8s.gcr.io/kube-proxy-amd64:v1.10.0
docker tag cnych/k8s-dns-kube-dns-amd64:1.14.8 k8s.gcr.io/k8s-dns-kube-dns-amd64:1.14.8
docker tag cnych/k8s-dns-dnsmasq-nanny-amd64:1.14.8 k8s.gcr.io/k8s-dns-dnsmasq-nanny-amd64:1.14.8
docker tag cnych/k8s-dns-sidecar-amd64:1.14.8 k8s.gcr.io/k8s-dns-sidecar-amd64:1.14.8
docker tag cnych/etcd-amd64:3.1.12 k8s.gcr.io/etcd-amd64:3.1.12
docker tag cnych/flannel:v0.10.0-amd64 quay.io/coreos/flannel:v0.10.0-amd64
docker tag cnych/pause-amd64:3.1 k8s.gcr.io/pause-amd64:3.1
```

3.5配置 kubelet
```
$ docker info |grep Cgroup
Cgroup Driver: cgroupfs

vim /etc/systemd/system/kubelet.service.d/10-kubeadm.conf
修改 
Environment="KUBELET_CGROUP_ARGS=--cgroup-driver=cgroupfs"
重新加载我们的配置文件
systemctl daemon-reload
```
3.6master节点初始化
```
kubeadm init --kubernetes-version=v1.10.0 --pod-network-cidr=10.244.0.0/16 --apiserver-advertise-address=xxx.xxx.xxx.xxx

xxx.xxx.xxx.xxx替换master具体IP

注意记录输出:
You can now join any number of machines by running the following on each node
as root:

kubeadm join xxx.xxx.xxx.xxx:6443 --token 7uznt6.vzfh109zpz4mdu9t --discovery-token-ca-cert-hash sha256:d8a5617375d0b609cfbceaa1d5b4fc554066af3cef4da14fedc316aa225b8a0d

子节点使用kubeamd添加节点时使用
```

3.7配置kubectl认证信息（Master节点操作）
```
# 对于非root用户
mkdir -p $HOME/.kube
 
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
 
sudo chown $(id -u):$(id -g) $HOME/.kube/config
 
# 对于root用户
export KUBECONFIG=/etc/kubernetes/admin.conf
 
也可以直接放到~/.bash_profile
 
echo "export KUBECONFIG=/etc/kubernetes/admin.conf" >> ~/.bash_profile
```

3.8安装flannel网络（Master节点操作）
```
wget https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml
kubectl apply -f kube-flannel.yml
```
或者
```
mkdir -p /etc/cni/net.d/
 
cat <<EOF> /etc/cni/net.d/10-flannel.conf
{
“name”: “cbr0”,
“type”: “flannel”,
“delegate”: {
“isDefaultGateway”: true
}
}
 
EOF
 
mkdir /usr/share/oci-umount/oci-umount.d -p
 
mkdir /run/flannel/
 
cat <<EOF> /run/flannel/subnet.env
FLANNEL_NETWORK=10.244.0.0/16
FLANNEL_SUBNET=10.244.1.0/24
FLANNEL_MTU=1450
FLANNEL_IPMASQ=true
 
EOF
 
kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/v0.9.1/Documentation/kube-flannel.yml

```
3.9让node1等加入集群
运行安装master输出的：
```
kubeadm join xxx.xxx.xxx.xxx:6443 --token 7uznt6.vzfh109zpz4mdu9t --discovery-token-ca-cert-hash sha256:d8a5617375d0b609cfbceaa1d5b4fc554066af3cef4da14fedc316aa225b8a0d
```
3.10验证K8S Master是否搭建成功（Master节点操作）
# 查看节点状态
kubectl get nodes
 # 查看pods状态
kubectl get pods --all-namespaces
 # 查看K8S集群状态
kubectl get cs

3.11注意事项
安装失败回退命令
> kubeadm reset
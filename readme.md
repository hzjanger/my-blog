## 后端项目发布

### 查看端口

```bash
lsof -i:8080
# 端口被占用直接暴力杀死
kill -9 <PID>
```

### 更新代码

```bash
git pull
```

### 启动项目

```bash
# 使员工nohup启动,可以在后台运行,在根目录下会创建nohup.out文件,这个文件记录了运行的日志
nohup mvn spring-boot:run &
# 输入这个命令时候直接按enter键
```

## 前端项目发布

### 在本地将docker打包好并上传到阿里云镜像

```bash
# 进入前端项目根目录
ng build

# 本地创建docker镜像
docker build -f Dockerfile -t my-blog .

# IMAGE ID为镜像的id, TAG为版本号,可以不写,不写默认为latest
docker tag <IMAGE ID> registry.cn-beijing.aliyuncs.com/hezhijian/blog:[TAG]

# 提交docker到阿里云镜像
docker push registry.cn-beijing.aliyuncs.com/hezhijian/blog:[TAG]
```

### 登录自己的服务器

```bash
ssh user@IPAddress

# 将上传的镜像pull下来
docker pull registry.cn-beijing.aliyuncs.com/hezhijian/blog

# 名字太长了,换个名字
docker tag <IMAGE ID> my-blog

# 启动镜像
docker run --name blog -p 4200:80 -d my-blog
```
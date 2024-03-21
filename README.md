# minio-upload

#### 介绍
使用vue3 elementplus minio springboot 实现大文件的分片上传、断点续传、秒传的功能demo


#### 演示
![输入图片说明](images/demo.gif)
![输入图片说明](images/shili.gif)

#### 环境
java 8
node 15 以上
mysql 8
minio

#### 安装教程

后端：
1. 创建数据库，导入sql脚本
![输入图片说明](images/create-db.png)
2. 修改yml文件，将mysql，minio的配置改为你的配置
![输入图片说明](images/yml-config.png)
3. 在minio中创建你在步骤二中配置的桶
4. 运行springboot
![输入图片说明](images/run.png)

前端：

进入到前端项目根目录
```
cd minio-upload-web
```

``` javascript
// 运行
npm install
npm run dev
```
浏览器访问控制台输出的地址
![输入图片说明](images/run-web.png)


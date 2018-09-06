# Weixin

### 环境
安装JDK 8
替换微信配置项：

	wechat.mp.appId=
	wechat.mp.secret=
	wechat.mp.token=weixinldk
	wechat.mp.aesKey=jBNbu9IWu2Cxs6Ce7iqSdWz3ZPEzNqVGS9N22IsCuKf
	wechat.mp.host=
	
执行命令: mvn clean package

### 启动
打开cmd命令行, 进入项目的根目录，执行
1. java -jar target/weixin-0.0.1-SNAPSHOT.jar
2. ngrok http 8080
3. java -jar target/weixin-0.0.1-SNAPSHOT.jar --wechat.mp.host=http://11484f9a.ngrok.io (第二步返回的url)

### 访问
首页: http://localhost:8080
数据库: http://localhost:8080/h2-console
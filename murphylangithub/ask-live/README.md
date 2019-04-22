# Boron

### 打造一个知识问答，知识分享的平台，通过这个平台，我们的目标是：

1. 悬赏答疑，挑战技术难题；
2. 发布任务；

### 网站模块：

####  会员管理
	1.1 账户充值
	1.2 会员晋升
	1.3 会员权限
	1.4 会员登陆

#### 内容管理
	2.1 发布问题
	2.2 全文检索
	2.3 内容订阅
		2.3.1 生成PDF
 
#### 问题跟踪
	3.1 任务状态跟踪
	3.2 问题

#### 用户反馈
	4.1 评价
	4.2 赞赏
	4.3 打赏

#### 悬赏活动

 
### Q&A：

####  知识是开源的，这与开源精神是否违背

    我们的知识全部开源，小额的悬赏出于如下目的：

    1. 对回答者的奖励
    2. 对问题提出者的尊重，我们会善待每一个问题
    3. 对网站维护者的保障

####  如何应对恶意抢答

    答题者的任何回答会记录下来，有个统计指标：采纳率=有效的发言数/发言的总数；采纳率等同医院的医生级别一样，设置普通和专家类别；
 	相对任务来说，有个指标：合格率=成功的任务/总任务数 	

####  悬赏规则

	用户预先充值，每次发布问题或者任务时，系统会扣除平台管理费（10%）;
	答题或者接任务者，得到悬赏金额时，会先上交所得税 



### 其他：

1. 技术栈：Angular6 + Loopback4 + Swift3 + Kotlin + ELK
2. 数据库设计：MongoDB
3. 支付设计：悬赏者扫码支付后，手机端app监听支付宝，微信的支付到账信息，回调网站api，修改支付状态。
4. 会员：Use the WeChat Open Platform to let your website support login via WeChat.
5. QQ群：14272794


## Fake and JWT server

Run `npm run start-auth` under the `server` folder for a JWT server. Navigate to `http://localhost:3000/`. The app will automatically reload if you change any of the source files. Detail to `server--> README.md`

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running in Docker

docker-compose up -d

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

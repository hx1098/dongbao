### 1.


### 2.token续期的方案
    1. 每天第一次登录时候续期
    2. 每次请求接口,续期token
    3. access_token, refresh_token 中途续期, 时间差1个小时, 如果用户不操作, 就需要重新登录
    4. access_token 新老共存  新老同时有效


### 3.验证码的生成captcha
    1.图形验证码
        1.生成一张图形, 2.校验
        VerifyController.java
        
    2.破解掉

### 4.验证码解决方案
    1.jcaptcha   http://jcaptcha.sourceforge.net/
      localhost:8080/code/generator
      http://localhost:8080/jcapcha/vertify?verifyCode=stme
    2.happy captcha
      localhost:8080/happy/generator
      http://localhost:8080/happy/vertify?verifyCode=stme
    3.easy captcha
     localhost:8080/easy/generator
     localhost:8080/easy/vertify?verifyCode=79u2
    4.多个机器如何校验呢?
     增加redis
    5.kaptcha   baomidou出品
     kaptchaContraller
     http://localhost:8080/kcaptaher/render
    6.slideController 滑块类型的验证码
     破解类库: openCV
     打码赚钱: 顶象, 腾讯天宇, 网易网盾
    总的老说, 验证码是只能做到相对安全, 道高一尺, 魔高一丈, 没有绝对的安全.

### 5.注册登陆
    1.防止注册时候填写一大堆的用户信息, 尽量以交互的形式来进行注册, 抓住用户急切想注册的心理, 
    2.多次登录要惩罚, 使用redis increase, 超过阈值就要有下一步的操作.
    3.多设备的登录识别, header: client_type  pc, android, ios 什么年龄段用的ios, 什么年龄段用的android
    4.第三方登录

### 6.公钥私钥, 
    1.keyStore k![img.png](img.png)eytools java本身自带的有, 可以自己生成证书, 但是一般用来买, 否则提示 不安全, 
    企业一般都是来买证书, 之后浏览器中的地址栏前面变绿. 不然的话所有的客户端都虚假自己安装证书.
    购买之后放在nginx, ssl_certificate中就行了

### 7.数据安全, 接口放篡改
    1.http: 超文本传输协议, 文字图片, 视频音频等, 客户端想服务端发送松溪, 服务端想客户端发送东西
    2.域名解析过程, 浏览器缓存--> 操作系统缓存--->  LDNS(本地域名服务器) --> 根域名服务器--> 国际域名服务器-->具体域名服务器
    3.利用参数加密实现参数的防篡改
    
### 8.  
     
     
    
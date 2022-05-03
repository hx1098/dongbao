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
     
     
     
     
    
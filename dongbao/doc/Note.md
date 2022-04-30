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
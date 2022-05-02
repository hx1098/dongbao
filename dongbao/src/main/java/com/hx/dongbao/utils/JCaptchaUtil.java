package com.hx.dongbao.utils;

import com.mysql.cj.protocol.x.ReusableInputStream;
import com.octo.captcha.CaptchaFactory;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.RandomTextPaster;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.word.FileDictionary;
import com.octo.captcha.component.word.wordgenerator.ComposeDictionaryWordGenerator;
import com.octo.captcha.engine.GenericCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import javafx.scene.text.Font;

import java.awt.*;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/5/2 10:07
 * @description
 * @editUser hx
 * @editTime 2022/5/2 10:07
 * @editDescription  验证码工具
 */
public class JCaptchaUtil {

    private static final ImageCaptchaService service = imageCaptchaService();

    public static ImageCaptchaService getService() {
        return service;
    }

    public static ImageCaptchaService imageCaptchaService() {

        //设置背景
        UniColorBackgroundGenerator backgroundGenerator = new UniColorBackgroundGenerator(100, 50);
        //设置随机的字体颜色
        RandomRangeColorGenerator testColor = new RandomRangeColorGenerator(new int[]{1, 100},new int[]{1, 200},new int[]{1, 255});
        RandomTextPaster randomTextPaster = new RandomTextPaster(4, 5, testColor);

        RandomFontGenerator randomFontGenerator = new RandomFontGenerator(20, 30);

          //组装提醒
        ComposedWordToImage composedWordToImage = new ComposedWordToImage(randomFontGenerator, backgroundGenerator, randomTextPaster);

        ComposeDictionaryWordGenerator composeDictionaryWordGenerator = new ComposeDictionaryWordGenerator(new FileDictionary("toddlist"));
        GimpyFactory gf = new GimpyFactory(composeDictionaryWordGenerator, composedWordToImage);
        GenericCaptchaEngine engine = new GenericCaptchaEngine(new CaptchaFactory[]{gf});

        return new GenericManageableCaptchaService(engine, 20, 2000, 2000);
    }

}

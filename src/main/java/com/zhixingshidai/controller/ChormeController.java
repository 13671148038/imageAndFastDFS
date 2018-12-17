package com.zhixingshidai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChormeController {

    @RequestMapping("getp")
    @ResponseBody
    public String getP(){
        /*ChromeDriver chromeDriver = ChromeDriverUtil.getChromeDriver();
        chromeDriver.get(ChromeDriverUtil.url);
        WebElement su = chromeDriver.findElementById("mainPrice");
        String text = su.getText();*/
        return "说多错多";
    }
    @RequestMapping("getp2")
    @ResponseBody
    public String getP2(){
        return "baidu";
    }
}

package com.zhixingshidai.until;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverUtil {

    private static ChromeDriver chromeDriver = null;

    public static String url = "https://product.suning.com/0000000000/691178468.html?safp=d488778a_46602_0_834cc989bf";

    static {
        System.setProperty("webdriver.chrome.driver", "D:/install/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeDriver = new ChromeDriver(chromeOptions);
        System.out.println("1111111111111111111111111111111111111111111111111111111111111l");
    }

    public static ChromeDriver  getChromeDriver(){
            return chromeDriver;
    }

}

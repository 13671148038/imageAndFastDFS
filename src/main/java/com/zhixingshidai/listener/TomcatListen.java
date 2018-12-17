package com.zhixingshidai.listener;

import com.zhixingshidai.until.ChromeDriverUtil;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TomcatListen implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ChromeDriver chromeDriver = ChromeDriverUtil.getChromeDriver();
        chromeDriver.close();
        System.out.println("执行了关闭!!!!!!!!!!!!!!!!!!!!!!");
    }
}

import com.zhixingshidai.until.HttpClientUtil;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ChromeD {

    private ChromeDriver chromeDriver = null;
    private FirefoxDriver firefoxDriver = null;

    private String url = "https://www.baidu.com";

    @Before
    public void bef(){
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeDriver = new ChromeDriver(chromeOptions);
         firefoxDriver = new FirefoxDriver(firefoxOptions);
    }

    @Test
    public void demo1() throws Exception {

        chromeDriver.get("https://www.baidu.com/");
        String setValueJS = "document.getElementById('kw').value='大城市调查';";

        ((JavascriptExecutor) chromeDriver).executeScript(setValueJS);
    }


    /**
     * 打开浏览器
     */
    @Test
    public void demo2(){
        //打开浏览器
        chromeDriver.get(url);
        //获取title
        String currentUrl = chromeDriver.getCurrentUrl();
        System.out.println(currentUrl);
        String title = chromeDriver.getTitle();
        System.out.println(title);
        WebElement su = chromeDriver.findElementById("su");
        su.click();
    }

    @Test
    public void demo4(){
      /*  Long s = System.currentTimeMillis();
        demo3();
        demo3();
        demo3();
        demo3();
        demo3();
        Long e = System.currentTimeMillis();
        System.out.println(e-s);*/
    }

    /**
     * 输入内容并点击
     */
    @Test
    public void demo3(){
        //打开浏览器
        firefoxDriver.get("https://product.suning.com/0000000000/691178468.html?safp=d488778a_46602_0_834cc989bf");
        //穿件制定的脚本
       // String js = "document.getElementById('mainPrice');";
        //执行次js代码
        WebElement su = firefoxDriver.findElementById("mainPrice");
        String text = su.getText();
        System.out.println(text);
      /*  //获取百度一下按钮
        WebElement su = chromeDriver.findElementById("su");
        //店家按钮
        su.click();
        Thread.sleep(3000);*/
        //获取的是页面字符串形式
        //String pageSource = chromeDriver.getPageSource();
        //Capabilities capabilities = chromeDriver.getCapabilities();
        //chromeDriver.executeScript("location.href='www.2ge.cn'");
    }

    @Test
    public void Demo4(){
        String s = HttpClientUtil.sendGet("http://www.xiji.com/product-89716.html", "");
        System.out.println(s);
    }


}

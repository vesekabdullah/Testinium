package testiniumUITesting.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {


    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<WebDriver>();
    /*
     * We use private and static modifiers so that no one can create a driver class object,
     * instead everyone should call the static getter method.
     */

    private Driver() {
    }



    public synchronized static WebDriver getDriver() {

        if (driverPool.get() == null) {

            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Wrong browser name !");
            }
        }
        return driverPool.get();
    }


    public static void closeDriver() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

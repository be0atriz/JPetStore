package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigBrowser {
	
	public static WebDriver driver;
	 
	//public static WebDriver iniciaBrowser() {
	public static WebDriver iniciaBrowser(String browser) {
	
		
	switch (browser.toLowerCase()) {
    case "chrome":
        // Configuring the path for ChromeDriver (Windows)
     
    	WebDriverManager.chromedriver().setup();
   
    	driver = new ChromeDriver();
        break;
    case "firefox":
        // Configuring the path for GeckoDriver (Windows)
        
        WebDriverManager.firefoxdriver().setup();
        
        driver = new FirefoxDriver();
        break;
    case "edge":
        // Configuring the path for EdgeDriver (Windows)
        
    	WebDriverManager.edgedriver().setup();
    	
    	driver = new EdgeDriver();
        break;
   
    default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);
	}
	
	return driver;
	
	}	
	
			
		public static void CloseBrowser(WebDriver driver) {
			if (driver != null) {
				driver.quit();					
				driver = null;
			
		}
	}
}



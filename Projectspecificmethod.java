package salesforce;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Projectspecificmethod {
public ChromeOptions cp;
public RemoteWebDriver  driver; 

	@Parameters({"url","username","password","browser"})	
@BeforeMethod
public  void precondition(String url,String username,String password,String browser){
		cp = new ChromeOptions();
		cp.addArguments("--disable-notifications");
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(cp);
		}else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			}
		
			 
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(url);
				WebElement name = driver.findElement(By.xpath("//input[@id='username']"));
				name.sendKeys(username);
				WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
				pass.sendKeys(password);
				WebElement log = driver.findElement(By.xpath("//input[@id='Login']"));
				log.click();			
}
			



@AfterMethod
public void postcondition() {
	driver.close();
}}
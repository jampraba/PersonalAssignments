package ecommercewebsitetesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
public class Snapdeal {

	public static void main(String[] args) throws InterruptedException {
		 
		ChromeDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.navigate().to("https://www.snapdeal.com/");
	
		// Go to "Men's Fashion".
		 Actions opt = new Actions(driver);
		 WebElement rc = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		opt.moveToElement(rc).perform();

		//Go to "Sports Shoes". 
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
// Get the count of sports shoes.
WebElement ct = driver.findElement(By.xpath("//span[@class=\"category-name category-count\"]"));
System.out.println("count of shoes :"+ct.getText());
//Click on "Training Shoes".
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
//Sort the products by "Low to High". 
		WebElement lh = driver.findElement(By.xpath("//i[@class=\"sd-icon sd-icon-expand-arrow sort-arrow\"]"));
		lh.click();
		WebElement li = driver.findElement(By.xpath("//li[@class=\"search-li\"]"));
		opt.moveToElement(li);
		li.click();	
//Check if the displayed items are sorted correctly. 
		
		
//Select any price range ex:(500-700). 
WebElement from = driver.findElement(By.xpath("//input[@name=\"fromVal\"]"));
from.sendKeys("500");
from.clear();

WebElement to = driver.findElement(By.xpath("//input[@name=\"toVal\"]"));
to.sendKeys("700");
to.clear();

driver.findElement(By.xpath("//div[@class=\"price-go-arrow btn btn-line btn-theme-secondary\"]"));
Thread.sleep(3000);

// Filter by any colour.
driver.findElement(By.xpath("(//div[@class=\"filters-list sdCheckbox\"])[1]")).click();



//Verify all the applied filters. 

		
		
//Mouse hover on the first resulting "Training Shoes". 
	
//Click the "Quick View" button. 
		
		
//Print the cost and the discount percentage. 

		
//Take a snapshot of the shoes. 

//Close the current window. 
//driver.close();
		
//Close the main window.
//driver.quit();
	}

}

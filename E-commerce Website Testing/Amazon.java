package ecommercewebsitetesting;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
			ChromeDriver driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.navigate().to("https://www.amazon.in/");
	
		Thread.sleep(500);
// Search for "oneplus 9 pro". 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro" , Keys.ENTER );
// Get the price of the first product. 
	System.out.println(driver.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[2]")).getText());
		
// Print the number of customer ratings for the first displayed product. 
	WebElement element = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
	System.out.println(element.getText());
		

	// click the first text link of the first image. 
	driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
	// another tab open so we use window handles 
	Set<String> allWindowHandles = driver.getWindowHandles();
	ArrayList<String> tabs = new ArrayList<>( allWindowHandles);
	//first new tab
	driver.switchTo().window(tabs.get(1));
	//title of 1st tab
	System.out.println("Title of first tab: "+ driver.getTitle());

// Take a screenshot of the product displayed. 
	Thread.sleep(5000);
	WebElement screens = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
	File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	File df=new File("./Screens/img.png");
		FileUtils.copyFile(screenshotAs, df);
		System.out.println("screen saved: "+ df.getAbsolutePath());
		Thread.sleep(900);
		
// Click the 'Add to Cart' button.
	WebElement ac = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		Actions cart  = new Actions(driver);
		cart.scrollToElement(ac).perform();
		Thread.sleep(3000);
		ac.click();
		
	
// Get the cart subtotal and verify if it is correct. 
String total = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']")).getText();
System.out.println("Subtotal : "+ total);

// Close the browser.+
	//	driver.quit();
	}

}

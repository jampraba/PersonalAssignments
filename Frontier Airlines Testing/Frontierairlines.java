package frontierairlinestesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Frontierairlines {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://booking-qa2.flyfrontier.com/");
		Thread.sleep(3000);
		//From is charlotte(clt)
driver.findElement(By.id("fromInput")).sendKeys("Charlotte, NC (CLT)");

        //To is denver
driver.findElement(By.id("toInput")).sendKeys("Denver, CO (DEN)");


//frame double click because of search of orgin
WebElement  dc= driver.findElement(By.id("searchForm"));
Actions opt =new Actions(driver);
opt.doubleClick(dc).perform();
Thread.sleep(3000);

//one way trip
WebElement cl = driver.findElement(By.id("oneWayTrip"));
Actions opt2 = new Actions(driver);
opt2.click(cl).perform();
Thread.sleep(3000);

//date confirm
driver.findElement(By.id("search_from_date")).sendKeys("12/5/2024");
Thread.sleep(2000);

//search by
WebElement cl2 = driver.findElement(By.id("searchDollars"));
Actions opt3 =new Actions(driver);
opt3.click(cl2).perform();
Thread.sleep(3000);

//passengers
WebElement element = driver.findElement(By.id("adtPaxCount"));
Select options = new Select(element);
element.click();
options.selectByVisibleText("3");
Thread.sleep(5000);

//childrens
WebElement element2 = driver.findElement(By.id("chdPaxCount2"));
Select options2 = new Select(element2);
element2.click();
options2.selectByVisibleText("1");
Thread.sleep(2000);



//search
WebElement sb = driver.findElement(By.id("searchButton"));
Actions opt4 = new Actions(driver);
opt4.click(sb).perform();
Thread.sleep(5000);
	}

}

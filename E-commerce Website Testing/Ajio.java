package ecommercewebsitetesting;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.ajio.com");
		//In the search box, type as "bags" and press enter
driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags");
driver.findElement(By.xpath("//span[@class='ic-search']")).click();
Thread.sleep(3000);
//To the left of the screen under "Gender" click on "Men"
driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Men']")).click();
Thread.sleep(2000);
// Under "Category" click "Fashion Bags"
driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]")).click();
Thread.sleep(900);
//print the count of items found
WebElement count = driver.findElement(By.xpath("//div[@class='length']"));
System.out.println(count.getText());
// Get the list of brand of the products displayed in the page and print the
// list.
 List<WebElement> brand = driver.findElements(By.xpath("//div[@class='brand']"));
System.out.println(brand.size());
Thread.sleep(200);
for (int i = 0; i < brand.size(); i++) {
	System.out.println("Brand names: " + brand.get(i).getText());
}
// Get the list of names of the bags and print 
List<WebElement> bags = driver.findElements(By.xpath("//div[@class='nameCls']"));
System.out.println(bags.size());
Thread.sleep(200);
for (int i = 0; i < bags.size(); i++) {
System.out.println("Bag names : " + bags.get(i).getText());

	}
}
}

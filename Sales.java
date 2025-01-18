package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class Sales extends   Projectspecificmethod {
	  @DataProvider(name = "jamudata")
	public String[][] jamset() {
		String[][] jp= new String[2][3];
		jp[0][0]="jam";
		jp[0][1]="Testleaf";
		jp[0][2]="Salesforce";
		
		jp[1][0]="praba";
		jp[1][1]="Testleaf";
		jp[1][2]="sales";
		
		return jp;
	}

@Test(dataProvider = "jamudata")
	public void salesforce(String Name,String Comname,String Descript) throws InterruptedException {
	//- Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//- Click View All 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		//and click Legal Entities from App Launcher
		WebElement legal = driver.findElement(By.xpath("//p[contains(text(),'Legal E')]"));
		Actions action = new Actions(driver);
		action.scrollToElement(legal).perform();
		legal.click();
		Thread.sleep(2000);
		
		//- Click on the Dropdown icon in the legal Entities tab

		WebElement element = driver.findElement(By.xpath("(//span[text()='Legal Entities']//following::a)[1]"));
		element.click();
		//Click on New Legal Entity
		WebElement element2 = driver.findElement(By.xpath("//one-app-nav-bar-menu-item[@class='slds-dropdown__item'][1]"));
		element2.click();
		//- Enter Name as 'Salesforce Automation by *Your Name*'
		WebElement name = driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
		name.sendKeys(Name);
		Thread.sleep(3000);
	//Enter the Company name as'TestLeaf'.
	WebElement company = driver.findElement(By.xpath("//input[@name='CompanyName']"));
	company.sendKeys(Comname);
	//Enter Description as 'Salesforces'.
	WebElement des = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
	des.sendKeys(Descript);
	// Select Status as 'Active'
	WebElement status = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", status);

	status.click();
	driver.findElement(By.xpath("(//span[text()='Active'])[1]")).click();
	Thread.sleep(3000);
	
	
	// Click on Save
	WebElement element3 = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	element3.click();
	// Verify the Alert message (Complete this field) displayed for Name
	System.out.println("Alert Message : " + element3.getText());




}}
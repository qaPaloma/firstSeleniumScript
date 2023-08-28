package AppTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	ChromeDriver driver;	

	@Test
	public void invokeBrowser(){
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium Testing\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/");
	
        String title = driver.getTitle();
		String expectedTitle = "Guru99 Bank Home Page";		
		String actualTitle = driver.getTitle();		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	//Scenario: User is able to login
	
	@Test (priority = 1)
	public void verifyLogin () {
		
		WebElement userId = driver.findElement(By.name("uid"));		
		WebElement userPassword = driver.findElement(By.name("password"));		
		WebElement loginButton = driver.findElement(By.name("btnLogin"));		
		userId.sendKeys("mngr524817");		
		userPassword.sendKeys("vegYpyg");		
		loginButton.click();
		
	}
	
	//Scenario: User is able to create a new customer on the system
	
	@Test (priority = 2)
	public void addCustomer () {
		
		WebElement addCustomerLink = driver.findElement(By.xpath("//a[text()='New Customer']"));
		addCustomerLink.click();
		
		driver.findElement(By.name("name")).sendKeys("Alicia Ricker IV");				
		driver.findElement(By.xpath("//input[@value='f']")).click();		
		driver.findElement(By.name("dob")).sendKeys("04/06/1967");
		driver.findElement(By.name("addr")).sendKeys("9465 Nash Street");
		driver.findElement(By.name("city")).sendKeys("Chicago");
		driver.findElement(By.name("state")).sendKeys("IL");
		driver.findElement(By.name("pinno")).sendKeys("790490");
		driver.findElement(By.name("telephoneno")).sendKeys("3121828199");
		driver.findElement(By.name("emailid")).sendKeys("Aliii@teleworm.us");
		driver.findElement(By.name("password")).sendKeys("qua5eiMooh");
		driver.findElement(By.name("sub")).click();
		
	}
	
	//Show the customer ID on the console

	@Test (priority = 3)
	public void GetCustomerId() {
		String customerID = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
		
		System.out.println("Customer ID - "+ customerID);
	}
	
}

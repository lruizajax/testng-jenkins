package pe.edu.galaxy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Shopping {
  

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver",
				"/Users/lruiz/eclipse-workspace/Selenium_Jenkins/src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://konta-srl.odoo.com/shop");

	}

	@Test(priority = 1)
	public void getLisProducts() throws InterruptedException {

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"products_grid\"]/div/table/tbody/tr/td"));

		System.out.println("Number of Productos:" + elements.size());
		
		AssertJUnit.assertEquals(3, elements.size());

	}
	
	@Test(priority = 2)
	public void addFirstItem() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"products_grid\"]/div/table/tbody/tr/td[1]/div/form/div[1]/a")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("add_to_cart")).click();
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void addMoreItem() throws InterruptedException {

		//back to
		driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div/div[2]/div/div/a[1]")).click();
		
		Thread.sleep(2000);
		
		//choose other product
		driver.findElement(By.xpath("//*[@id=\"products_grid\"]/div/table/tbody/tr/td[3]/div/form/div[1]/a")).click();
		
		Thread.sleep(1000);
		//add one more item
		driver.findElement(By.xpath("//*[@id=\"product_details\"]/form/div/div[2]/div[2]/a")).click();
				
		Thread.sleep(3000);
		
		//driver.findElement(By.id("add_to_cart")).click();
		driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]")).click();
		
		Thread.sleep(4000);
		//pay now
		driver.findElement(By.xpath("//*[@id=\"o_cart_summary\"]/div[1]/div/div/a")).click();
		
	}
	
	@Test(priority = 4)
	public void shippingAddress() throws InterruptedException {

		driver.findElement(By.name("name")).sendKeys("Pedro Perico");
		
		driver.findElement(By.name("email")).sendKeys("pperico@gmail.com");
		
		driver.findElement(By.name("phone")).sendKeys("+51 962 338 166");
		
		driver.findElement(By.name("company_name")).sendKeys("Konta S.R.L");
		
		driver.findElement(By.name("street")).sendKeys("Av. Lima 123");
		
		driver.findElement(By.name("street2")).sendKeys("San Chugur");
		
		driver.findElement(By.name("city")).sendKeys("Cajamarca");
		
		WebElement  state = driver.findElement(By.name("state_id"));
				state.sendKeys("Cajamarca");
		
		driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/div[2]/div/form/div[2]/a[2]/span")).click();
				
		Thread.sleep(2000);
		
		driver.findElement(By.id("o_payment_form_pay")).click();
		
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 5)
	public void completeOrder() throws InterruptedException {
		
		Thread.sleep(4000);
		
		AssertJUnit.assertEquals("Tienda - Confirmado | KONTA S.R.L", driver.getTitle());

	}
	
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.quit();

	}
	
}

package pe.edu.galaxy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Invoice {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver",
				"/Users/lruiz/eclipse-workspace/Selenium_Jenkins/src/test/resources/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://mypefact.com");

	}

	@Test(priority = 1)
	public void goToSingIn() throws InterruptedException {

		driver.findElement(By.id("button_login")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void setCredential() throws InterruptedException {

		driver.findElement(By.name("email")).sendKeys("lruizajax@gmail.com");
		driver.findElement(By.name("password")).sendKeys("L1ma2020");
		driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).submit();
	
		Thread.sleep(3000);
		
        AssertJUnit.assertEquals("Sistema de Gestión Mypefact", driver.findElement(By.className("navbar-form-custom")).getText());
        
	}
	
	@Test(priority = 3)
	public void salePekosita() throws InterruptedException {

		WebElement item = driver.findElement(By.name("item"));
				item.sendKeys("sele");
				item.sendKeys(Keys.ENTER);
		
				
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#page-wrapper > section > div > div > div > div > section > div.ibox.collapsed.invoice_details.m-l.m-r.m-b > div.ibox-title > div > a")).click();
		
		driver.findElement(By.id("expires_at")).sendKeys("14/09/2020");
		driver.findElement(By.id("expires_at")).sendKeys(Keys.ESCAPE);
		
		driver.findElement(By.id("obser")).sendKeys("Selenium + TestNG with Jenkins");
		
		driver.findElement(By.id("paymentCondition")).sendKeys("Efectivo");
				
		driver.findElement(By.id("btn_next")).click();
		
		driver.switchTo().activeElement();
		
		driver.findElement(By.xpath("//*[@id=\"modal_confirm\"]/div/div/div[3]/button[2]")).click();
		
		driver.switchTo().activeElement();
		
		Thread.sleep(3000);
		
		String expected = "SUNAT: El dato ingresado como unidad de medida no corresponde al valor esperado - Detalle: xxx.xxx.xxx value='ticket: 1600110682097 error: : 2936: Valor no se encuentra en el catalogo: 03 (nodo: \"cbc:InvoicedQuantity/unitCode\" valor: \"UND\")'";
		
		String actual = driver.findElement(By.className("toast-message")).getText();
		
		AssertJUnit.assertEquals(expected, actual);
        
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.quit();

	}

}

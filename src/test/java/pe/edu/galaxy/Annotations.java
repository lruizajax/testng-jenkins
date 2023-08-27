package pe.edu.galaxy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
  
	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {
	System.out.println("@BeforeSuite");
	}

	@BeforeClass(alwaysRun = true)
	public static void beforeClass() {
	System.out.println("@BeforeClass");
	}

	@BeforeTest(alwaysRun = true)
	public static void beforeTest() {
	System.out.println("@BeforeTest");
	}

	@BeforeMethod(alwaysRun = true)
	public static void beforeMethod() {
	System.out.println("@BeforeMethod");
	}

	@AfterSuite(alwaysRun = true)
	public static void afterSuite() {
	System.out.println("@AfterSuite");
	}

	@AfterClass(alwaysRun = true)
	public static void afterClass() {
	System.out.println("@AfterClass");
	}

	@AfterTest(alwaysRun = true)
	public static void afterTest() {
	System.out.println("@AfterTest");
	}

	@AfterMethod(alwaysRun = true)
	public static void afterMethod() {
	System.out.println("@AfterMethod");
	}

	@Test(priority = 1)
	public void test() {
	System.out.println("Test");
	}

	@Test(priority = 2)
	public void test2() {
	System.out.println("Test2");
	}

}

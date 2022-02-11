package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;


public class LoginTest extends BaseClass {
	
	@Test
	public void testLogin() {
		MobileElement element1 = (MobileElement) driver.findElement(By.id("etEmail"));
		element1.sendKeys("abc@abc.com");
		MobileElement element2 = (MobileElement) driver.findElement(By.id("etPassword"));
		element2.sendKeys("123456");
		MobileElement element3 = (MobileElement) driver.findElement(By.id("btnLogin"));
		element3.click();	
	}
	
	@Test
	public void testRegistrationButton() {
		MobileElement element1 = (MobileElement) driver.findElement(By.id("tvDontHaveAcc"));
		element1.click();

		
	}
	
	@Test
	public void testPhoneLoginButton() {
		MobileElement element1 = (MobileElement) driver.findElement(By.id("btnPhoneLogin"));
		element1.click();
	}
	
}

package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class RegistrationTest extends BaseClass {

	
	@Override
	@BeforeMethod
	public void onCreate() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86_arm");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Git\\Breeze\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickRegister();
		
	}
	
	
	
	
	
	private void clickRegister() {
		MobileElement registerText = (MobileElement) driver.findElement(By.id("tvDontHaveAcc"));
		registerText.click();
	}


	@Test
	public void testSendToLogin() {
		MobileElement backToLoginText = (MobileElement) driver.findElement(By.id("tvAlreadyHaveAnAccount"));
		backToLoginText.click();
	}
	
	
	@Test
	public void testRegister() {
		MobileElement element1 = (MobileElement) driver.findElement(By.id("etEmail"));
		element1.sendKeys("abcd@abcd.com");
		MobileElement element2 = (MobileElement) driver.findElement(By.id("etPassword"));
		element2.sendKeys("123456");
		MobileElement element3 = (MobileElement) driver.findElement(By.id("btnRegister"));
		element3.click();
	}


	
}

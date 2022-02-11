package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MainActivityTest extends BaseClass {
	
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
		login();

	}
	
	public void login() {
		MobileElement element1 = (MobileElement) driver.findElement(By.id("etEmail"));
		element1.sendKeys("abc@abc.com");
		MobileElement element2 = (MobileElement) driver.findElement(By.id("etPassword"));
		element2.sendKeys("123456");
		MobileElement element3 = (MobileElement) driver.findElement(By.id("btnLogin"));
		element3.click();
	}
	
	
	
	@Test
	public void testAddGroupButton() {
		
		synchronized (driver) {
			swipeScreen(Direction.LEFT);
			System.out.println(driver.getPageSource());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
			
			MobileElement createGroupBtn = (MobileElement) driver.findElement(By.id("ibtnCreateGroup"));
			createGroupBtn.click();

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		
		

	}
	
	
	public void swipeScreen(Direction dir) {
	    System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

	    // Animation default time:
	    //  - Android: 300 ms
	    //  - iOS: 200 ms
	    // final value depends on your app and could be greater
	    final int ANIMATION_TIME = 200; // ms

	    final int PRESS_TIME = 200; // ms

	    try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	    
	    int edgeBorder = 10; // better avoid edges
	    PointOption pointOptionStart, pointOptionEnd;

	    // init screen variables
	    Dimension dims = driver.manage().window().getSize();

	    // init start point = center of screen
	    pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

	    switch (dir) {
	        case DOWN: // center of footer
	            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
	            break;
	        case UP: // center of header
	            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
	            break;
	        case LEFT: // center of left side
	            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
	            break;
	        case RIGHT: // center of right side
	            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
	            break;
	        default:
	            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
	    }

	    // execute swipe using TouchAction
	    try {
	        new TouchAction(driver)
	                .press(pointOptionStart)
	                // a bit more reliable when we add small wait
	                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
	                .moveTo(pointOptionEnd)
	                .release().perform();
	    } catch (Exception e) {
	        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
	        return;
	    }

	    // always allow swipe action to complete
	    try {
	        Thread.sleep(ANIMATION_TIME);
	    } catch (InterruptedException e) {
	        // ignore
	    }
	}

	public enum Direction {
	    UP,
	    DOWN,
	    LEFT,
	    RIGHT;
	}
	
	
}





package student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestPurpose extends Pilot {

	AndroidDriver<AndroidElement> driver;

	public TestPurpose() throws MalformedURLException {
		// TODO Auto-generated constructor stub
		this.runFlow();
	}

	public void runFlow() throws MalformedURLException {
		driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.EditText[@text='Enter school code']")
				.sendKeys(EnvConfig.Institutecode);
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='Proceed']").click();

// Navigate welcome Screen
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='GET STARTED']").click();

// Enabled Mobile Permissions
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='WHILE USING THE APP']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='ALLOW']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='ALLOW']").click();

		driver.findElementByXPath("//" + EnvConfig.button + "[@text='LOGIN']").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(EnvConfig.username);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys(EnvConfig.password);
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='Login']").click();

		// Check for Already Logged in
		if (driver.findElements(By.xpath("//" + EnvConfig.button + "[@text='Continue']")).size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.button + "[@text='Continue']").click();
			System.out.println("Continue--FOUND");
		} else {
			System.out.println("Continue--NOT FOUND!!");
		}

		
		}

	}


package student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Regression extends Pilot {

	public Regression() throws MalformedURLException {
		// TODO Auto-generated constructor stub
		this.runFlow();
	}

	public void runFlow() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//		ExtentTest test = extent.createTest("Phase One", "Student");
//		test.log(Status.INFO, "Phase One Started");

		// Check for institute code
		if (driver.findElements(By.xpath("//android.widget.EditText[@text='Enter school code']")).size() > 0) {
			driver.findElementByXPath("//android.widget.EditText[@text='Enter school code']").sendKeys("demodemo");
			driver.findElementByXPath("//" + EnvConfig.button + "[@text='Proceed']").click();
			System.out.println("Institute Code Pop-up--FOUND");
		} else {
			System.out.println("Institute Code Pop-up--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@resource-id='android:id/message']")).size() > 0) {
			System.out.println("School Code is Wrong validation--FOUND");
		} else {
			System.out.println("School Code is Wrong validation--NOT FOUND!!");
		}
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='EXIT']").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='LIL@Home']").click();
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

		// Start Login for Student
		if (driver.findElements(By.xpath("//" + EnvConfig.button + "[@resource-id='" + EnvConfig.baseAppPackage
				+ ":id/buttonLoginForgetPassword']")).size() > 0) {
			System.out.println("Generate Password--FOUND");
		} else {
			System.out.println("Generate Password--NOT FOUND!!");
		}
		if (driver.findElementsByXPath(
				"//" + EnvConfig.button + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/buttonResetInstitute']")
				.size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.button + "[@resource-id='" + EnvConfig.baseAppPackage
					+ ":id/buttonResetInstitute']").click();
			System.out.println("Reset Institute--FOUND");
		} else {
			System.out.println("Reset Institute--NOT FOUND!!");
		}
		driver.findElementByXPath("//android.widget.EditText[@text='Enter school code']")
				.sendKeys(EnvConfig.Institutecode);
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='Proceed']").click();
		if (driver.findElements(By.xpath("//" + EnvConfig.button + "[@text='NEXT']")).size() > 0) {
			System.out.println("Welcome Screen--FOUND");
		} else {
			System.out.println("Welcome Screen--NOT FOUND!!");
		}
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='GET STARTED']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='LOGIN']").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("demodemo");
		driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("demodemo");
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='Login']").click();
		if (driver.findElements(By.xpath("//android.view.View[@resource-id='claimVerificationServerError']"))
				.size() > 0) {
			System.out.println("User Not Exists validation--FOUND");
		} else {
			System.out.println("User Not Exists validation--NOT FOUND!!");
		}
		driver.navigate().back();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='LOGIN']").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("demodemo");
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='Login']").click();
		if (driver.findElements(By.xpath("//android.view.View[@text='This information is required.']")).size() > 0) {
			System.out.println("Password required validation--FOUND");
		} else {
			System.out.println("Password required validation--NOT FOUND!!");
		}
		driver.navigate().back();
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

		// Check for Student Dash-board
		if (driver.findElements(By.xpath(
				"//android.widget.FrameLayout[@resource-id='" + EnvConfig.baseAppPackage + ":id/nav_dashboard']"))
				.size() > 0) {
			System.out.println("Dashboard--FOUND");
		} else {
			System.out.println("Dashboard--NOT FOUND!!");
		}

		// Check for Greeting
		if (driver.findElementByAndroidUIAutomator("text(\"Hey, \")").isDisplayed()) {
			System.out.println("Greetings--FOUND");
		} else {
			System.out.println("Greetings--NOT FOUND!!");
		}

		// Check for Logged In user name
		if (driver.findElements(By
				.xpath("//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/textViewUserName']"))
				.size() > 0) {
			System.out.println("Name--FOUND");
		} else {
			System.out.println("Name--NOT FOUND!!");
		}

		// Quick Recap

		// Check for Student Recap Heading
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@package='" + EnvConfig.baseAppPackage + "']"))
				.size() > 0) {
			System.out.println("Recap--FOUND");
		} else {
			System.out.println("Recap--NOT FOUND!!");
		}

		// Check for Student Recap Content

		if (driver.findElements(By.xpath("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
				+ EnvConfig.baseAppPackage + ":id/rootView']")).size() > 0) {
			driver.findElementByXPath("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='"
					+ EnvConfig.baseAppPackage + ":id/rootView']").click();
			if (driver.findElementsByClassName("android.view.View").size() > 0) {
				driver.navigate().back();
			} else {
				if (driver.findElements(By.xpath(
						"//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/textViewTitle']"))
						.size() > 0) {
					System.out.println("Recap Title--FOUND");
				} else {
					System.out.println("Recap Title--NOT FOUND!!");
				}
				if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage
						+ ":id/textViewDescription']")).size() > 0) {
					System.out.println("Recap Description--FOUND");
					driver.findElementByXPath("//" + EnvConfig.view + "[@text='Introduction']").click();
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.navigate().back();

				} else {
					System.out.println("Recap Description--NOT FOUND!!");
				}

			}
			System.out.println("Lesson Plan--FOUND");
		} else {
			System.out.println("Lesson Plan--NOT FOUND!!");
		}

		// Check for Assignment heading
		if (driver.findElementByAndroidUIAutomator("text(\"It's time for assignment now.\")").isDisplayed()) {
			System.out.println("Assignment--FOUND");
		} else {
			System.out.println("Assignment--NOT FOUND!!");
		}

		// Check for Subject Listing
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Subjects']")).size() > 0) {
			System.out.println("Subjects--FOUND");
		} else {
			System.out.println("Subjects--NOT FOUND!!");
		}

		// Check for Analytics button
		if (driver.findElements(By.xpath(
				"//android.widget.ImageButton[@resource-id='" + EnvConfig.baseAppPackage + ":id/buttonAnalyticsView']"))
				.size() > 0) {
			System.out.println("Analytics View--FOUND");
		} else {
			System.out.println("Analytics View--NOT FOUND!!");
		}

		if (driver.findElements(By.xpath(
				"//android.widget.FrameLayout[@resource-id='" + EnvConfig.baseAppPackage + ":id/nav_online_class']"))
				.size() > 0) {
			System.out.println("Online Class--FOUND");
		} else {
			System.out.println("Online Class--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id='" + EnvConfig.baseAppPackage
				+ ":id/navAcademicPortfolio']")).size() > 0) {
			System.out.println("Portfolio--FOUND");
		} else {
			System.out.println("Portfolio--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath(
				"//android.widget.ImageButton[@resource-id='" + EnvConfig.baseAppPackage + ":id/imageViewUser']"))
				.size() > 0) {
			System.out.println("Profile--FOUND");
		} else {
			System.out.println("Profile--NOT FOUND!!");
		}

		// Check for Assignment
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='New']").click();
		driver.findElementByClassName("android.widget.ImageButton").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='Due Soon']").click();
		driver.findElementByClassName("android.widget.ImageButton").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='Overdue']").click();
		driver.findElementByXPath(
				"//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/action_filter']").click();

		driver.findElementByXPath(
				"//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage + ":id/imageViewDone']").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='Classwork']").click();
		driver.findElementByXPath(
				"//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/action_filter']").click();

		driver.findElementByXPath(
				"//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage + ":id/imageViewDone']").click();
		driver.findElementById("" + EnvConfig.baseAppPackage + ":id/action_done").click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByXPath(
				"//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/action_filter']").click();

		driver.findElementByXPath(
				"//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage + ":id/imageViewDone']").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='Classwork']").click();
		driver.findElementById("" + EnvConfig.baseAppPackage + ":id/action_filter").click();

		driver.findElementByXPath(
				"//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage + ":id/imageViewDone']").click();
		driver.findElementByClassName("android.widget.ImageButton").click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().back();

		// Analytics

		driver.findElementByXPath(
				"//android.widget.ImageButton[@resource-id='" + EnvConfig.baseAppPackage + ":id/buttonAnalyticsView']")
				.click();
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Overall']")).size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.view + "[@text='Overall']").click();
			System.out.println("Overall--FOUND");
		} else {
			System.out.println("Overall--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Progress']")).size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.view + "[@text='Progress']").click();
			System.out.println("Progress--FOUND");
		} else {
			System.out.println("Progress--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Efforts']")).size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.view + "[@text='Efforts']").click();
			System.out.println("Efforts--FOUND");
		} else {
			System.out.println("Efforts--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Excellence']")).size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.view + "[@text='Excellence']").click();
			System.out.println("Excellence--FOUND");
		} else {
			System.out.println("Excellence--NOT FOUND!!");
		}
		driver.findElementByClassName("android.widget.ImageButton").click();

		// Subjects

		driver.findElementByXPath("//" + EnvConfig.view + "[@text='" + EnvConfig.Subject + "']").click();
		if (driver.findElements(By.xpath(
				"//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/textViewHeaderTitle']"))
				.size() > 0) {
			System.out.println("Topic Name--FOUND");
		} else {
			System.out.println("Topic Name--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Learn']")).size() > 0) {
			System.out.println("Learn--FOUND");
		} else {
			System.out.println("Learn--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Reinforce']")).size() > 0) {
			System.out.println("Reinforce--FOUND");
		} else {
			System.out.println("Reinforce--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Practice']")).size() > 0) {
			System.out.println("Practice--FOUND");
		} else {
			System.out.println("Practice--NOT FOUND!!");
		}

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ EnvConfig.LRPAXEND + "\").instance(0))");

		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Apply']")).size() > 0) {
			System.out.println("Apply--FOUND");
		} else {
			System.out.println("Apply--Not FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Xperience']")).size() > 0) {
			System.out.println("Xperience--FOUND");
		} else {
			System.out.println("Xperience--Not FOUND!!");
		}

		driver.findElementByXPath(
				"//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage + ":id/buttonFilterLRPA']")
				.click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='IN PROGRESS']").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='YET TO START']").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='COMPLETED']").click();
		driver.findElementByXPath(
				"//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage + ":id/buttonCloseDialog']")
				.click();

		driver.findElementByXPath("//" + EnvConfig.view + "[@text='Portfolio']").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='Homework']").click();
		driver.navigate().back();

		// Co-Scholastic

		if (driver.findElements(By.xpath(
				"//android.widget.FrameLayout[@resource-id='" + EnvConfig.baseAppPackage + ":id/nav_dashboard']"))
				.size() > 0) {
			System.out.println("Scrolling--FOUND");
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Co-scholastic\").instance(0))");
		} else {
			System.out.println("Scrolling--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Co-scholastic']")).size() > 0) {
			System.out.println("Co-scholastic--FOUND");
			driver.findElementById("" + EnvConfig.baseAppPackage + ":id/imageViewThumbnail").click();
			if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Art and Craft']")).size() > 0) {
				System.out.println("Art and Craft(Co-scholastic)--FOUND");
				driver.findElementByXPath("//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage
						+ ":id/imageViewThumbnail']").click();
				driver.navigate().back();
			} else {
				System.out.println("Art and Craft(Co-scholastic)--NOT FOUND!!");
			}

			if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Music']")).size() > 0) {
				driver.findElementByXPath("//" + EnvConfig.view + "[@text='Music']").click();
				driver.findElementById("" + EnvConfig.baseAppPackage + ":id/imageViewThumbnail").click();
				driver.navigate().back();
				System.out.println("Music(Co-scholastic)--FOUND");
			} else {
				System.out.println("Music(Co-scholastic)--NOT FOUND!!");
			}

			if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Dance']")).size() > 0) {
				driver.findElementByXPath("//" + EnvConfig.view + "[@text='Dance']").click();
				System.out.println("Dance(Co-scholastic)--FOUND");
				driver.findElementById("" + EnvConfig.baseAppPackage + ":id/imageViewThumbnail").click();
				driver.navigate().back();
			} else {
				System.out.println("Dance(Co-scholastic)--NOT FOUND!!");
			}

			if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Yoga']")).size() > 0) {
				driver.findElementByXPath("//" + EnvConfig.view + "[@text='Yoga']").click();
				System.out.println("Yoga(Co-scholastic)--FOUND");
				driver.findElementById("" + EnvConfig.baseAppPackage + ":id/imageViewThumbnail").click();
				driver.navigate().back();
				driver.findElementByClassName("android.widget.ImageView").click();
			} else {
				System.out.println("Yoga(Co-scholastic)--NOT FOUND!!");
			}
		} else {
			System.out.println("Co-scholastic--NOT FOUND!!");
		}
		driver.navigate().back();
//      driver.findElementByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Video for the day\").instance(0))");

		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Video for the day']")).size() > 0) {
			System.out.println("Video for the day--FOUND");
			driver.findElementById("" + EnvConfig.baseAppPackage + ":id/imageViewVideoPlayIcon").click();
			driver.navigate().back();
		} else {
			System.out.println("Video for the day--NOT FOUND!!");
		}

		driver.findElementById("" + EnvConfig.baseAppPackage + ":id/nav_online_class").click();
		driver.findElementById("" + EnvConfig.baseAppPackage + ":id/navAcademicPortfolio").click();
		driver.findElementByXPath(
				"//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage + ":id/imageViewCancel']")
				.click();
		driver.findElementByClassName("android.widget.ImageButton").click();
		driver.findElementById("" + EnvConfig.baseAppPackage + ":id/nav_dashboard").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().instance(0)).scrollIntoView(new UiSelector().textContains(\"Let's have a quick recap!\").instance(0))");

		// profile

		driver.findElementByClassName("android.widget.ImageButton").click();
		if (driver.findElements(By.xpath(
				"//android.widget.ImageView[@resource-id='" + EnvConfig.baseAppPackage + ":id/imageViewProfile']"))
				.size() > 0) {
			System.out.println("Profile Picture--FOUND");
		} else {
			System.out.println("Profile Picture--NOT FOUND!!");
		}
		if (driver
				.findElements(By.xpath(
						"//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/textViewName']"))
				.size() > 0) {
			System.out.println("User Name--FOUND");
		} else {
			System.out.println("User Name--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath(
				"//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/textViewGradeSection']"))
				.size() > 0) {
			System.out.println("User Grade--FOUND");
		} else {
			System.out.println("User Grade--NOT FOUND!!");
		}
		if (driver
				.findElements(By.xpath(
						"//" + EnvConfig.view + "[@resource-id='" + EnvConfig.baseAppPackage + ":id/textViewAddress']"))
				.size() > 0) {
			System.out.println("User School--FOUND");
		} else {
			System.out.println("User School--NOT FOUND!!");
		}
		driver.findElementByAndroidUIAutomator("text(\"Personal\")").click();
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Compulsory Subjects']")).size() > 0) {
			System.out.println("Compulsory Subjects--FOUND");
		} else {
			System.out.println("Compulsory Subjects--NOT FOUND!!");
		}
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Hobby\").instance(0))");
		driver.findElementByAndroidUIAutomator("text(\"Parent\")").click();

		driver.findElementById("" + EnvConfig.baseAppPackage + ":id/imageViewSettings").click();
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Help & FAQs']")).size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.view + "[@text='Help & FAQs']").click();
			System.out.println("Help & FAQs--FOUND");
		} else {
			System.out.println("Help & FAQs--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Installation']")).size() > 0) {
			System.out.println("Content(Help & FAQs)--FOUND");
		} else {
			System.out.println("Content(Help & FAQs)--NOT FOUND!!");
		}
		driver.navigate().back();
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@text='Change Password']")).size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.view + "[@text='Change Password']").click();
			driver.findElementByXPath("//android.widget.EditText[@text='New Password']").sendKeys(EnvConfig.password);
			driver.findElementByXPath("//android.widget.EditText[@text='Confirm Password']")
					.sendKeys(EnvConfig.password);
			if (driver.findElements(By.xpath("//" + EnvConfig.button + "[@text='DONE']")).size() > 0) {
				driver.findElementByXPath("//" + EnvConfig.button + "[@text='DONE']").click();
				System.out.println("Password Changed Successfully");
			} else {
				System.out.println("Password not Changed Successfully!!");
			}
			System.out.println("Change Password--FOUND");
		} else {
			System.out.println("Change Password--NOT FOUND!!");
			driver.findElementById(EnvConfig.getBaseIdentifier("menu_logout")).click();
			driver.findElementByXPath("//" + EnvConfig.button + "[@text='LOGOUT']").click();
		}

	}

}

//set http_proxy=
//set https_proxy=

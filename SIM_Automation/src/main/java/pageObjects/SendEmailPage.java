package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import browserSetup_Login.BrowserOpen;
import browserSetup_Login.ExtentManager;

public class SendEmailPage extends BrowserOpen {

//	All the elements to make a Invoice required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements

//	WebDriver driver;
//	(1) All the elements will locate here

	// Click On Compose Email
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div[1]/div[1]/div/div")
	WebElement composeEmail;

//	Write email id to send an email
	@FindBy(xpath = "//div/input[ contains(@aria-label, 'To recipients')]")
	WebElement recepientEmail;

	// Add Subject
	@FindBy(xpath = "//*[@name=\"subjectbox\"]")
	WebElement addSubject;

	// Click On Write Message
	@FindBy(xpath = "//div[ contains(@aria-label, 'Message Body')]")
	WebElement writeEmail;

	// Click On Send Button
	@FindBy(xpath = "//div[contains(@aria-label, 'Send ‪(Ctrl-Enter)‬')]")
	WebElement sendEmail;

//	Handle Pop-up
	@FindBy(xpath = "//button[@data-mdc-dialog-action='ok']")
	WebElement okButton;

//	(2) Made a Constructor 
//	Initialize the Element
	public SendEmailPage() {
//		System.out.println("This is search context" + driver);
		BrowserOpen.log().info("This is search context" + driver);

		PageFactory.initElements(driver, this);
	}

// (3) Perform Action on the Elements

	public boolean composeEmail() {
		try {
			Thread.sleep(500);
			composeEmail.click();

			BrowserOpen.log().info("Clicked \"Compose Email\" SuccessFully");
			ExtentManager.test.log(Status.PASS, "Clicked \"Compose Email\" SuccessFully");
			Thread.sleep(2000);

			recepientEmail.click();

			recepientEmail.sendKeys("taliqmtr@gmail.com");
			BrowserOpen.log().info("Entered Recepient Email SuccessFully");
			ExtentManager.test.log(Status.PASS, "Entered Recepient Email SuccessFully");

			addSubject.sendKeys("Incubyte");
			BrowserOpen.log().info("Entered Subect SuccessFully");
			ExtentManager.test.log(Status.PASS, "Entered Subect SuccessFully");

			writeEmail.click();
			writeEmail.sendKeys(" QA Test for Incubyte.");

			BrowserOpen.log().info("Written Message SuccessFully");
			ExtentManager.test.log(Status.PASS, "Written Message SuccessFully");

			sendEmail.click();
			BrowserOpen.log().info("Email Send SuccessFully");
			ExtentManager.test.log(Status.PASS, "Email Sends SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Send Email Failed:" + e);
			ExtentManager.test.log(Status.FAIL, "Send Email Failed:" + e);

		}

		return false;
	}

	public boolean sendWithoutRecipient() {
		try {
			Thread.sleep(500);
			composeEmail.click();

			BrowserOpen.log().info("Clicked \"Compose Email\" SuccessFully");
			ExtentManager.test.log(Status.PASS, "Clicked \"Compose Email\" SuccessFully");
			Thread.sleep(500);

			addSubject.sendKeys("This Email is Generated Through Automation Script");
			BrowserOpen.log().info("Entered Subect SuccessFully");
			ExtentManager.test.log(Status.PASS, "Entered Subect SuccessFully");

			writeEmail.click();
			writeEmail.sendKeys("Hi,"
					+ "    This is Imran Sending EMail through Automation And Thanks to Taliq for his Time And Dedication."
					+ "Best Regards, " + "Imran Ansari");

			BrowserOpen.log().info("Written Message SuccessFully");
			ExtentManager.test.log(Status.PASS, "Written Message SuccessFully");

			sendEmail.click();
			Thread.sleep(500);

			okButton.click();
			BrowserOpen.log().info("Email Not Send Error Pop_up came");
			ExtentManager.test.log(Status.PASS, "Email Not Send Error Pop_up came");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

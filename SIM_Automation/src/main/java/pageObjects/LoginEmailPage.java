package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import browserSetup_Login.BrowserOpen;
import browserSetup_Login.ExtentManager;

public class LoginEmailPage extends BrowserOpen {

//	All the elements to make a Invoice required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements

//	WebDriver driver;
//	(1) All the elements will locate here

//	Click on SignIn Button
	@FindBy(xpath= "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/a/span")
	WebElement signIn;
	
	// Enter User name
	@FindBy(xpath = "//*[@id=\"identifierId\"]")
	WebElement userName;

	// Click on Next Button
	@FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
	WebElement nexButtonafterUsername;
	
    @FindBy(xpath = "//*[@id=\"view_container\"]//div[contains(text(), 'Wrong password. Try again or click Forgot password to reset it')]")
    WebElement passwordError;

	@FindBy(xpath = "//div[@class='Ekjuhf Jj6Lae']/text()[normalize-space(.)='Couldn’t find your Google Account']")
    WebElement emailError;
	
	// Add Password
	@FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	WebElement password;

	// Click on Next button after Enter Password
	@FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/span")
	WebElement nextButtonPass;

	// Click On Not Now After BrowserOpen
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[3]/div/div/div/div/div[2]/div[1]/button/span")
	WebElement notNowButton;

	// Click On Compose Email
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div[1]/div[1]/div/div")
	WebElement composeEmail;

//	Write email id to send an email
	@FindBy(xpath = "//*[@id=\":8s\"]/div/div[3]/div")
	WebElement recepientEmail;

	// Add Subject
	@FindBy(xpath = "//*[@name=\"subjectbox\"]")
	WebElement addSubject;

	// Click On Write Message	
	@FindBy(xpath = "//div[ contains(@aria-label, 'Message Body')]")
	WebElement writeEmail;

	// Click On Send Button
	@FindBy(xpath = "//tr//div[contains(text(), 'Send')]")
	WebElement sendEmail;

//	(2) Made a Constructor 
//	Initialize the Element
	public LoginEmailPage() {
//		System.out.println("This is search context" + driver);
		BrowserOpen.log().info("This is search context" + driver);

		PageFactory.initElements(driver, this);
	}

// (3) Perform Action on the Elements

	public boolean login() {
		try {

//			userName.sendKeys("imranallad18@gmail.com");
//			nexButtonafterUsername.click();
//			Thread.sleep(5000);
			
			
			
//
//			BrowserOpen.log().info("User Nmae Enters SuccessFully");
//			ExtentManager.test.log(Status.PASS, "User Nmae Enters SuccessFully");

//			Enter Password 

			password.clear();
			password.sendKeys("Alladin1803");
			nextButtonPass.click();
			Thread.sleep(5000);

			BrowserOpen.log().info("Password Enters SuccessFully");
			ExtentManager.test.log(Status.PASS, "Password Nmae Enters SuccessFully");
			Thread.sleep(500);
			
//			Go to Dashboard
		

			BrowserOpen.log().info("Navigate to Dashboard SuccessFully");
			ExtentManager.test.log(Status.PASS, "Navigate to Dashboard SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Login Failed:" + e);
			ExtentManager.test.log(Status.FAIL, "Login Failed:" + e);

		}

		return false;
	}
	
	public boolean loginWithInvalidEmail() {
        try {
            userName.sendKeys("invalid-emailjhhj87@gmail.com");
            nexButtonafterUsername.click();
            Thread.sleep(200);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Test invalid password
    public boolean loginWithInvalidPassword() {
        try {
        	userName.clear();
            userName.sendKeys("imranallad18@gmail.com");
            nexButtonafterUsername.click();
            Thread.sleep(2000);
            
            BrowserOpen.log().info("User Nmae Enters SuccessFully");
			ExtentManager.test.log(Status.PASS, "User Nmae Enters SuccessFully");
            
            password.sendKeys("wrong2344password");
            nextButtonPass.click();
            Thread.sleep(2000);
            
             return true;
            
        } catch (Exception e) {
            return false;
        }
    }
}



package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.LoginEmailPage;

public class LoginCreation extends LoginEmailPage {
	
	@Test(priority = 1, description = "Invalid Email login ")
	public void invalidEmailForm() throws InterruptedException {
		LoginEmailPage loginpom = new LoginEmailPage();

		boolean email = loginpom.loginWithInvalidEmail();
		Assert.assertEquals(email, true, "Couldn’t find your Google Account");
		Thread.sleep(7000);

	}
	
	
	@Test(priority = 2, description = "Invalid Password")
	public void invalidPass() throws InterruptedException {
		LoginEmailPage loginpom = new LoginEmailPage();

		boolean pass = loginpom.loginWithInvalidPassword();
		Assert.assertEquals(pass, true, "Wrong password. Try again or click Forgot password to reset it.");
		Thread.sleep(6000);

	}
	

	@Test(priority = 3, description = "Email login ")
	public void loginForm() throws InterruptedException {
		LoginEmailPage loginpom = new LoginEmailPage();

		boolean addDetails = loginpom.login();
		Assert.assertEquals(addDetails, true, "Email Login successfully");
		Thread.sleep(7000);

	}

}

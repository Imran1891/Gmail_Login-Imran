package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SendEmailPage;

public class SendEmail extends SendEmailPage {

	@Test(priority = 5, description = "Send Email Without Recepient Email")
	public void withoutRecepeintEmail() throws InterruptedException {
		SendEmailPage snedEmailpom = new SendEmailPage();

		boolean addDetails = snedEmailpom.sendWithoutRecipient();
		Assert.assertEquals(addDetails, true, "Please specify at least one recipient.");
		

	}
	
	@Test(priority = 4, description = "Send Email")
	public void sendEmail() throws InterruptedException {
		SendEmailPage snedEmailpom = new SendEmailPage();

		
		boolean addDetails = snedEmailpom.composeEmail();
		Assert.assertEquals(addDetails, true, "Email Send SuccessFully.");
		Thread.sleep(5000);
		

	}

}
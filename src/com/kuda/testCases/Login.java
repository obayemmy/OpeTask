package com.kuda.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kuda.base.TestBase;
import com.kuda.utility.Utility;

public class Login extends TestBase {

	@Test(description = "This TestCase will perform invalid login", priority = 1)
	public void invalidLogin() throws IOException, InterruptedException {
		//type email
		clear("emailField_XPATH");
		//driver.findElement(By.xpath(Utility.fetchLocator("emailField_XPATH"))).sendKeys(randomEmail());
		sendKeys("emailField_XPATH","email");
		//type password

		Thread.sleep(10000);
		clear("passwordField_ID");
		sendKeys("passwordField_ID","password");
		//click login button
		click("loginBtn_XPATH");
		//Validate response message
		String actualMsg = getText("failedLoginMSg_XPATH");
		System.out.println(actualMsg);
		String expectedMsg = "Username or password is invalid";
		Assert.assertEquals(actualMsg, expectedMsg, "Incorrect Message is returned");
		Thread.sleep(2000);
	}

	@Test(description = "This TestCase will perform valid login", priority = 2)
	public void validLogin() throws IOException, InterruptedException {
		//type email
		clear("emailField_XPATH");
		sendKeys("emailField_XPATH","validEmail");

		clear("passwordField_ID");
		sendKeys("passwordField_ID","validPassword");
		//		String emailAddress = randomFirstName();
		//		sendKeys("passwordField_ID",emailAddress);
		//		System.out.println(emailAddress);

		//click login button
		//Thread.sleep(5000);
		click("loginBtn_XPATH");
		//Validate response message
		//		String actualMsg = getText("failedLoginMSg_XPATH");
		//		String expectedMsg = "Username or password is invalid";
		//		Assert.assertEquals(actualMsg, expectedMsg, "Incorrect Message is returned");



	}

}

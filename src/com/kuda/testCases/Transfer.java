package com.kuda.testCases;
import com.kuda.base.TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class Transfer extends TestBase {

	Login login;
	@Test(description="test transafer", priority = 1)
	public void transfer() throws IOException, InterruptedException {
		login = new Login();
		// login
		login.validLogin();
		Thread.sleep(5000);
		//click payment button
		click("paymentBtn_LINKTEXT");
		//enter amount
		Thread.sleep(3000);
		sendKeys("amountField_NAME","amountValue");
		click("sendToDropDown_XPATH");
		click("newAccount_XPATH");
		click("selectBankBtn_XPATH");
		sendKeys("searchBankField_XPATH","searchBankText");
		click("earchResult_XPATH");
		sendKeys("accountnumberField_XPATH","accountNumberDigit");
		Thread.sleep(6000);
		String actulaAccountName = getText("displayedAccounName_XPATH");
		String expectedAccountName ="Oje Olugbenga Gabriel";
		Assert.assertEquals(actulaAccountName, expectedAccountName, "Name not displayed");
		//Thread.sleep(2000);
		JavascriptExecutor scollDown= (JavascriptExecutor)driver;
		scollDown.executeScript("window.scrollBy(0,500)");
		//Thread.sleep(2000);
		//click send  button
		click("sendMoneyBtn_XPATH");
		//click send Anyway button
		click("sendAnywayBtn_XPATH");
		//enter transafer pin
		sendKeys("transPinField1_XPATH","pinValue1");
		sendKeys("transPinField2_XPATH","pinValue2");
		sendKeys("transPinField3_XPATH","pinValue3");
		sendKeys("transPinField4_XPATH","pinValue4");
		//click send button
		click("sendBtn_XPATH");
		Thread.sleep(3000);
		//verify success message
		String actualMessage =  getText("successMsg_XPATH");
		String expectedMessage= "Success!";
		Assert.assertEquals(actualMessage,expectedMessage, " Response Doesn't match");
		//click okay button
		click("okayBtn_XPATH");

	}
}

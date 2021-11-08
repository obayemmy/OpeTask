package com.kuda.testCases;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import com.kuda.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExportStatementOfAccount extends TestBase {
	Robot robot = new Robot();
	Login log = new Login();

	public ExportStatementOfAccount() throws AWTException {
	}

	@Test
	public void TransactioReport() throws IOException, InterruptedException {
		log.validLogin();
		//Click Account Button
		Thread.sleep(8000);
		click("AccountBtn_LINKTEXT");
		//Click Statement of Account
		Thread.sleep(4000);
		click("AccountStatementBtn_XPATH");
		//Enter Start date
		sendKeys("startDateField_XPATH","startDate" );
		robot.keyPress(KeyEvent.VK_ENTER);
		//End date
		sendKeys("endDateField_XPATH","endDate");
	
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		//Click get button
		click("getBtn_XPATH");
		Thread.sleep(8000);


	}



}

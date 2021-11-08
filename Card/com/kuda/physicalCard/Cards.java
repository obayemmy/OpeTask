package com.kuda.physicalCard;

import java.io.IOException;

import org.jsoup.select.NodeFilter.FilterResult;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.kuda.base.TestBase;
import com.kuda.testCases.Login;
import com.kuda.utility.Utility;
import com.sun.net.httpserver.Authenticator.Result;

public class Cards  extends TestBase {

	Login login = new Login();

	@Test
	public void unblockCard() throws IOException, InterruptedException {
		//	if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
		login.validLogin();
		driver.findElement(By.xpath("//a[contains(text(),'Card')]")).click();
		Thread.sleep(4000);
		String cardText = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div[1]/div[1]/div[3]/div/div[1]/div[1]/div/span")).getText();
		System.out.println(cardText);
		if (cardText.equals("Block Card")) {
			System.out.println("Card is not blocked");
		} else {
			System.out.println("Card is blocked");
			driver.findElement(By.xpath("//div[@class='kuda-single--slide kuda-full--slide is-selected']//div[@class='kuda-add--cardForm request-options']//div[contains(@class,'kuda-bills--nav')]//div[@class='bill-item']")).click();
			//
			driver.findElement(By.xpath("//div[@class='bill-item has-checkBox redUnblock']")).click();
			driver.findElement(By.xpath("//div[@class='addAction kuda-cta kuda-cta-md kuda-cta-warning']")).click();
			Thread.sleep(8000);

			//		if (cardText.contains("Block Card Temporarily disable this card")){
			//
			//			System.out.println("cardText");
			//
			//		}else {
			//			driver.findElement(By.xpath("//div[@class='kuda-single--slide kuda-full--slide is-selected']//div[@class='kuda-add--cardForm request-options']//div[contains(@class,'kuda-bills--nav')]//div[@class='bill-item']")).click();
			//		}
			//
			driver.findElement(By.xpath("//div[@class='bill-item has-checkBox redUnblock']")).click();
			driver.findElement(By.xpath("//div[@class='addAction kuda-cta kuda-cta-md kuda-cta-warning']")).click();
			Thread.sleep(8000);

		}


	}

}



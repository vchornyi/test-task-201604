package com.mail.google;

import bsh.Console;
import com.mail.google.utils.PropertyLoader;
import com.mail.google.utils.webDriverListener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mail.google.pages.p01LoginPage;
import com.mail.google.pages.p02PasswordPage;
import com.mail.google.pages.p03EmailPage;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Configuration.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;

public class cl01TestNgGmailTest extends cl00TestNgTestBase {

  private static String gmailUsername = System.getProperty("gmail.uname", "test2888823@gmail.com");
  private static String gmailPassword = System.getProperty("gmail.pwd", "aqwe1234");

  private p01LoginPage p01LoginPage;
  private p02PasswordPage p02PasswordPage;
  private p03EmailPage p03EmailPage;

  @Test
  public void testGmailAuthentication() {
    /* ********* starting our test*/
    System.out.print("test started");

    addListener(new webDriverListener()); // Custom opening of WebDriver
    open(baseUrl);

    /* ********* 1ST PAGE - GMAIL ACCOUNT ********* */
    p01LoginPage = new p01LoginPage (driver);
    // wait 20 seconds to have element appearing, otherwise failing test
    Assert.assertTrue(p01LoginPage.inputEmail.waitUntil(appears, 20000).exists(),
      "1st page timed out - 20 seconds");

    p01LoginPage.inputEmail.sendKeys(gmailUsername);
    p01LoginPage.btnNext.click(); // click to go to next page (pwd page)

    /* ********* 2nd PAGE - GMAIL PASSWORD ********* */
    p02PasswordPage = new p02PasswordPage (driver);
    // wait 20 seconds to have element appearing, otherwise failing test
    Assert.assertTrue(p02PasswordPage.inputPassword.waitUntil(appears, 20000).exists(),
            "2nd page timed out - 20 seconds");

    p02PasswordPage.inputPassword.sendKeys(gmailPassword);
    p02PasswordPage.btnSignIn.click(); // click to go login

    p03EmailPage = new p03EmailPage(driver);
    // wait 20 seconds to have element appearing, otherwise failing test
    Assert.assertTrue(p03EmailPage.iconAccount.waitUntil(appears, 20000).exists(),
            "3rd page timed out - 20 seconds");
    p03EmailPage.iconAccount.click(); // open user's menu
    p03EmailPage.btnLogout.click(); // logout from Gmail

    /****************** tests finished
     * you can add break point here, to check debug-mode
     */
    System.out.print("test finished successfully");
  }

}
package com.mail.google;

import java.io.IOException;

//import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//import com.codeborne.selenide.webdriver.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

import com.mail.google.utils.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class cl00TestNgTestBase {

  protected WebDriver driver;
  protected String gmailUsername;
  protected String gmailPassword;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gmailUsername = PropertyLoader.loadProperty("gmail.uname");
    gmailPassword = PropertyLoader.loadProperty("gmail.pwd");
  }


  private FirefoxProfile createFirefoxProfile() {
    FirefoxProfile profile = new FirefoxProfile();
    profile.setEnableNativeEvents(false);
    profile.setPreference("intl.accept_languages", "en-us,en");
    return profile;
  }
}
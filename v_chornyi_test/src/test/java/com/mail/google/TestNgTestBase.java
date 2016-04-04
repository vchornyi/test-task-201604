package com.mail.google;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
/*
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;
*/
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.*;
import static com.codeborne.selenide.*;

import com.codeborne.selenide.webdriver.WebDriverFactory;

import com.mail.google.utils.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    //capabilities = PropertyLoader.loadCapabilities();
//    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

  @BeforeMethod
  public void initWebDriver() {
    FirefoxProfile profile = createFirefoxProfileWithExtensions();
    WebDriver driver = new FirefoxDriver(profile);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissAll();
  }

  private FirefoxProfile createFirefoxProfileWithExtensions() {
    FirefoxProfile profile = new FirefoxProfile();
    try {
      profile.addExtension(new File(currentThread().getContextClassLoader().getResource("firebug-1.11.4.xpi").getPath()));
      profile.addExtension(new File(currentThread().getContextClassLoader().getResource("firepath-0.9.7-fx.xpi").getPath()));
      profile.setPreference("extensions.firebug.showFirstRunPage", false);
      profile.setPreference("extensions.firebug.allPagesActivation", "on");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
    profile.setEnableNativeEvents(true);
    profile.setPreference("intl.accept_languages", "no,en-us,en");
    profile.setPreference("extensions.firebug.console.enableSites", "true");
    return profile;
  }

}

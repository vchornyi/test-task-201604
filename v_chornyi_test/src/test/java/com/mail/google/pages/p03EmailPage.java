package com.mail.google.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.mail.google.constants.c03Texts.P03_ACCOUNT_DETAILS;

/**
 * Created by Vchornyi on 05.04.2016.
 */
public class p03EmailPage extends p00BasePage {

  public SelenideElement iconAccount = $(byXpath(P03_ACCOUNT_DETAILS));

  public p03EmailPage(WebDriver webDriver) {
    super(webDriver);
  }

}

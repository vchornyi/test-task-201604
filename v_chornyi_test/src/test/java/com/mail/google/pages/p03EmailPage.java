package com.mail.google.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.mail.google.constants.c02Buttons.P03_ACCOUNT_DETAILS_BUTTON;
import static com.mail.google.constants.c02Buttons.P03_BUTTON_LOGOUT;

/**
 * Created by Vchornyi on 05.04.2016.
 */
public class p03EmailPage extends p00BasePage {

  public SelenideElement iconAccount = $(new By.ByCssSelector(P03_ACCOUNT_DETAILS_BUTTON));
  public SelenideElement btnLogout = $(new By.ByCssSelector(P03_BUTTON_LOGOUT));

  public p03EmailPage(WebDriver webDriver) {
    super(webDriver);
  }

}

package com.mail.google.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byId;
import static com.mail.google.constants.c01Inputs.P01_EMAIL;
import static com.mail.google.constants.c02Buttons.P01_BUTTON_NEXT;

/**
 * Created by Vchornyi on 05.04.2016.
 */
public class p01LoginPage extends p00BasePage {

  public SelenideElement inputEmail = $(byId(P01_EMAIL)); // find by id
  public SelenideElement btnNext = $(byId(P01_BUTTON_NEXT)); // find by id


  public p01LoginPage(WebDriver webDriver) {
    super(webDriver);
  }

}

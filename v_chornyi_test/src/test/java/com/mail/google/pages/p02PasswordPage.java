package com.mail.google.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byId;
import static com.mail.google.constants.c01Inputs.P02_PASSWORD;
import static com.mail.google.constants.c02Buttons.P02_BUTTON_SIGN_IN;
import static com.mail.google.constants.c01Inputs.P02_STAY_SIGNED_IN;

/**
 * Created by Vchornyi on 05.04.2016.
 */
public class p02PasswordPage extends p00BasePage {

  public SelenideElement inputPassword = $(byId(P02_PASSWORD));
  public SelenideElement btnSignIn = $(byId(P02_BUTTON_SIGN_IN));
  public SelenideElement chkbxStaySignedIn = $(byId(P02_STAY_SIGNED_IN));


  public p02PasswordPage(WebDriver webDriver) {
    super(webDriver);
  }

}

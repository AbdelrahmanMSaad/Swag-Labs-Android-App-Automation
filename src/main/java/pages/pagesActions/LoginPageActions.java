package pages.pagesActions;

import automatedActions.AutomatedActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.pages.HomePage;
import pages.pages.LoginPage;
import utils.Element;

public class LoginPageActions extends LoginPage {
    private final AutomatedActions automatedActions;
    private final Element element;

    public LoginPageActions(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
        this.automatedActions = new AutomatedActions(super.androidDriver);
        element = new Element(super.androidDriver);
    }

    public boolean isAppLogoDisplayed(){
        return this.automatedActions.displayActions().isElementDisplayed(element.getMobileElement(super.appLogo,super.loginPageElements));
    }

    public LoginPageActions sendTextToUserNameInput(String text){
        this.automatedActions.textActions().sendTextToElement(element.getMobileElement(super.userNameInput,super.loginPageElements),text);
        return this;
    }

    public LoginPageActions sendTextToPasswordInput(String text){
        this.automatedActions.textActions().sendTextToElement(element.getMobileElement(super.passwordInput,super.loginPageElements),text);
        return this;
    }

    public HomePage clickOnLoginButtonSuccessfulLogin(){
        this.automatedActions.clickingActions().clickOnElement(element.getMobileElement(super.loginBtn,super.loginPageElements));
        return new HomePage(this.androidDriver);
    }


}

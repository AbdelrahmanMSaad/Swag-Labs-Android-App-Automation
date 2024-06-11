package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;

/*
import for the LoginPageActions class, uncomment it after creating the actions class or if it was already created
*/
import pages.pagesActions.LoginPageActions;

import utils.Element;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    protected final AndroidDriver<MobileElement> androidDriver;
    protected final List<Element> loginPageElements = new ArrayList<>();

    public LoginPage(AndroidDriver<MobileElement> androidDriver){
        this.androidDriver = androidDriver;
        this.defineAllElements();
    }
     
    /**
    The Actions Method will be added commented till created then uncomment it,
    if it was already created, uncomment it directly after generating the pages java classes
    **/
    public LoginPageActions loginPageActions(){
        return new LoginPageActions(this.androidDriver);
    }
     
     
	protected String appLogo = "appLogo";
 
	protected String userNameInput = "userNameInput";
 
	protected String passwordInput = "passwordInput";
 
	protected String loginBtn = "loginBtn";
 
	protected String appImage = "appImage";
 
	private void defineAllElements(){
		loginPageElements.add(new Element("appLogo","Xpath","//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]"));
		loginPageElements.add(new Element("userNameInput","AccessibilityId","test-Username"));
		loginPageElements.add(new Element("passwordInput","AccessibilityId","test-Password"));
		loginPageElements.add(new Element("loginBtn","AccessibilityId","test-LOGIN"));
		loginPageElements.add(new Element("appImage","Xpath","//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[2]"));
	}

}

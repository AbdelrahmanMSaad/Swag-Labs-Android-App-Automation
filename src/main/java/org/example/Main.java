package org.example;

import configs.AppiumCapabilities.AppiumCapabilities;
import configs.appPackageAndActivities.AppPackageAndActivities;
import configs.appiumSettings.AppiumSettings;
import configs.appiumSettings.DeviceSettings;
import configs.appiumSettings.PlatformSettings;
import products.Products;
import initializers.InitializeConfigs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pages.HomePage;
import pages.pages.LoginPage;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        InitializeConfigs.initializeAllSettings();
        DesiredCapabilities desiredCapabilities = getDesiredCapabilities();
        AndroidDriver<MobileElement> androidDriver = new AndroidDriver<>(AppiumSettings.appiumUrl, desiredCapabilities);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver,10);
//        AndroidElement androidElement = (AndroidElement) webDriverWait.until(ExpectedConditions.visibilityOf((WebElement) MobileBy.AccessibilityId("test-Username")));
//        MobileElement mobileElement = (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("test-Username")));
//        System.out.println(mobileElement.isDisplayed());
        LoginPage loginPage = new LoginPage(androidDriver);
        HomePage homePage = loginPage.loginPageActions().sendTextToUserNameInput("standard_user").sendTextToPasswordInput("secret_sauce").clickOnLoginButtonSuccessfulLogin();
        System.out.println(homePage.homePageActions().getTitleOfProductByProductIndex(Products.thirdProduct));
        homePage.homePageActions().clickOnAddToCartBtnForProduct(Products.firstProduct).clickOnAddToCartBtnForProduct(Products.secondProduct);
        System.out.println(homePage.homePageActions().getCartNumberOfProducts());
//        homePage.homePageActions().openProductByIndex(Products.thirdProduct);
//        androidDriver.findElementByAccessibilityId("test-Username").sendKeys("abdelrahman");
//        LoginPage loginPage = new LoginPage(androidDriver);
//        System.out.println(loginPage.loginPageActions().sendTextToUserNameInput("username"));

    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(AppiumCapabilities.appPackage, AppPackageAndActivities.appPackage);
        desiredCapabilities.setCapability(AppiumCapabilities.appActivity, AppPackageAndActivities.splashActivity);

        desiredCapabilities.setCapability(AppiumCapabilities.automationName, AppiumSettings.automationName);

        desiredCapabilities.setCapability(AppiumCapabilities.deviceName, DeviceSettings.deviceName);
        desiredCapabilities.setCapability(AppiumCapabilities.udid, DeviceSettings.udid);

        desiredCapabilities.setCapability(AppiumCapabilities.platformName, PlatformSettings.androidPlatformName);
        desiredCapabilities.setCapability(AppiumCapabilities.platformVersion, PlatformSettings.androidVersion);

        return desiredCapabilities;
    }
}

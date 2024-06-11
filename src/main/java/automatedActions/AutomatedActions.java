package automatedActions;

import configs.ConfigFileProperties;
import handleFilesAndPaths.handleConfigFile.GetPropertiesFromConfigFile;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Element;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomatedActions {
    protected final AndroidDriver<MobileElement> androidDriver;
    private final Actions actions;
    private final WebDriverWait webDriverWait;
    private static long implicitWaitDuration;


    public AutomatedActions(AndroidDriver<MobileElement> androidDriver) {
        this.androidDriver = androidDriver;
        actions = new Actions(this.androidDriver);
        long elementWaitDuration = Long.parseLong(GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.elementWaitDuration));
        webDriverWait = new WebDriverWait(this.androidDriver, elementWaitDuration);
        implicitWaitDuration = Long.parseLong(GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.implicitWaitDuration));
    }

    public ClickingActions clickingActions() {
        return new ClickingActions();
    }

    public TextActions textActions() {
        return new TextActions();
    }

    public WaitActions waitActions() {
        return new WaitActions();
    }

    public DisplayActions displayActions() {
        return new DisplayActions();
    }

    public ListAndNestedActions listAndNestedActions() {
        return new ListAndNestedActions();
    }

    public class ClickingActions {
        public void clickOnElement(MobileElement mobileElement) {
            mobileElement.click();
        }

        public void doubleTabOnElement(MobileElement mobileElement) {
            actions.doubleClick(mobileElement);
        }
    }

    public static class TextActions {
        public String getTextFromElement(MobileElement mobileElement) {
            return mobileElement.getText();
        }

        public void sendTextToElement(MobileElement mobileElement, String text) {
            mobileElement.sendKeys(text);
        }
    }

    public class WaitActions {
        public void setImplicitWait() {
            androidDriver.manage().timeouts().implicitlyWait(implicitWaitDuration, TimeUnit.SECONDS);
        }

        public MobileElement waitForAnElementToBeClickable(Element element) {
            return switch (element.locatorMethod) {
                case "AccessibilityId" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(element.locatorValue)));
                case "Xpath" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(element.locatorValue)));
                case "Id" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.id(element.locatorValue)));
                case "ClassName" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.className(element.locatorValue)));
                case "CssSelector" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.cssSelector(element.locatorValue)));
                case "PartialLinkText" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.partialLinkText(element.locatorValue)));
                case "AndroidUIAutomator" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(element.locatorValue)));
                case "Name" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.name(element.locatorValue)));
                case "TagName" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(MobileBy.tagName(element.locatorValue)));
                default -> null;
            };
        }

        public MobileElement waitForAnElementToBeVisible(Element element) {
            return switch (element.locatorMethod) {
                case "AccessibilityId" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(element.locatorValue)));
                case "Xpath" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(element.locatorValue)));
                case "Id" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(element.locatorValue)));
                case "ClassName" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className(element.locatorValue)));
                case "CssSelector" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.cssSelector(element.locatorValue)));
                case "PartialLinkText" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.partialLinkText(element.locatorValue)));
                case "AndroidUIAutomator" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(element.locatorValue)));
                case "Name" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.name(element.locatorValue)));
                case "TagName" ->
                        (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.tagName(element.locatorValue)));
                default -> null;
            };
        }
    }

    public static class DisplayActions {
        public boolean isElementDisplayed(MobileElement mobileElement) {
            return mobileElement.isDisplayed();
        }

        public boolean isElementSelected(MobileElement mobileElement) {
            return mobileElement.isSelected();
        }

        public boolean isElementEnabled(MobileElement mobileElement) {
            return mobileElement.isEnabled();
        }
    }

    public class ListAndNestedActions {
        public List<MobileElement> getListOfMobileElements(Element element) {
            return switch (element.locatorMethod) {
                case "AccessibilityId" -> androidDriver.findElementsByAccessibilityId(element.locatorValue);
                case "Xpath" -> androidDriver.findElementsByXPath(element.locatorValue);
                case "Id" -> androidDriver.findElementsById(element.locatorValue);
                case "ClassName" -> androidDriver.findElementsByClassName(element.locatorValue);
                case "CssSelector" -> androidDriver.findElementsByCssSelector(element.locatorValue);
                case "PartialLinkText" -> androidDriver.findElementsByPartialLinkText(element.locatorValue);
                case "AndroidUIAutomator" -> androidDriver.findElementsByAndroidUIAutomator(element.locatorValue);
                case "Name" -> androidDriver.findElementsByName(element.locatorValue);
                case "TagName" -> androidDriver.findElementsByTagName(element.locatorValue);
                default -> null;
            };
        }

        public MobileElement getChildMobileElementFromParentMobileElement(MobileElement parentMobileElement, Element childElement) {
            return switch (childElement.locatorMethod) {
                case "AccessibilityId" -> parentMobileElement.findElementByAccessibilityId(childElement.locatorValue);
                case "Xpath" -> parentMobileElement.findElementByXPath(childElement.locatorValue);
                case "Id" -> parentMobileElement.findElementById(childElement.locatorValue);
                case "ClassName" -> parentMobileElement.findElementByClassName(childElement.locatorValue);
                case "CssSelector" -> androidDriver.findElementByCssSelector(childElement.locatorValue);
                case "PartialLinkText" -> androidDriver.findElementByPartialLinkText(childElement.locatorValue);
                case "AndroidUIAutomator" -> androidDriver.findElementByAndroidUIAutomator(childElement.locatorValue);
                case "Name" -> androidDriver.findElementByName(childElement.locatorValue);
                case "TagName" -> androidDriver.findElementByTagName(childElement.locatorValue);
                default -> null;
            };
        }

        public List<MobileElement> getChildMobileElementsFromParentMobileElement(MobileElement parentMobileElement, Element childElement) {
            return switch (childElement.locatorMethod) {
                case "AccessibilityId" ->
                        parentMobileElement.findElementsByAccessibilityId(childElement.locatorValue);
                case "Xpath" ->
                        parentMobileElement.findElementsByXPath(childElement.locatorValue);
                case "Id" ->
                        parentMobileElement.findElementsById(childElement.locatorValue);
                case "ClassName" ->
                        parentMobileElement.findElementsByClassName(childElement.locatorValue);
                case "CssSelector" ->
                        parentMobileElement.findElementsByCssSelector(childElement.locatorValue);
                case "PartialLinkText" ->
                        parentMobileElement.findElementsByPartialLinkText(childElement.locatorValue);
                case "Name" ->
                        parentMobileElement.findElementsByName(childElement.locatorValue);
                case "TagName" ->
                        parentMobileElement.findElementsByTagName(childElement.locatorValue);
                default -> null;
            };
        }
    }
}


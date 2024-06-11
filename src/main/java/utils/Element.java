package utils;

import automatedActions.AutomatedActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class Element {
    public String elementName;
    public String locatorMethod;
    public String locatorValue;

    private AndroidDriver<MobileElement> androidDriver;
    private AutomatedActions automatedActions;

    public Element(){

    }

    public Element(String elementName,String locatorMethod,String locatorValue){
        this.elementName = elementName;
        this.locatorMethod = locatorMethod;
        this.locatorValue = locatorValue;
    }

    public Element(AndroidDriver<MobileElement> androidDriver){
        this.androidDriver = androidDriver;
        this.automatedActions = new AutomatedActions(this.androidDriver);
    }

    private Element findElement(String elementName,List<Element> elements){
        for (Element element:elements){
            if(element.elementName.equalsIgnoreCase(elementName)){
                return element;
            }
        }
        return null;
    }

    private MobileElement waitForElement(Element element){
        if(element.elementName.toLowerCase().contains("btn")){
            return automatedActions.waitActions().waitForAnElementToBeClickable(element);
        }else {
            return automatedActions.waitActions().waitForAnElementToBeVisible(element);
        }
    }

    public Element getElement(String elementName,List<Element> elements){
        Element element = this.findElement(elementName,elements);
        assert element != null;
        waitForElement(element);
        return element;
    }

    public MobileElement getMobileElement(String elementName, List<Element> elements){
        Element element = this.findElement(elementName,elements);
        assert element != null;
        return waitForElement(element);
    }

    public Element getListOfElements(String elementName, List<Element> elements){
        Element element = this.findElement(elementName,elements);
        assert element != null;
        waitForElement(element);
        return element;
    }
}
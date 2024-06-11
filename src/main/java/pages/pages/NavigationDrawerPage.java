package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;

/*
import for the NavigationDrawerPageActions class, uncomment it after creating the actions class or if it was already created
*/
//import pages.pagesActions.NavigationDrawerPageActions;

import utils.Element;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerPage {
    protected final AndroidDriver<MobileElement> androidDriver;
    protected final List<Element> navigationDrawerPageElements = new ArrayList<>();

    public NavigationDrawerPage(AndroidDriver<MobileElement> androidDriver){
        this.androidDriver = androidDriver;
        this.defineAllElements();
    }
     
    /**
    The Actions Method will be added commented till created then uncomment it,
    if it was already created, uncomment it directly after generating the pages java classes
    **/
    //public NavigationDrawerPageActions navigationDrawerPageActions(){
    //    return new NavigationDrawerPageActions(this.androidDriver);
    //}
     
     
	protected String testCloseContainer = "testCloseContainer";
 
	protected String testCloseBtn = "testCloseBtn";
 
	protected String allItemsButton = "allItemsButton";
 
	protected String webViewBtn = "webViewBtn";
 
	protected String qrCodeScannerBtn = "qrCodeScannerBtn";
 
	protected String geoLocationBtn = "geoLocationBtn";
 
	protected String drawingBtn = "drawingBtn";
 
	protected String aboutBtn = "aboutBtn";
 
	protected String logoutBtn = "logoutBtn";
 
	protected String resetAppStateBtn = "resetAppStateBtn";
 
	private void defineAllElements(){
		navigationDrawerPageElements.add(new Element("testCloseContainer","AccessibilityId","test-Close"));
		navigationDrawerPageElements.add(new Element("testCloseBtn","ClassName","android.view.ViewGroup"));
		navigationDrawerPageElements.add(new Element("allItemsButton","Xpath","//android.widget.TextView[contains(@text,'ALL ITEMS')]"));
		navigationDrawerPageElements.add(new Element("webViewBtn","Xpath","//android.widget.TextView[@text=\"WEBVIEW\"]"));
		navigationDrawerPageElements.add(new Element("qrCodeScannerBtn","Xpath","//android.widget.TextView[@text=\"QR CODE SCANNER\"]"));
		navigationDrawerPageElements.add(new Element("geoLocationBtn","Xpath","//android.widget.TextView[@text=\"GEO LOCATION\"]"));
		navigationDrawerPageElements.add(new Element("drawingBtn","Xpath","//android.widget.TextView[@text=\"DRAWING\"]"));
		navigationDrawerPageElements.add(new Element("aboutBtn","Xpath","//android.widget.TextView[@text=\"ABOUT\"]"));
		navigationDrawerPageElements.add(new Element("logoutBtn","Xpath","//android.widget.TextView[@text=\"LOGOUT\"]"));
		navigationDrawerPageElements.add(new Element("resetAppStateBtn","Xpath","//android.widget.TextView[@text=\"RESET APP STATE\"]"));
	}

}

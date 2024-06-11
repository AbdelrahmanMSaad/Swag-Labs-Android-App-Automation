package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;

/*
import for the HomePageActions class, uncomment it after creating the actions class or if it was already created
*/
import pages.pagesActions.HomePageActions;

import utils.Element;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    protected final AndroidDriver<MobileElement> androidDriver;
    protected final List<Element> homePageElements = new ArrayList<>();

    public HomePage(AndroidDriver<MobileElement> androidDriver){
        this.androidDriver = androidDriver;
        this.defineAllElements();
    }
     
    /**
    The Actions Method will be added commented till created then uncomment it,
    if it was already created, uncomment it directly after generating the pages java classes
    **/
    public HomePageActions homePageActions(){
        return new HomePageActions(this.androidDriver);
    }
     
     
	protected String navigationDrawerBtn = "navigationDrawerBtn";
 
	protected String appLogo = "appLogo";
 
	protected String cartIcon = "cartIcon";
 
	protected String cartInnerContainer = "cartInnerContainer";
 
	protected String cartText = "cartText";
 
	protected String toggleGridListBtn = "toggleGridListBtn";
 
	protected String filterBtn = "filterBtn";
 
	protected String allProductsScrollContainer = "allProductsScrollContainer";
 
	protected String allProductsViewContainer = "allProductsViewContainer";
 
	protected String productsRowContainer = "productsRowContainer";
 
	protected String productOuterContainer = "productOuterContainer";
 
	protected String productViewContainer = "productViewContainer";
 
	protected String productInnerViewContainer = "productInnerViewContainer";
 
	protected String productImage = "productImage";
 
	protected String openProductBtn = "openProductBtn";
 
	protected String productTitle = "productTitle";
 
	protected String productPrice = "productPrice";
 
	protected String dragHandleButton = "dragHandleButton";
 
	protected String addToCartBtn = "addToCartBtn";
 
	protected String removeFromCartBtn = "removeFromCartBtn";
 
	private void defineAllElements(){
		homePageElements.add(new Element("navigationDrawerBtn","Xpath","//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView"));
		homePageElements.add(new Element("appLogo","Xpath","//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]"));
		homePageElements.add(new Element("cartIcon","AccessibilityId","test-Cart"));
		homePageElements.add(new Element("cartInnerContainer","Xpath","//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup"));
		homePageElements.add(new Element("cartText","ClassName","android.widget.TextView"));
		homePageElements.add(new Element("toggleGridListBtn","AccessibilityId","test-Toggle"));
		homePageElements.add(new Element("filterBtn","AccessibilityId","test-Modal Selector Button"));
		homePageElements.add(new Element("allProductsScrollContainer","AccessibilityId","test-PRODUCTS"));
		homePageElements.add(new Element("allProductsViewContainer","ClassName","android.view.ViewGroup"));
		homePageElements.add(new Element("productsRowContainer","ClassName","android.view.ViewGroup"));
		homePageElements.add(new Element("productOuterContainer","ClassName","android.view.ViewGroup"));
		homePageElements.add(new Element("productViewContainer","AccessibilityId","test-Item"));
		homePageElements.add(new Element("productInnerViewContainer","ClassName","android.view.ViewGroup"));
		homePageElements.add(new Element("productImage","ClassName","android.widget.ImageView"));
		homePageElements.add(new Element("openProductBtn","Xpath","//android.widget.TextView[@text=\"󰝁\"]"));
		homePageElements.add(new Element("productTitle","AccessibilityId","test-Item title"));
		homePageElements.add(new Element("productPrice","AccessibilityId","test-Price"));
		homePageElements.add(new Element("dragHandleButton","AccessibilityId","test-Drag Handle"));
		homePageElements.add(new Element("addToCartBtn","AccessibilityId","test-ADD TO CART"));
		homePageElements.add(new Element("removeFromCartBtn","AccessibilityId","test-REMOVE"));
	}

}

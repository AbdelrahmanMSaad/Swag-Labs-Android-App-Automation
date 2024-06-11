package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;

/*
import for the ProductPageActions class, uncomment it after creating the actions class or if it was already created
*/
//import pages.pagesActions.ProductPageActions;

import utils.Element;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    protected final AndroidDriver<MobileElement> androidDriver;
    protected final List<Element> productPageElements = new ArrayList<>();

    public ProductPage(AndroidDriver<MobileElement> androidDriver){
        this.androidDriver = androidDriver;
        this.defineAllElements();
    }
     
    /**
    The Actions Method will be added commented till created then uncomment it,
    if it was already created, uncomment it directly after generating the pages java classes
    **/
    //public ProductPageActions productPageActions(){
    //    return new ProductPageActions(this.androidDriver);
    //}
     
     
	protected String navigationDrawerBtn = "navigationDrawerBtn";
 
	protected String appLogo = "appLogo";
 
	protected String cartIcon = "cartIcon";
 
	protected String cartInnerContainer = "cartInnerContainer";
 
	protected String cartText = "cartText";
 
	protected String backToProductsBtn = "backToProductsBtn";
 
	protected String productContainer = "productContainer";
 
	protected String productDescription = "productDescription";
 
	protected String productPrice = "productPrice";
 
	protected String addToCartBtn = "addToCartBtn";
 
	protected String removeFromCartBtn = "removeFromCartBtn";
 
	private void defineAllElements(){
		productPageElements.add(new Element("navigationDrawerBtn","Xpath","//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView"));
		productPageElements.add(new Element("appLogo","Xpath","//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]"));
		productPageElements.add(new Element("cartIcon","AccessibilityId","test-Cart"));
		productPageElements.add(new Element("cartInnerContainer","Xpath","//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup"));
		productPageElements.add(new Element("cartText","ClassName","android.widget.TextView"));
		productPageElements.add(new Element("backToProductsBtn","AccessibilityId","test-BACK TO PRODUCTS"));
		productPageElements.add(new Element("productContainer","AccessibilityId","test-Inventory item page"));
		productPageElements.add(new Element("productDescription","AccessibilityId","test-Description"));
		productPageElements.add(new Element("productPrice","AccessibilityId","test-Price"));
		productPageElements.add(new Element("addToCartBtn","AccessibilityId","test-ADD TO CART"));
		productPageElements.add(new Element("removeFromCartBtn","AccessibilityId","test-REMOVE"));
	}

}

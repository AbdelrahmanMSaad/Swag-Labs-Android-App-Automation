package pages.pagesActions;

import automatedActions.AutomatedActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.pages.HomePage;
import pages.pages.NavigationDrawerPage;
import pages.pages.ProductPage;
import utils.Element;

public class ProductPageActions extends ProductPage {
    private final AutomatedActions automatedActions;
    private final Element element;

    public ProductPageActions(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
        this.automatedActions = new AutomatedActions(androidDriver);
        this.element = new Element(androidDriver);
    }

    public NavigationDrawerPage clickOnNavigationDrawerButton(){
        this.automatedActions.clickingActions().clickOnElement(element.getMobileElement(super.navigationDrawerBtn,super.productPageElements));
        return new NavigationDrawerPage(this.androidDriver);
    }

    public boolean isAppLogoDisplayed(){
        return this.automatedActions.displayActions().isElementDisplayed(element.getMobileElement(super.appLogo,super.productPageElements));
    }

    public String getNumberOfProductsInCart(){
        return this.automatedActions.textActions().getTextFromElement(this.automatedActions.listAndNestedActions().getChildMobileElementFromParentMobileElement(element.getMobileElement(super.cartInnerContainer,super.productPageElements),element.getElement(super.cartText,super.productPageElements)));
    }

    public void clickOnCartButton(){
        this.automatedActions.clickingActions().clickOnElement(element.getMobileElement(super.cartIcon,super.productPageElements));
        //TODO : return cart screen
    }

    public HomePage clickOnBackToProductsButton(){
        this.automatedActions.clickingActions().clickOnElement(element.getMobileElement(super.backToProductsBtn,super.productPageElements));
        return new HomePage(this.androidDriver);
    }

    public String getProductDescription(){
        return this.automatedActions.textActions().getTextFromElement(element.getMobileElement(super.productDescription,super.productPageElements));
    }

    public String getProductPrice(){
        return this.automatedActions.textActions().getTextFromElement(element.getMobileElement(super.productPrice,super.productPageElements)).replace("$","");
    }

    public ProductPage clickOnAddToCartButton(){
        this.automatedActions.clickingActions().clickOnElement(element.getMobileElement(super.addToCartBtn,super.productPageElements));
        return this;
    }

    public ProductPage clickOnRemoveFromCartButton(){
        this.automatedActions.clickingActions().clickOnElement(element.getMobileElement(super.removeFromCartBtn,super.productPageElements));
        return this;
    }


}

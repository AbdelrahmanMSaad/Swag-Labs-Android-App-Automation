package pages.pagesActions;

import automatedActions.AutomatedActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.pages.HomePage;
import pages.pages.NavigationDrawerPage;
import pages.pages.ProductPage;
import utils.Element;

import java.util.List;

public class HomePageActions extends HomePage {
    private final AutomatedActions automatedActions;
    private final Element element;


    public HomePageActions(AndroidDriver<MobileElement> androidDriver) {
        super(androidDriver);
        this.automatedActions = new AutomatedActions(androidDriver);
        this.element = new Element(androidDriver);
    }

    public NavigationDrawerPage clickOnNavigationDrawerButton(){
        this.automatedActions.clickingActions().clickOnElement(element.getMobileElement(super.navigationDrawerBtn,super.homePageElements));
        return new NavigationDrawerPage(this.androidDriver);
    }

    public String getCartNumberOfProducts (){
        MobileElement cartInnerContainer = element.getMobileElement(super.cartInnerContainer,super.homePageElements),
                cartTextElement = this.automatedActions.listAndNestedActions().getChildMobileElementFromParentMobileElement(cartInnerContainer,element.getElement(super.cartText,super.homePageElements));
        return this.automatedActions.textActions().getTextFromElement(cartTextElement);

    }

    public boolean isAppLogoDisplayed(){
        return this.automatedActions.displayActions().isElementDisplayed(element.getMobileElement(super.appLogo,super.homePageElements));
    }

    public HomePageActions clickOnToggleGridListButton(){
        this.automatedActions.clickingActions().clickOnElement(element.getMobileElement(super.toggleGridListBtn,super.homePageElements));
        return this;
    }

    public int getNumberOfProductsOnTheScreen(){
        return this.automatedActions.listAndNestedActions().getListOfMobileElements(element.getListOfElements(super.productViewContainer,super.homePageElements)).size();
    }

    private List<MobileElement> getListOfProducts(){
        return this.automatedActions.listAndNestedActions().getListOfMobileElements(element.getListOfElements(super.productViewContainer,super.homePageElements));
    }

    private MobileElement getProductFromProductsList(int productIndex){
        return this.getListOfProducts().get(productIndex);
    }

    public String getPriceOfProductByProductIndex(int productIndex){
        return this.automatedActions.textActions().getTextFromElement(this.automatedActions.listAndNestedActions().getChildMobileElementFromParentMobileElement(this.getProductFromProductsList(productIndex),element.getElement(super.productPrice,super.homePageElements))).replace("$","");
    }

    public String getTitleOfProductByProductIndex(int productIndex){
        return this.automatedActions.textActions().getTextFromElement(this.automatedActions.listAndNestedActions().getChildMobileElementFromParentMobileElement(this.getProductFromProductsList(productIndex),element.getElement(super.productTitle,super.homePageElements)));
    }

    public ProductPage openProductByIndex(int productIndex){
        MobileElement product = this.getProductFromProductsList(productIndex);
        this.automatedActions.clickingActions().clickOnElement(this.automatedActions.listAndNestedActions().getChildMobileElementFromParentMobileElement(product,element.getElement(super.openProductBtn,super.homePageElements)));
        return new ProductPage(this.androidDriver);
    }

    public HomePageActions clickOnAddToCartBtnForProduct(int productIndex){
        MobileElement product = this.getProductFromProductsList(productIndex);
        this.automatedActions.clickingActions().clickOnElement(this.automatedActions.listAndNestedActions().getChildMobileElementFromParentMobileElement(product,element.getElement(super.addToCartBtn,super.homePageElements)));
        return this;
    }

}

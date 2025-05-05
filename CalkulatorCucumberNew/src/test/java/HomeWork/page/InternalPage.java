package HomeWork.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends BasePage {


    @FindBy(css = "#navbarExample")
    public WebElement navigationButtonPanel;

    @FindBy(css = ".navbar-brand#nava")
    public WebElement logBrandHeader;

    @FindBy(xpath = "//*[@id=\"fotcont\"]//h4[contains(text(),' PRODUCT STORE')]")
    public WebElement logBrandFooter;

    @FindBy(css = "a.nav-link[href='index.html']")
    public WebElement homeButton;


}

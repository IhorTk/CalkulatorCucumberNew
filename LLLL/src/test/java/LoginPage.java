package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

public class LoginPage extends BasePage {
    public LoginPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#loginpage-input-email")
    public WebElement email;
    @FindBy(css = "#loginpage-form-pw-input")
    public WebElement password;
    @FindBy(css = "#loginpage-form-btn")
    public WebElement loginButton;
    @FindBy(css = "#rcc-confirm-button")
    public WebElement confirmButton;

    public DashboardPage login() {
        context.wait.until(ExpectedConditions.visibilityOf(confirmButton));
        confirmButton.click();
        email.sendKeys(ConfigurationReader.get("userName"));
        password.sendKeys(ConfigurationReader.get("userPassword"));
        loginButton.click();

        return new DashboardPage(context);
    }
}

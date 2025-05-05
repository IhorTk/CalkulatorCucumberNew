package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.urlToBe("http://92.205.106.232/dashboard"));
        context.wait.until(ExpectedConditions.visibilityOf(dashboardHeader));
    }

    @FindBy(css = "#dashboard-h1")
    private WebElement dashboardHeader;

    public String getHeaderText() {
        return dashboardHeader.getText();
    }
}

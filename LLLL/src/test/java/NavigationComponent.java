package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationComponent extends BasePage {
    public NavigationComponent(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.visibilityOf(title));
    }

    @FindBy(css = "#navbar-menu-h1 > a")
    private WebElement title;
    @FindBy(css = "#navbar-menu-list2-item2")
    private WebElement allPosts;

    public AllPostsPage openAllPosts() {
        allPosts.click();
        return new AllPostsPage(context);
    }
}

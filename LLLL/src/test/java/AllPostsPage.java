package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.function.Predicate;

public class AllPostsPage extends BasePage{
    public AllPostsPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.urlToBe("http://92.205.106.232/posts"));
        context.wait.until(ExpectedConditions.visibilityOf(allPostsHeader));

    }

    @FindBy(css = "#posts-heading")
    private WebElement allPostsHeader;

    @FindAll({@FindBy(css = "#post-item-container")})
    private List<WebElement> postContainers;

    @FindBy(css = "#posts-search-input")
    private WebElement searchInput;

    @FindBy(css = "#posts-search-btn")
    private WebElement searchButton;

    @FindBy(css = "#posts-search-results-heading")
    private WebElement searchResultHeading;

    public List<PostComponent> getPosts() {
        return postContainers.stream().map(element -> new PostComponent(context, element)).toList();
    }

    public PostComponent getPost(Predicate<PostComponent> condition) {
        return getPosts().stream().filter(condition).findFirst().orElseThrow();
    }

    public String getHeaderText(){
        return allPostsHeader.getText();
    }

    public AllPostsPage search(String text){
        searchInput.sendKeys(text);
        searchButton.click();
        context.wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
        return this;
    }


}

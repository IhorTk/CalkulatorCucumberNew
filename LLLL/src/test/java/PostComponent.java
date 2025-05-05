package pages;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PostComponent extends BasePage {
    //Контейнер для экомпонента post
    WebElement element;

    public PostComponent(TestContext context, WebElement element) {
        super(context);
        this.element = element;
    }

    public String getPostTitle(){
        return element.findElement(By.cssSelector("#post-item-heading")).getText();
    }

    public String getPostText(){
        return element.findElement(By.cssSelector("#post-item-text")).getText();
    }

    public String getPostDate(){
        return element.findElement(By.cssSelector("#post-item-date > time")).getText();
    }
}

package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import utils.ConfigurationReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DevExTests extends BaseTest{

    @Test
    public void loginTest(){
        context.driver.get(ConfigurationReader.get("url") + "login");
        LoginPage loginPage = new LoginPage(context);

        DashboardPage dashboardPage = loginPage.login();

        assertEquals("Dashboard", dashboardPage.getHeaderText());
    }

    @Test
    public void postsCountTest(){
        context.driver.get(ConfigurationReader.get("url") + "login");
        LoginPage loginPage = new LoginPage(context);

        NavigationComponent navigationComponent = new NavigationComponent(context);

        loginPage.login();
        AllPostsPage allPostsPage = navigationComponent.openAllPosts();

        assertEquals("Posts", allPostsPage.getHeaderText());
        assertEquals(474, allPostsPage.getPosts().size());
    }

    @Test
    public void postsTextTest(){
        context.driver.get(ConfigurationReader.get("url") + "login");
        LoginPage loginPage = new LoginPage(context);
        NavigationComponent navigationPage = new NavigationComponent(context);

        loginPage.login();
        AllPostsPage allPostsPage = navigationPage.openAllPosts();

        assertEquals("Posts", allPostsPage.getHeaderText());

        PostComponent firstPost = allPostsPage.getPosts().getFirst();

        assertEquals("New test", firstPost.getPostTitle());
        assertEquals("Description", firstPost.getPostText());
    }


    @Test
    public void postsFilterTest(){

        context.driver.get(ConfigurationReader.get("url") + "login");
        LoginPage loginPage = new LoginPage(context);
        NavigationComponent navigationPage = new NavigationComponent(context);

        loginPage.login();
        AllPostsPage allPostsPage = navigationPage.openAllPosts();

        assertEquals("Posts", allPostsPage.getHeaderText());

        PostComponent post = allPostsPage.getPost(postComponent -> postComponent.getPostTitle().equals("JDBC"));

        assertEquals("2023/11/24", post.getPostDate());
    }

    @Test
    public void searchPostTest(){

        context.driver.get(ConfigurationReader.get("url") + "login");
        LoginPage loginPage = new LoginPage(context);
        NavigationComponent navigationPage = new NavigationComponent(context);

        loginPage.login();
        AllPostsPage allPostsPage = navigationPage.openAllPosts();

       allPostsPage.search("JDBC");

        List<PostComponent> searchResult = allPostsPage.getPosts();

        assertEquals(1, searchResult.size());
        assertEquals("JDBC", searchResult.getFirst().getPostTitle());
    }
}

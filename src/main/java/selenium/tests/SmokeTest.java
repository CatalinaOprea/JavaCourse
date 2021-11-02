package selenium.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.pages.BlogPage;
import selenium.pages.LoginPage;
import selenium.utils.BaseTest;
import selenium.utils.TestNgListener;

@Listeners(TestNgListener.class)
public class SmokeTest extends BaseTest {

    @Test
    public void smokeTest () throws InterruptedException {

        BlogPage blogPage = homePage.navigateToBlog();

        blogPage.returnBlog(blogPage.blog1,"But I must explain to you how all this mistaken idea");
        blogPage.returnBlog(blogPage.blog2,"The Problem With Typefaces on the Web");
        blogPage.returnBlog(blogPage.blog3,"English Breakfast Tea With Tasty Donut Desserts");
        blogPage.returnBlog(blogPage.blog4,"On the other hand we provide denounce with righteous");

        blogPage.addCommentOnBlog(blogPage.blog1);
        Thread.sleep(10000);
        blogPage.addCommentOnBlog(blogPage.blog2);
        Thread.sleep(10000);
        blogPage.addCommentOnBlog(blogPage.blog3);
        Thread.sleep(10000);
        blogPage.addCommentOnBlog(blogPage.blog4);

    }



}

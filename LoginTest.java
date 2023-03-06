import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class LoginTest extends BaseTest{


//    By usernameField = By.id("username");
//    By passwordField = By.id("password");
//    By loginButton = By.cssSelector(".fa");
//    By actualTextAndColorElement = By.id("flash");

    By logInButton = By.xpath("//a[@class='ico-login']");
    By logInEMailField = By.xpath("//input[@id='Email']");
    By logInPasswordField = By.xpath("//input[@id='Password']");
    By confirmLoginButton = By.xpath("//input[@class='button-1 login-button']");
    By booksButton = By.cssSelector(".top-menu a[href*='/books']");
    By addToCartBook1 = By.cssSelector(".button-2[onclick*='catalog/1']");
    By addToCartBook2 = By.cssSelector(".button-2[onclick*='catalog/45']");
    By shoppingCart = By.cssSelector(".ico-cart .cart-label");

    By book1Price = By.xpath("(//span[@class='product-subtotal'])[1]");
    By book2Price = By.xpath("(//span[@class='product-subtotal'])[2]");
    By totalPrice = By.xpath("(//span[@class='product-price'])[1]");


    @Test
    public void addToCartTest() throws InterruptedException{
        clickOnElement(logInButton);
        typeIn(logInEMailField, "PeraPeric192@gmail.com");
        typeIn(logInPasswordField, "lozinka123!");
        clickOnElement(confirmLoginButton);
        clickOnElement(booksButton);
        clickOnElement(addToCartBook1);
        Thread.sleep(3000);
        clickOnElement(addToCartBook2);
        clickOnElement(shoppingCart);

        String cena1 = getTextFromElement(book1Price);
        String cena2 = getTextFromElement(book2Price);
        String ukupnaCena = getTextFromElement(totalPrice);
        double d1 = Double.parseDouble(cena1);
        double d2 = Double.parseDouble(cena2);
        double finalnaCena = Double.parseDouble(ukupnaCena);

        double zbirCena = d1 + d2;

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(finalnaCena);
        System.out.println(zbirCena);

        Assert.assertTrue(finalnaCena == zbirCena, "Test pao, finalna cena nije jednaka zbirnoj ceni proizvoda!");



    }



































//    @Test
//    public void loginTestByText() {
//
//        typeIn(usernameField, "tomsmith");
//        typeIn(passwordField, "SuperSecretPassword!");
//        clickOnElement(loginButton);
//
//        String actualText = getTextFromElement(actualTextAndColorElement);
//        System.out.println(actualText);
//
//        int indexDrugi = actualText.length() - 2;
//
//        String actualTextSubString = actualText.substring(0, indexDrugi);
//
//        String actualTextSplit[] = actualText.split("(?<=!)");
//
//        String expectedText = "You logged into a secure area!";
//
//        Assert.assertEquals(actualTextSplit[0], expectedText, "Expected text is not equal to actual text!!!");
//
//    }
//
//    @Test
//    public void loginTestByColor(){
//
//        typeIn(usernameField, "tomsmith");
//        typeIn(passwordField, "SuperSecretPassword!");
//        clickOnElement(loginButton);
//
//        String actualColor = getColorFromElement(actualTextAndColorElement, "background-color");
//        System.out.println(actualColor);
//
//        String expectedColor = "rgba(93, 164, 35, 1)";
//
//        Assert.assertTrue(actualColor.equals(expectedColor), "Expected color is not equal to: " + actualColor);
//
//    }
}

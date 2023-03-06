import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Utils;


public class RegistrationTest extends BaseTest {


    By registerButton = By.cssSelector("a[class='ico-register']");
    // By.xpath("a[@class='ico-register']");

    By firstName = By.cssSelector("input[id='FirstName']");

    By lastName = By.cssSelector("input[id='LastName']");
    By eMail = By.cssSelector("input[id='Email']");
    // By eMail = By.xpath("//input[@id='Email']");
    By password = By.cssSelector("input[id='Password']");
    By confirmPassword = By.cssSelector("input[id='ConfirmPassword']");

    By confirmRegisterButton = By.cssSelector("input[id='register-button']");

    By genderPick = By.cssSelector("input[id='gender-male']");

    By expectedText = By.cssSelector("div[class='result']");

    By continueButton = By.cssSelector("input[class='button-1 register-continue-button']");


    @Test
    public void registerUser() throws InterruptedException {

        String eMail2 = Utils.generateRandomEmail();


        clickOnElement(registerButton);


        //   String color = getColorFromElement(registerButton, "color");
        // System.out.println(color);

        Thread.sleep(3000);

        clickOnElement(genderPick);
        typeIn(firstName, "Pera");
        typeIn(lastName, "Peric");
        //  typeIn(eMail, "PeraPeric192@gmail.com");
        typeIn(eMail, eMail2);
        typeIn(password, "lozinka123!");
        typeIn(confirmPassword, "lozinka123!");
        clickOnElement(genderPick);
        clickOnElement(confirmRegisterButton);

        String actualText = getTextFromElement(expectedText);
        System.out.println(actualText);

        String expectedText = "Your registration completed";

        //  Assert.assertEquals(actualText, expectedText, "Test pao, tekst nije isti!");

        if (actualText.equals(expectedText)) {
            System.out.println("Test ok, tekst je isti.");
        } else {
            System.out.println("Test pao, tekst nije isti!");
        }
        //  Assert.assertNotEquals(actualText, expectedText, "Test pao, tekst nije isti!");

        System.out.println("Ocekivani tekst: " + expectedText);
        System.out.println("Dobijeni tekst: " + actualText);


    }


    @Test
    public void continueButtonColor() throws InterruptedException {
        clickOnElement(registerButton);
        Thread.sleep(3000);

        clickOnElement(genderPick);
        typeIn(firstName, "Pera");
        typeIn(lastName, "Peric");
        typeIn(eMail, "PeraPeric141@gmail.com");
        typeIn(password, "lozinka123!");
        typeIn(confirmPassword, "lozinka123!");
        clickOnElement(genderPick);
        clickOnElement(confirmRegisterButton);

        Thread.sleep(3000);
        //clickOnElement(continueButton);

        String continueButtonColor = getColorFromElement(continueButton, "color");

        String expectedContinueButtonColor = "rgba(110, 110, 110, 2)";

        if (continueButtonColor.equals(expectedContinueButtonColor)) {
            System.out.println("Test ok boja se poklapa.");
        } else {
            System.out.println("Test pao, boja se ne poklapa!");
        }

        System.out.println("Button color: " + continueButtonColor);
        System.out.println("Button expected color: " + expectedContinueButtonColor);


    }

    @Test
    public void testRandom() throws InterruptedException {


        String eMail2 = Utils.generateRandomEmail();


        clickOnElement(registerButton);

        clickOnElement(genderPick);
        typeIn(firstName, "Pera");
        typeIn(lastName, "Peric");
        //  typeIn(eMail, "PeraPeric192@gmail.com");
        typeIn(eMail, eMail2);
        typeIn(password, "lozinka123!");
        typeIn(confirmPassword, "lozinka123!");
        clickOnElement(genderPick);
        clickOnElement(confirmRegisterButton);

        String actualText2 = getTextFromElement(expectedText);
        String expectedText = "Your registration completed";


        softAssert.assertEquals(actualText2, expectedText);


        // boolean isElementPresent = getElement(continueButton).isDisplayed();
        softAssert.assertTrue(isElementVisible(continueButton), "Continue button is not present!");


        softAssert.assertAll();


    }
}

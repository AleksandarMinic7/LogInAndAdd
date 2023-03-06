import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngTest {

    @BeforeClass
    public void setupClassLevel () {

        System.out.println("Pre svih metoda samo jednom.");
    }

    @BeforeMethod
    public void setup () {

        System.out.println("Pre svake metode.");
    }


    @Test
    public void test1(){

        System.out.println("Test 1.");
    }

    @Test
    public void test2(){

        System.out.println("Test 2.");
    }

    @Test
    public void test3(){

        System.out.println("Test 3.");
    }




    @AfterMethod
    public void tearDown() {

        System.out.println("Nakon svake metode.");
    }





}

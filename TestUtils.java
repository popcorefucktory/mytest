import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * Created by ki on 14.07.2016.
 */
public class TestUtils {

    public static void scroll(AndroidDriver driver) throws InterruptedException {

        Dimension size = driver.manage().window().getSize();
        int xstart = (int) (size.height * 0.60);
        int xend = (int) (size.height * 0.30);
        int z = size.width / 2;

        driver.swipe(z, xstart, z, xend, 400);
    }
}

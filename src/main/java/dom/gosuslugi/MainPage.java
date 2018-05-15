package dom.gosuslugi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    String mapbutton = "body > div.page-wrapper.page-wrapper_v2.ng-scope > div:nth-child(6) > div > div > page-scroll-watcher > div > div:nth-child(1) > div.col-xs-4 > div > e-services > div > div.e-services__body > div > ul:nth-child(2) > li:nth-child(2) > a";

    public MapPage goToMap() {
        driver.get("https://dom.gosuslugi.ru/#!/main");
        driver.findElement(By.cssSelector(mapbutton)).click();
        return new MapPage(driver);
    }
}

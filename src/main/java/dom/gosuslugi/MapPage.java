package dom.gosuslugi;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MapPage {

    WebDriver driver;

    public MapPage(WebDriver driver) {
        this.driver = driver;
    }

    String pageHeader = "h1.ng-binding";
    String findHome = "body > div.page-wrapper.page-wrapper_v2.ng-scope > div:nth-child(7) > div > div > div.app-map > div.app-map-header > div > div > div.col-md-2 > span:nth-child(1)";
    String findButtonSelector = "button.btn.btn-default";

    String inputFormSelector = "input.form-control.ng-valid.clearable.ng-dirty";
    String show = "span.show-home";

    String searchFieldSelector = "body > div.page-wrapper.page-wrapper_v2.ng-scope > div:nth-child(7) > div > div > div.app-map > div.app-map-header > div > div > div.col-md-10 > form.form-inline.find-by-address.form-base.ng-pristine.ng-valid > div.form-group > div > input";
    String checkBox1 = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[3]/label/input";
    String checkBox2 = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[4]/label/input";
    String checkBox3 = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[5]/label/input";
    String checkBox4 = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[6]/label/input";
    String checkBox5 = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[7]/label/input";

    String houseSelector = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[3]/label/span";
    String oumkdSelector = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[4]/label/span";
    String roSelector = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[5]/label/span";
    String omsSelector = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[6]/label/span";
    String reestrHouseSelector = "/html/body/div[2]/div[6]/div/div/div[2]/div[1]/div/div/div[2]/form[1]/div[7]/label/span";

    String searchResultElem = "ul.list-unstyled.list-type-0";




    // WebElement searchField = driver.findElement(By.cssSelector(searchFieldSelector));

   // WebElement checkboxFirst = driver.findElement(By.cssSelector(checkBox1));


    public String getHeader() {
        return driver.findElement(By.cssSelector(pageHeader)).getText();
    }

    public String getFindHome() {
        return driver.findElement(By.cssSelector(findHome)).getText();
    }

    public boolean findBlockIsPresent() {
        try {
            driver.findElement(By.cssSelector(searchFieldSelector));
            driver.findElement(By.cssSelector(findButtonSelector));
            driver.findElement(By.cssSelector(findHome));
            driver.findElement(By.cssSelector(show));
            driver.findElement(By.xpath(checkBox1));
            driver.findElement(By.xpath(checkBox2));
            driver.findElement(By.xpath(checkBox3));
            driver.findElement(By.xpath(checkBox4));
            driver.findElement(By.xpath(checkBox5));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }


    public boolean isCheckboxOnetPresent() {
        try {driver.findElement(By.xpath(checkBox1));
        }
        catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public boolean checkBox1Selected() {

        boolean enabled = driver.findElement(By.xpath(checkBox1)).isSelected();

        if(enabled == false){
            return false;
        }
        else return true;
    }

    public String houseGetName() {
       return driver.findElement(By.xpath(houseSelector)).getText();
    }
    public String oumkdGetName() {
       return driver.findElement(By.xpath(oumkdSelector)).getText();
    }
    public String roGetName() {
       return driver.findElement(By.xpath(roSelector)).getText();
    }
    public String omsGetName() {
       return driver.findElement(By.xpath(omsSelector)).getText();
    }
    public String reestrHouseGetName() {
       return driver.findElement(By.xpath(reestrHouseSelector)).getText();
    }

    public boolean searchResultsPresent() {
        List<WebElement> elements = driver.findElements(By.cssSelector(searchResultElem));
        try {
            for (WebElement el : elements) {
                el.findElement(By.xpath("a.ng-binding"));
                el.findElement(By.cssSelector("li.search-company-address.ng-binding.ng-scope"));
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }










    public MapPage clickFourBoxes() {
        driver.findElement(By.xpath(checkBox2)).click();
        driver.findElement(By.xpath(checkBox3)).click();
        driver.findElement(By.xpath(checkBox4)).click();
        driver.findElement(By.xpath(checkBox5)).click();
        return this;
    }

    public MapPage findChe(String text) {
        driver.findElement(By.cssSelector(searchFieldSelector)).sendKeys(text);
        return this;
    }






}

package org.drewandjen.web;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

/**
 * Created by dhite on 12/27/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {

    private static ChromeDriver driver;

    private static final Logger LOG = LoggerFactory.getLogger(SeleniumTest.class);

    private final String itemName = "Rye Bread";

    @BeforeClass
    public static void openBrowser(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments(Arrays.asList("--start-maximized", "allow-running-insecure-content", "ignore-certificate-errors"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://localhost:8080");
    }

    @Test
    public void addNewCategory(){
        LOG.info("Adding new category");
        WebElement addCategoryButton = driver.findElement(By.id("add-category"));
        if(!addCategoryButton.isDisplayed()){
            driver.findElement(By.id("add-new-item")).click();
        }
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement addCategoryButtonVis = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("add-category")));
        addCategoryButtonVis.click();
        String newCategoryName = "Baked Goods";
        driver.findElement(By.id("new-category-name")).sendKeys(newCategoryName+"\n");
        WebElement element = driver.findElement(By.xpath("//option[text()='"+newCategoryName+"']"));
        assertNotNull(element);
    }

    @Test
    public void addNewMasterListItem(){
        LOG.info("Adding new master list item");
        WebElement newItemInput = driver.findElement(By.id("new-master-item"));
        if(!newItemInput.isDisplayed()){
            driver.findElement(By.id("add-new-item")).click();
        }
        newItemInput.sendKeys(itemName);
        driver.findElement(By.id("add-item")).click();
        WebElement element = driver.findElement(By.xpath("//td[text()='" + itemName + "']"));
        assertNotNull(element);
    }

    @Test
    public void addNewShoppingList(){
        LOG.info("Adding new shopping list");
        driver.findElement(By.id("show-add-list")).click();
        WebElement input = driver.findElement(By.id("new-shopping-list"));
        String listName = "Wegmans";
        input.sendKeys(listName+"\n");
        WebElement newListElement = driver.findElement(By.xpath("//select[@id='shoppingLists']/option[text()='" + listName + "']"));
        assertNotNull(newListElement);
    }

    @Test
    public void addNewShoppingListItem(){
        LOG.info("Adding new shopping list item");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement itemInMasterList = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='" + itemName + "']")));
        Actions action = new Actions(driver);
        action.doubleClick(itemInMasterList).perform();
        WebElement itemComments = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemComments")));
        String comment = "1 loaf";
        itemComments.sendKeys(comment+"\n");
        WebElement newShoppingListItem = driver.findElement(By.xpath("//label[text()='" + itemName + "  (" + comment + ") ']"));
        assertNotNull(newShoppingListItem);
    }


}

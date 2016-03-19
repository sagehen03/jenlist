package org.drewandjen.web;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by dhite on 12/27/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {

    private static FirefoxDriver driver;

    private static final Logger LOG = LoggerFactory.getLogger(SeleniumTest.class);

    private final String itemName = "Rye Bread";

    private String itemComments = "1 loaf";

    @BeforeClass
    public static void openBrowser(){
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("drew");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login-btn")).click();
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
        while(!driver.findElement(By.id("itemComments")).isDisplayed()){
            action.doubleClick(itemInMasterList).perform();
        }
        WebElement itemComments = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemComments")));
        itemComments.sendKeys(this.itemComments +"\n");
        WebElement newShoppingListItem = driver.findElement(By.xpath("//label[text()='" + itemName + "  (" + this.itemComments + ") ']"));
        assertNotNull(newShoppingListItem);
    }

    @Test
    public void deleteMasterListItem() {
        LOG.info("Deleting master list item");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        String xPathForDeleteMli = "//tbody[@id='master-list-body']/tr[td[text()='" + itemName + "']]/td/a";
        for(int i = 0; i<3 && driver.findElements(By.xpath(xPathForDeleteMli)).size() > 0; i++){
            driver.findElementByXPath(xPathForDeleteMli).click();
        }
        List<WebElement> shouldBeMissing = driver.findElements(By.xpath("//tbody[@id='master-list-body']/tr[td[text()='" + itemName + "']]"));
        assertTrue(shouldBeMissing.size() == 0);
    }

    @Test
    public void deleteShoppingListItem(){
        LOG.info("Deleting shopping list item");
        String xPathForDeleteMli =  "//tbody[@id='shopping-list-body']/tr[td[label[text() = '" +itemName + "  (" + this.itemComments + ") ']]]/td/a";
        for(int i=0; i<3 && driver.findElements(By.xpath(xPathForDeleteMli)).size() > 0; i++){
            driver.findElementByXPath(xPathForDeleteMli).click();
        }
        List<WebElement> shouldBeGone = driver.findElements(By.xpath(xPathForDeleteMli));
        assertTrue(shouldBeGone.size() == 0);
        driver.kill();
    }


}

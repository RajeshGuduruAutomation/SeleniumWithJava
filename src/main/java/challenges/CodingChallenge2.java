package challenges;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

import static java.lang.Thread.sleep;

public class CodingChallenge2 {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static int maxWait = 60;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");

        driver = new ChromeDriver(chromeOptions);
        //driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.get("https://www.noon.com/uae-en/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Map<String, List<String>> listOfItemsMap = new HashMap<>();
        List<String> listOfItems1 = getCarouselItems("Recommended For You");
        listOfItemsMap.put("Recommended For You",listOfItems1);
        List<String> listOfItems2 = getCarouselItems("Save big on mobiles & tablets");
        listOfItemsMap.put("Save big on mobiles & tablets",listOfItems2);
        List<String> listOfItems3 = getCarouselItems("Top picks in electronics");
        listOfItemsMap.put("Top picks in electronics",listOfItems3);
        List<String> listOfItems4 = getCarouselItems("New arrivals");
        listOfItemsMap.put("New arrivals",listOfItems4);
        List<String> listOfItems5 = getCarouselItems("Home & kitchen essentials");
        listOfItemsMap.put("Home & kitchen essentials",listOfItems5);
        List<String> listOfItems6 = getCarouselItems("Top picks in laptops");
        listOfItemsMap.put("Top picks in laptops",listOfItems6);
        List<String> listOfItems7 = getCarouselItems("Limited time offers");
        listOfItemsMap.put("Limited time offers",listOfItems7);

        for (String item : listOfItemsMap.keySet()) {
            System.out.println("==============================List of items for ::"+item);
            listOfItemsMap.get(item).forEach(System.out::println);
        }

        quitDriver();
    }

    public static List<String> getCarouselItems(String itemName) throws InterruptedException {
        waitForPageToLoad();
        //List<WebElement> webElementList = driver.findElements(By.xpath("//*[text()='"+itemName+"']/parent::div/parent::div/following-sibling::div//div[@data-qa='product-name']/div"));
        List<WebElement> webElementList = waitForElementPresent("//*[text()='"+itemName+"']/parent::div/parent::div/following-sibling::div//div[@data-qa='product-name']/div");

        if(webElementList.size() == 0) {
            while(true) {
                String prevHeight = js.executeScript(" return window.scrollY").toString();
                js.executeScript("window.scrollBy(0,1000)");
                String currentHeight = js.executeScript(" return window.scrollY").toString();
                waitForPageToLoad();
                if(prevHeight == currentHeight) {
                    System.out.println("Reached end of page and webElementList size is : "+webElementList.size() + " for item :"+itemName);
                    break;
                }
                webElementList =
                        waitForElementPresent("//*[text()='"+itemName+"']/parent::div/parent::div/following-sibling::div//div[@data-qa='product-name']/div");

                if(webElementList.size() > 0) {
                    System.out.println("Initial webElements size is "+0+" and current size is : "+webElementList.size() + " for item : '"+itemName+"' after scrolling down by "+currentHeight+ "pixels");
                    break;
                }
            }
        }
        long count = 0;
        String  eleText;
        List<String> listOfItems = new ArrayList<>();
        for (WebElement element : webElementList) {
            WebElement nextButtonEle = driver.findElement(By.xpath("//*[text()='"+itemName+"']/parent::div/parent::div/following-sibling::div//div[@data-qa='product-name']/ancestor::div[@class='swiper-container swiper-container-initialized swiper-container-horizontal']/following-sibling::div[contains(@class,'swiper-button-next')]"));
            boolean elementDisplay = element.isDisplayed();
            boolean nextButtonElementDisplay = nextButtonEle.isDisplayed();
            while(true)  {
                if (!nextButtonElementDisplay && !elementDisplay) break;
                eleText = element.getText();
                if(!eleText.equals("")) {
                    listOfItems.add(eleText);
                    count = count + 1;
                } else if(eleText.equals("") && nextButtonElementDisplay){
                    js.executeScript("arguments[0].scrollIntoView(true);", nextButtonEle);
                    /*Actions actions = new Actions(driver);
                    actions.click(nextButtonEle).build().perform();*/
                    js.executeScript("arguments[0].click();", nextButtonEle);
                    //nextButtonEle.click();
                    sleep(500);
                    listOfItems.add(element.getText());
                    count = count + 1;
                }
                break;
            }
        }
        System.out.println("Total items count is "+listOfItems.size()+" for : '"+itemName+"'");
        Collections.sort(listOfItems); // Sort list of items
        return listOfItems;
    }

    public static void waitForPageToLoad() throws InterruptedException {
        boolean isPageReady = (boolean) js.executeScript("return document.readyState == \"complete\"");
        int seconds = LocalDateTime.now().getSecond();
        while (true) {
            if(!isPageReady) {
                sleep(500);
                isPageReady = (boolean) js.executeScript("return document.readyState == \"complete\"");
                int currentTimeInSeconds = LocalDateTime.now().getSecond();
                if (currentTimeInSeconds - seconds > maxWait) {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public static List<WebElement> waitForElementPresent(String element) {
        Wait webDriverWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(maxWait))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        List<WebElement> elements = (List<WebElement>) webDriverWait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(By.xpath(element));
            }
        });
        return  elements;
    }
    public static void quitDriver() {
        if(driver != null){
            driver.quit();
        }
    }
}

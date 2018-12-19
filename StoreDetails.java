package namkiManggo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.gson.Gson;

public class StoreDetails {
	public static StoreInfoDTO storedetails(String link) {

		// category : 한식, 분식, 양식, 세계음식, 뷔페, 디저트, 카페, 술집, 치킨, 브런치, 이탈리안

		String surl = link;
		String chromedriverpath = "C:\\\\chromedriver\\chromedriver.exe";

		/*
		 * System.setProperty("webdriver.chrome.driver", chromedriverpath); WebDriver
		 * driver = new ChromeDriver(); driver.get(surl);
		 */

		// chromeheadless
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get(surl);

		String img = driver.findElement(By.cssSelector(".contents>.restaurant-photos .owl-item>figure.list-photo>meta"))
				.getAttribute("content");
		String name = driver.findElement(By.cssSelector(
				".contents>.column-wrapper>.column-contents .restaurant-detail .restaurant_title_wrap>.title>h1.restaurant_name"))
				.getText();
		List<WebElement> infotable = driver.findElements(
				By.cssSelector(".contents>.column-wrapper>.column-contents .restaurant-detail>table.info>tbody>tr"));
		String addr = infotable.get(0).getText();
		String tel = infotable.get(1).getText();
		String price = infotable.get(3).getText();
		String openinghours = infotable.get(5).getText();
		StoreInfoDTO store = new StoreInfoDTO(img, name, addr, tel, price, openinghours);

		driver.quit();
		return store;
	}

//	public static void main(String[] args) {
//		System.out.println(storedetails("https://www.mangoplate.com/restaurants/0Vq0bf1rZJLZ"));
//
//	}
}

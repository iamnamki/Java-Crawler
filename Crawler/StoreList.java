package namkiManggo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.gson.Gson;

public class StoreList {

	public static List<StoreInfoDTO> makestorelist(String location, String category)
			throws UnsupportedEncodingException, InterruptedException {

		// https://www.mangoplate.com/search/서초-한식
		// category : 한식, 분식, 양식, 세계음식, 뷔페, 디저트, 카페, 술집, 치킨, 브런치, 이탈리안

		String surl = "https://www.mangoplate.com/search/" + location + "-" + category;
		String chromedriverpath = "C:\\\\chromedriver\\chromedriver.exe";
		List<StoreInfoDTO> storelist = new ArrayList<StoreInfoDTO>();

		/*
		 * chrome System.setProperty("webdriver.chrome.driver", chromedriverpath);
		 * WebDriver driver = new ChromeDriver(); driver.get(surl);
		 */

		// chromeheadless
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get(surl);

		List<WebElement> stores = driver
				.findElements(By.cssSelector(".list-restaurants .list-restaurant-item>.restaurant-item"));

		for (WebElement store : stores) {
			// 이미지, 이름, 평점, 위치, 링크
			try {
//				System.out.println(
//						"이미지 : " + store.findElement(By.cssSelector("div.thumb>img")).getAttribute("data-original"));
//				System.out.println(
//						"링크 : " + store.findElement(By.cssSelector("figcaption>div.info>a")).getAttribute("href"));
//				System.out.println(
//						"상호명 : " + store.findElement(By.cssSelector("figcaption>div.info>a>h2.title")).getText());
				String img = store.findElement(By.cssSelector("div.thumb>img")).getAttribute("data-original");
				String link = store.findElement(By.cssSelector("figcaption>div.info>a")).getAttribute("href");
				String name = store.findElement(By.cssSelector("div.info h2.title")).getText();
				storelist.add(new StoreInfoDTO(img, category, name, link));
			} catch (Exception e) {
				driver.quit();
				return storelist;

			}
		}
		driver.quit();
		return storelist;
	}

	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		String location = "서초";
		String category = "한식";
		List<StoreInfoDTO> storelist = makestorelist(location, category);

		// 객체list
		for (StoreInfoDTO s : storelist) {
			System.out.println(s);
		}

		// json형식으로 만들기
		Gson gson = new Gson();
		for (StoreInfoDTO s : storelist) {
			String jstore = gson.toJson(s);
			System.out.println("json : " + jstore);
		}
	}

}

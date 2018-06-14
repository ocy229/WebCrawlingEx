package webCrawling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCrawling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/dev2/chromedriver.exe");
		String url = "https://google.com";
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("쥬라기월드cgv\n");

		driver.findElement(By.linkText("[쥬라기 월드: 폴른 킹덤]<영화상세 < 영화 | 영화 그 이상의 감동. CGV")).click();
		
		WebElement title = driver.findElement(By.xpath("//div[@class='title']"));
		WebElement summaryEl = driver.findElement(By.xpath("//div[@class='sect-story-movie']"));
		WebElement spec = driver.findElement(By.xpath("//div[@class='spec']"));
		System.out.println("Title\n" + title.getText());
		System.out.println("===============================================================");
		System.out.println("Information\n" + spec.getText());
		System.out.println("===============================================================");
		System.out.println("Summary\n" + summaryEl.getText());
		System.out.println("===============================================================");
		System.out.println("=============================REVIEW============================");
		System.out.println("===============================================================\n");
		//driver.findElement(By.linkText("추천순")).click();
		
		for (int i = 1; i < 6; i++) {
			WebElement we = driver.findElement(By.linkText(Integer.toString(i)));
			we.click();
			
			Thread.sleep(800);
			
			WebElement list = driver.findElement(By.xpath("//div[@class='wrap-persongrade']/ul"));
			List<WebElement> reviews = list.findElements(By.xpath("//li/div[@class='box-comment']"));
			List<WebElement> reviews2 = list.findElements(By.xpath("//li/div[@class='box-contents']"
					+ "/ul/li/a[@class='commentMore']"));
			for (int j = 0; j < reviews.size(); j++) {
				System.out.print(reviews2.get(j).getText() + "  :  '");
				System.out.println(reviews.get(j).getText() + " '");
			}
		}

		//driver.quit();

	}

}

package Week4Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionAmazon 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--disable-notifications");	
		ChromeDriver driver=new ChromeDriver(cp);
		
		// TO MAXIMIZE THE WINDOW
		driver.manage().window().maximize();
		
		//IMPLICIT WAIT
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//TO LOAD THE URL
		driver.get("https://www.amazon.in/");
		
		//to search for one plus 9 pro
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		action.click(element).perform();
		element.sendKeys("One Plus 9 Pro",Keys.ENTER);
		
		//to get the price of the 1st displayed product
		WebElement element2 = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String Price = element2.getText();
		System.out.println("Price of the 1st dispalyed product "+Price);
		
		//to Print the number of customer ratings for the first displayed product
		WebElement element3 = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']"));
		String count = element3.getText();
		System.out.println("Number of customer ratings for the first displayed product "+count);
		
		//Click the first text link of the first image.
		WebElement element4 = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		action.click(element4).perform();
		
		//handle windows
		Set<String> pw = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(pw);
		driver.switchTo().window(window.get(1));
		
		//to Take a screenshot of the product displayed
		WebElement element5 = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']"));
		File scr = element5.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapshot/phone.png");
		FileUtils.copyFile(scr, dest);
		Thread.sleep(3000);
		//to Click the 'Add to Cart' button
		WebElement element6 = driver.findElement(By.id("add-to-cart-button"));
		action.click(element6).perform();
		Thread.sleep(3000);
		//to Get the cart subtotal and verify if it is correct.
		WebElement element7 = driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price')]//span[1]"));		
		String subtotal = element7.getText();
		System.out.println("The cart subtotal "+subtotal);
		
		if(subtotal.contains(Price))
		{
			System.out.println("Price and Subtotal are same");
		}
		else
		{
			System.out.println("Price and Subtotal are not same");
		}
		
		driver.close();
		driver.switchTo().window(window.get(0));
		driver.quit();
		
	}

}

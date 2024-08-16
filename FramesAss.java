package Week4Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FramesAss 
{

	public static void main(String[] args) 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		
		// Launch ServiceNow application
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        //switch to frame
        driver.switchTo().frame("iframeResult");
		
        //click try button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//switch to alert
		Alert alert = driver.switchTo().alert();
				
		String text=alert.getText();
		
		System.out.println(text);
		
		alert.sendKeys("Thangamani");
		
		alert.accept();
		
		WebElement element = driver.findElement(By.xpath("//p[@id='demo']"));
		String msg = element.getText();
		System.out.println(msg);

	}

}

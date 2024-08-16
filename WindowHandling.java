package Week4Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling
{

	public static void main(String[] args) 
	{
		ChromeDriver driver=new ChromeDriver();
		
		// TO MAXIMIZE THE WINDOW
		driver.manage().window().maximize();
		
		//IMPLICIT WAIT
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//TO LOAD THE URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//TO ENTER USER ID
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//TO ENTER PASSWORD
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//TO PRESS LOGIN BUTTON
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//TO PRESS CRMSFA TEXT
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//to click contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//to click merge contact
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		
		//to click on the widget of the "Form Contact"
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		//switch window
		Set<String> pw = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(pw);
		driver.switchTo().window(window.get(1));
		
		
		//to click on the 1st resulting contact
		driver.findElement(By.xpath("//div[contains(@class,'grid3-col-partyId')]/a")).click();
		
		driver.switchTo().window(window.get(0));
		
		//to click on the widget of the "to Contact"
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		Set<String> pw1 = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(pw1);
		driver.switchTo().window(window1.get(1));
		
		driver.findElement(By.xpath("(//div[contains(@class,'grid3-col-partyId')]/a)[2]")).click();
		
		driver.switchTo().window(window1.get(0));
		
		driver.findElement(By.linkText("Merge")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println("Title of the Page "+title);
		
		
	}

}

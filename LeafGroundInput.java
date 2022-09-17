package selenium.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
	
public class LeafGroundInput {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Type your name
		driver.findElement(By.xpath("//input[@id='j_idt88:name']")).sendKeys("Gomathy Shri");
		//Append Country to this City
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']")).sendKeys(",India");
		boolean enabled = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt93']")).isEnabled();
		if (enabled == false) {
			System.out.println("Textbox is disabled");	
		}
		else
		{
			System.out.println("Textbox is enabled");
		}
		//Clear the typed text
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();
		//Retrive Typed Text
		String text = driver.findElement(By.xpath("//input[@value='My learning is superb so far.']")).getAttribute("Value");
		System.out.println(text);
		Thread.sleep(10000);
		//Type Email and Tab confirm contrl moved to next element
		
		WebElement emailElement = driver.findElement(By.xpath("(//h5[contains(text(),'Type email and Tab')]/following::input)[1]"));
		emailElement.click();
		emailElement.sendKeys("gomathyshri.v19@gmail.com", Keys.ENTER);
		
		
//		WebElement activeElement = driver.switchTo().activeElement();
//		String attribute3 = activeElement.getAttribute("placeholder");
//		if (attribute3.contains("About yourself:")) {
//			System.out.println("control moved to next element.");
//		} else {
//			System.out.println("control not moved to next element.");
//
//		}
		
		//driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys("gomathyshri.v19@.com");
		
		//driver.findElement(By.xpath("//input[@placeholder='Your email and tab']")).sendKeys(Keys.TAB);
		
		
		//Type about Yourself
		//driver.findElement(By.xpath("//div[@class='grid formgrid']//textarea"));
	
		
		
		//Just Press Enter and confirm error message*
		driver.findElement(By.xpath("//input[@id='j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
		WebElement ErrorMsgWebElement = driver.findElement(By.xpath("//span[@class='ui-message-error-icon']/following-sibling::span"));
		
//		String text = driver.findElement(By.xpath("//span[@class='ui-message-error-icon']/following-sibling::span")).getText();
		
		String ageErrorMsg = ErrorMsgWebElement.getText();
		String str = "Age is mandatory";
		if (ageErrorMsg.equals(str)) {
			System.out.println("Error Message is printed");
		}
		
//		driver.findElement(By.xpath("//input[@id='j_idt106:float-input']")).click();
//		
		
//		//Confirm that label position changes
		WebElement oldLabel = driver.findElement(By.xpath("//label[text()='Username']"));
		org.openqa.selenium.Point location = oldLabel.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println(x);
		System.out.println(y);
//		//driver.findElement(By.xpath("//label[text()='Username']")).click();
		
		driver.findElement(By.xpath("//input[@id='j_idt106:float-input']")).click();
		WebElement newLabel = driver.findElement(By.xpath("//label[text()='Username']"));
		org.openqa.selenium.Point location2 = newLabel.getLocation();
		int x1 = location2.getX();
		int y1 = location2.getY();
		System.out.println(x1);
		System.out.println(y1);
		
	}

}

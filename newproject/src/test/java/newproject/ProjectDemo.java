package newproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectDemo {

	public static void main(String[] args) throws InterruptedException {
		// STEP 1: CREATE THE ACCOUNT
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://127.0.0.1:8000/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//maximize the window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//create new account
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		
		WebElement customerName = driver.findElement(By.xpath("//body/form[@id='take-input']/div[1]/div[1]/input[1]"));
		WebElement customerEmail = driver.findElement(By.xpath("//body/form[@id='take-input']/div[1]/div[2]/input[1]"));
		WebElement customerNumber = driver.findElement(By.xpath("//body/form[@id='take-input']/div[2]/div[1]/input[1]"));
		WebElement customerAddress = driver.findElement(By.xpath("//body/form[@id='take-input']/div[2]/div[2]/input[1]"));
		WebElement customerPassword = driver.findElement(By.xpath("//body/form[@id='take-input']/div[3]/div[1]/input[1]"));
		WebElement customerConfirmPassword = driver.findElement(By.xpath("//body/form[@id='take-input']/div[3]/div[2]/input[1]"));
		
		customerName.sendKeys("tom");Thread.sleep(2000);
		customerEmail.sendKeys("th@g.com");Thread.sleep(2000);
		customerNumber.sendKeys("8584699112");Thread.sleep(2000);
		customerAddress.sendKeys("hollywood bel air");Thread.sleep(2000);
		customerPassword.sendKeys("spidey");Thread.sleep(2000);
		customerConfirmPassword.sendKeys("spidey");Thread.sleep(2000);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body/form[@id='take-input']/button[1]")).click();
		Thread.sleep(3000);
		
		
		//STEP 2: FAIL LOGIN
		WebElement loginEmail = driver.findElement(By.xpath("//body/form[@id='login-form']/input[1]"));
		WebElement loginPassword = driver.findElement(By.xpath("//body/form[@id='login-form']/input[2]"));
		
		loginEmail.sendKeys("th@g.com");Thread.sleep(2000);
		loginPassword.sendKeys("spideyS");Thread.sleep(2000);
		
		//press login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"retry-login\"]")).click();
		//driver.switchTo( ).alert( ).accept();
		Thread.sleep(3000);
		
		
		//STEP 3: PASS LOGIN
		loginEmail = driver.findElement(By.xpath("//body/form[@id='login-form']/input[1]"));
		loginPassword = driver.findElement(By.xpath("//body/form[@id='login-form']/input[2]"));
		
		loginEmail.sendKeys("th@g.com");Thread.sleep(2000);
		loginPassword.sendKeys("spidey");Thread.sleep(2000);
		
		//press login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String home = driver.getCurrentUrl();
		Thread.sleep(3000);
		
		//STEP 4: PURCHASE GOLD
		WebElement goldEmail = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[1]"));
		WebElement goldMoney = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[3]"));
		WebElement goldPassword = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[2]"));
		
		//passing case
		goldEmail.sendKeys("th@g.com");Thread.sleep(2000);
		goldPassword.sendKeys("kkl");Thread.sleep(2000);
		goldMoney.sendKeys("2");Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Purchase Gold')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		//driver.get(home);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[1]")));
		
		goldEmail = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[1]"));
		goldMoney = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[3]"));
		goldPassword = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[2]"));
		
		//failing case 1 exceed the amount
		goldEmail.sendKeys("th@g.com");Thread.sleep(2000);
		goldPassword.sendKeys("kkl");Thread.sleep(2000);
		goldMoney.sendKeys("150");Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Purchase Gold')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='remove-err-disp']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		goldEmail = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[1]"));
		goldMoney = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[3]"));
		goldPassword = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[1]/form[1]/input[2]"));
		
		//failing case 2 negative value
		goldEmail.sendKeys("th@g.com");Thread.sleep(2000);
		goldPassword.sendKeys("kkl");Thread.sleep(2000);
		goldMoney.sendKeys("-5");Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Purchase Gold')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='remove-err-disp']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		//STEP 5: TRANSFER MONEY
		
		WebDriver driver2 = new ChromeDriver();
		driver2.get("http://127.0.0.1:8000/");
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//maximize the window
		driver2.manage().window().maximize();
		Thread.sleep(3000);
		
		loginEmail = driver2.findElement(By.xpath("//body/form[@id='login-form']/input[1]"));
		loginPassword = driver2.findElement(By.xpath("//body/form[@id='login-form']/input[2]"));
		
		loginEmail.sendKeys("s@g.com");Thread.sleep(2000);
		loginPassword.sendKeys("kkl");Thread.sleep(2000);
		
		//press login button
		driver2.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver2.close();
		
		//transfer money
		WebElement transferName = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[2]/form[1]/input[1]"));
		WebElement transferEmail = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[2]/form[1]/input[2]"));
		WebElement transferAmount = driver.findElement(By.xpath("//body/section[@id='user-area']/main[1]/div[2]/form[1]/input[3]"));
		transferName.sendKeys("Soumyadeep");Thread.sleep(2000);
		transferEmail.sendKeys("s@g.com");Thread.sleep(2000);
		transferAmount.sendKeys("2");Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Send Money')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		WebDriver driver3 = new ChromeDriver();
		driver3.get("http://127.0.0.1:8000/");
		driver3.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//maximize the window
		driver3.manage().window().maximize();
		Thread.sleep(3000);
		
		loginEmail = driver3.findElement(By.xpath("//body/form[@id='login-form']/input[1]"));
		loginPassword = driver3.findElement(By.xpath("//body/form[@id='login-form']/input[2]"));
		
		loginEmail.sendKeys("s@g.com");Thread.sleep(2000);
		loginPassword.sendKeys("kkl");Thread.sleep(2000);
		
		//press login button
		driver3.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver3.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver3.close();
		Thread.sleep(5000);
		
		//STEP 6: TRANSACTION HISTORY
		driver.findElement(By.xpath("//span[contains(text(),'Transaction history')]")).click();Thread.sleep(5000);
		driver.navigate().back();Thread.sleep(3000);
		
		
		//STEP 7: REVIEW US
		driver.findElement(By.xpath("//button[contains(text(),'Review us')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		Select dropReview = new Select(driver.findElement(By.xpath("//select[@id='satisfaction']")));
		driver.findElement(By.xpath("//select[@id='satisfaction']")).click();Thread.sleep(2000);
		dropReview.selectByVisibleText("Good");Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='satisfaction']")).click();Thread.sleep(1000);
		
		WebElement recommend = driver.findElement(By.xpath("//input[@id='true']"));
		recommend.click();Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.get(home);
		Thread.sleep(3000);
		
		//STEP 8: LINK GOOGLE ACCOUNT
		driver.findElement(By.xpath("//span[contains(text(),'Link google account')]")).click();
		Thread.sleep(2000);
		driver.switchTo( ).alert( ).accept();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.navigate().back();Thread.sleep(3000);

		
		//STEP 9: LOG OUT
		driver.findElement(By.xpath("//a[@id='log-out']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='no-2']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='log-out']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//body/section[@id='user-area']/aside[1]/ul[1]/li[4]/div[1]/a[1]")).click();Thread.sleep(2000);
		
		
		//STEP 10: DELETE ACCOUNT
		loginEmail = driver.findElement(By.xpath("//body/form[@id='login-form']/input[1]"));
		loginPassword = driver.findElement(By.xpath("//body/form[@id='login-form']/input[2]"));
		
		loginEmail.sendKeys("th@g.com");Thread.sleep(2000);
		loginPassword.sendKeys("spidey");Thread.sleep(2000);
		
		//press login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Delete Account')]")).click();Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='no-1']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Delete Account')]")).click();Thread.sleep(3000);
		driver.findElement(By.xpath("//body/section[@id='user-area']/aside[1]/ul[1]/li[2]/div[1]/a[1]")).click();Thread.sleep(2000);
		driver.close();
	}

}

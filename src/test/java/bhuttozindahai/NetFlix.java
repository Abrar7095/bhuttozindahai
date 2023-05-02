package bhuttozindahai;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test
public class NetFlix {

	WebDriver driver;
    
    @BeforeTest
	public void LaunchBrowser() throws InterruptedException {
	System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver_win32/chromedriver.exe");		
	ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");     
       options.addArguments("--disable-web-security");          
       driver = new ChromeDriver(options);	
	           // maximizing the window
         driver.manage().window().maximize();
       //check Internet connectivity 
 		try {
 	         URL url = new URL("http://www.google.com");
 	         URLConnection connection = url.openConnection();
 	         connection.connect();
 	         System.out.println("Internet is connected");
 	      } catch (MalformedURLException e) {
 	         System.out.println("Internet is not connected");
 	      } catch (IOException e) {
 	         System.out.println("Internet is not connected");
 	      }
 		 
         driver.get("https://www.netflix.com/pk/");
              Thread.sleep(4000);
	
           // validation on login page
          	boolean LoginPage =driver.findElement(By.xpath("//*[@class='default-ltr-cache-mv4tc2']")).isDisplayed();
                   if(LoginPage) {
                  	 System.out.println("Login page showing on display screen");
                   }else {
                  	 System.out.println("login page is not showing on display on screen");
                   }	   
                   Thread.sleep(5000);
    }
    
    @Test
    public void loginfunctionality() throws InterruptedException {
    // validate  on sign in button
    boolean button = driver.findElement(By.xpath("//*[@data-uia=\"header-login-link\"]")).isDisplayed();
    if(button) {
    	System.out.println("sign in button is displayed");
    }else {
    	System .out.println("sign in button is not displayed");
    }
      
    Thread.sleep(5000);
    
    // click on sign in button
    driver.findElement(By.xpath("//*[@data-uia=\"header-login-link\"]")).click();
    
    // validate on sign up link text
    try {
          Thread.sleep(5000);
    	if( driver.findElement(By.xpath("//*[text()='Sign up now']")).isDisplayed())
    	{
    		System.out.println("sign up link text is displayed on screen");
    	}else
    		System.out.println("sign up link text is not displayed on screen");
    }catch (Exception e) {
         System.out.println("Sign up is displayed on screen");
    }
    Thread.sleep(5000);
    // click on sign up 
    driver.findElement(By.xpath("//*[text()='Sign up now']")).click();
    // find email text box
    Thread.sleep(5000);
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div[3]/div/div/form/div/div/div[1]/input")).sendKeys("codedsk014@gmail.com");
    // click on get started button
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div[3]/div/div/form/div/button")).click();
    
    // validation on next page
    Thread.sleep(7000);
    boolean nextpage = driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div[2]/div/form/div/div[1]/div/h1/span")).isDisplayed();
    if(nextpage) {
    	System .out.println("user is on next page");
    }else {
    	System.out.println("user is not on next page");
    }
    Thread.sleep(5000);
    
    // Enter password
    driver.findElement(By.xpath("//*[@id='id_password']")).sendKeys("abrar7095");
    Thread.sleep(7000);
    // click on Next button
    driver.findElement(By.xpath("//*[text()='Next']")).click();
    Thread.sleep(5000);
    // validation on next page
   boolean nextpage2 = driver.findElement(By.xpath("//*[text()='Choose your plan.']")).isDisplayed();
   if (nextpage2) {
	   System.out.println("page is display on screen");
   }else {
	   System.out.println("page is not display on screen");
   }
   Thread.sleep(5000);
   // click on next page button
   driver.findElement(By.xpath("//*[text()='Next']")).click();
   Thread.sleep(5000); 
   // validation on next page
   boolean nextpage3 = driver.findElement(By.xpath("//*[text()='Choose the plan that’s right for you']")).isDisplayed();
   if (nextpage2) {
	   System.out.println("page is display on screen");
   }else {
	   System.out.println("page is not display on screen");
   }
   Thread.sleep(5000);
   // Click on Next button 
   driver.findElement(By.xpath("//*[text()='Next']")).click();
   Thread.sleep(3000);
   
   // click on signout button
    driver.findElement(By.xpath("//*[text()='Sign Out']")).click();
    }
    
  
    @Test
    public void signin() throws InterruptedException {
    // click on signin button
    	driver.findElement(By.xpath("//*[@data-uia=\"header-login-link\"]")).click();
    	Thread.sleep(3000);
    	// Enter Email
    	driver.findElement(By.xpath("//*[@data-uia=\"login-field\"]")).sendKeys("codedsk014@gmail.com");
    	Thread.sleep(3000);
    	//Enter password
    	driver.findElement(By.xpath("//*[@data-uia=\"password-field\"]")).sendKeys("abrar7095");
    	Thread.sleep(3000);
    	// click on submit button
    	driver.findElement(By.xpath("//*[@type='submit']")).click();
    	
    }
    
    @AfterTest
    public void terminatebrowser() {
    	driver.quit();
    }

	
	
	
}
	
	
	
	
	
	
	
	
	
	


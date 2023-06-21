import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class FirstJavaclass {
	
	  private static ExtentReports extent;
	    private static ExtentTest test;
	    private static ExtentHtmlReporter htmlReporter;
	    

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 // Initialize ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\extent report//extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
		ChromeDriver driver = new ChromeDriver();
	
	
		test = extent.createTest("test1");
//-----------------------------Open any website------------------------------------------------
		driver.get("https://www.google.com/");
		test.log(Status.INFO, "Search google page");
		
//-----------------------------------Find the field--------------------------------------------
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).sendKeys("Facebook");
		test.log(Status.INFO, "Fill the field");
		
//----------------Using arrow down option in the field-----------------------------------------
		WebElement element = driver.findElement(By.id("APjFqb"));
		
		Thread.sleep(2000);
		//element.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		element.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		element.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);

		element.sendKeys(Keys.ENTER);
		
		test.log(Status.INFO, "Down the arrow");
		Thread.sleep(5000);
		
//---------------------------Move down the page------------------------------------------------
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the page by a certain amount of pixels
        js.executeScript("window.scrollBy(0, 250);");
        
        test.log(Status.INFO, "Scroll the page");
        
//----------------------After moving the page select any text----------------------------------
		driver.findElement(By.xpath("/html/body/div[6]/div/div[13]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3")).click();
		
		Thread.sleep(5000);
		
//--------------Enter any value in the field then clear this value-----------------------------

		//Enter the value in the field
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[1]/input")).sendKeys("Ankit Rana");
		
		
		Thread.sleep(3000);
		
		//Clear the value of the field
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[1]/input")).clear();
		
		test.log(Status.INFO, "Fill the field and also clear");
//-----------------------------Close the browser-----------------------------------------------
		
		 extent.flush();
	        driver.close();
	}

}
package insta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class instaMain {
	
	public static WebDriver driver;
	public static boolean found = false;
	public static int x;
	public static String nav;
	public static String priv;
	public static int startValue;

	public static void main(String[] args) throws Exception {
		establishConnection();
		Thread.sleep(1000);
		startProcess();
		waitFor();
	}

	public static void establishConnection() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://www.instagram.com/?hl=en");
	}
	
	public static void startProcess() throws Exception {
		driver.findElement(By.xpath("(//a)[4]")).click();
		WebElement userName = driver.findElement(By.xpath("//input"));
		userName.sendKeys("insta_like_bot0");
		WebElement password = driver.findElement(By.xpath("(//input)[2]"));
		password.sendKeys("!Gamer4!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button)[2]")).click();
		Thread.sleep(2000);
		driver.navigate().to("https://www.instagram.com/accounts/activity/");

	}
	
	public static void waitFor() throws Exception {
		
		while(found == false) {
			driver.navigate().refresh();
				try 
				{
					driver.findElement(By.cssSelector("div.YFq-A"));
					found = true;
					if(found == true) {
						nav = driver.findElement(By.xpath("(//a)[2]")).getText();
						driver.navigate().to("https://www.instagram.com/"+nav+"/");
						checkPriv();
					}
					
					
				}
						catch(Exception e) 
						{
							Thread.sleep(5000);
						}
		}
	}
	
	public static void checkPriv() throws Exception {
		try {
			try {
				priv = driver.findElement(By.xpath("//h2")).getText();
			}
			catch(Exception e) {
				priv = "Not Private";
			}
			System.out.println(priv);
				if(priv.equals("This Account is Private")) {
					driver.findElement(By.xpath("(//button)[2]")).click();
					Thread.sleep(1000*15);
					driver.navigate().refresh();
					System.out.println("test");
					String moveOn = driver.findElement(By.xpath("//button[@class='BY3EC  _0mzm- sqdOP  L3NKy   _8A5w5    ']")).getText();
					System.out.println(moveOn);
						if(moveOn.equals("Following")) {
							startLike();
						}
						else if(moveOn.equals("Requested")) {
							driver.findElement(By.xpath("(//button[@class='dCJp8 afkep _0mzm-'])")).click();
							driver.findElement(By.xpath("(//button[@class='aOOlW   HoLwm '])[2]")).click();
							driver.findElement(By.xpath("(//button[@class='aOOlW  bIiDR  '])")).click();
							driver.findElement(By.xpath("(//button[@class='aOOlW   HoLwm '])")).click();
							driver.findElement(By.xpath("(//button[@class='BY3EC  _0mzm- sqdOP  L3NKy       '])")).click();
							driver.findElement(By.xpath("(//button[@class='aOOlW  bIiDR  '])")).click();
							driver.findElement(By.xpath("(//button[@class='aOOlW   HoLwm '])")).click();
							driver.navigate().to("https://www.instagram.com/accounts/activity/");
							waitFor();
							found = false;
						}
				}
				else if (priv.equals("Not Private")) {
					startLike();
				}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			driver.navigate().to("https://www.instagram.com/accounts/activity/");
			waitFor();
			found = false;
		}
	}
	
	public static void startLike() throws Exception {
		String numPosts = driver.findElement(By.xpath("//span[@class='g47SY ']")).getText();
		for(int t = 3; t < 14; t++) {
			try {
				String ls = driver.findElement(By.xpath("(//a)["+ t +"]")).getAttribute("href");
				System.out.println(ls);
				if(ls.contains("https://www.instagram.com/p/")) {
					startValue = t;
					System.out.println(startValue);
					break;
				}
			}
					catch (Exception e) {
												continue;
						}
		}
		for(int i = 0; i < Integer.valueOf(numPosts); i++) {
			String link = driver.findElement(By.xpath("(//a)["+ String.valueOf(startValue+i) +"]")).getAttribute("href");
			driver.navigate().to(link);
			driver.findElement(By.xpath("(//button[@class='dCJp8 afkep coreSpriteHeartOpen _0mzm-'])")).click();
			driver.navigate().to("https://www.instagram.com/"+nav+"/");
		}
		
				driver.findElement(By.xpath("(//button[@class='dCJp8 afkep _0mzm-'])")).click();
				driver.findElement(By.xpath("(//button[@class='aOOlW   HoLwm '])[2]")).click();
				driver.findElement(By.xpath("(//button[@class='aOOlW  bIiDR  '])")).click();
				driver.findElement(By.xpath("(//button[@class='aOOlW   HoLwm '])")).click();
				Thread.sleep(2000);
			if(priv.equals("Not Private")) {
				
				driver.findElement(By.xpath("(//button[@class='_5f5mN       jIbKX  _6VtSN     yZn4P   '])")).click();
				driver.findElement(By.xpath("(//button[@class='aOOlW  bIiDR  '])")).click();
				driver.findElement(By.xpath("(//button[@class='aOOlW   HoLwm '])")).click();
			}
			else {
				driver.findElement(By.xpath("(//button[@class='BY3EC  _0mzm- sqdOP  L3NKy       '])")).click();
				driver.findElement(By.xpath("(//button[@class='aOOlW  bIiDR  '])")).click();
				driver.findElement(By.xpath("(//button[@class='aOOlW   HoLwm '])")).click();
			}
			restart();
							
			
	}
	public static void restart() throws Exception {
		driver.navigate().to("https://www.instagram.com/accounts/activity/");
		waitFor();
		found = false;
	}
}

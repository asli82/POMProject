package pomDesign;

import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.LoginPage;
import pages.OrderPage;

public class WebOrdersTest {

	WebDriver driver;
	LoginPage loginPage;
	ConfigLoader configLoader; 
	Faker faker;
	OrderPage orderPage;
	Select select;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		//List<> = driver.getWindowHandles();
	}
	
	@Test (priority = 1)
	public void login(){
		ConfigLoader configLoader = new ConfigLoader();
		loginPage = new LoginPage(driver);
		driver.get(configLoader.getMyValue("url"));
		loginPage.username.sendKeys(configLoader.getMyValue("username"));
		loginPage.password.sendKeys(configLoader.getMyValue("password"));
		loginPage.login.click();
	}
	
	@Test (priority = 2)
	public void setUpOrder() {
		loginPage.order.click();
		assertTrue(driver.getPageSource().contains("Order"));
	}
	
	@Test (priority = 3)
	public void fillDocument() {
		faker = new Faker();
		//String name = faker.name().firstName();
		configLoader = new ConfigLoader();
		orderPage = new OrderPage(driver);
		String total;
	
		Set<String> expected = new HashSet();
		
		int numSelect = faker.number().numberBetween(0, 3);
		new Select(orderPage.product).selectByIndex(numSelect);
		
		Random random = new Random();
		String quantity = Integer.toString(random.nextInt(100)+1);
		orderPage.quantity.sendKeys(quantity);
	
		
		orderPage.pricePerPoint.sendKeys(Double.toString(random.nextInt(1000) + 100));
	
		orderPage.discount.sendKeys(Integer.toString(random.nextInt(100) + 1));
		
		orderPage.calculate.click();
		
		//==============================================
		
		String name = faker.name().fullName();
		expected.add(name);
		orderPage.customerName.sendKeys(name);
		
		String street = faker.address().streetName();
		expected.add(street);
		orderPage.street.sendKeys(street);
		
		String city = faker.address().city();
		expected.add(city);
		orderPage.city.sendKeys(city);
		
		String state = faker.address().state();
		expected.add(state);
		orderPage.state.sendKeys(state);
		
		String zip = faker.address().zipCode().substring(0, 5);
		expected.add(zip);
		orderPage.zip.sendKeys(zip);
		
		
		int cardSelect = faker.number().numberBetween(1, 4);
		String card = "";
//		List<WebElement> list = new ArrayList(orderPage.card);
//		int radioNum = list.size();
//		System.out.println(radioNum);
		switch(cardSelect) {
		case 1:
			orderPage.visa.click();
			card = "VISA";
			break;
		case 2:
			orderPage.masterCard.click();
			card = "MasterCard";
			break;
		case 3:
			orderPage.americanExpress.click();	
			card = "American Express";
			break;
		}
		expected.add(card);
		
		String cardNumber = faker.business().creditCardNumber().replaceAll("-", "");
		expected.add(cardNumber);
		orderPage.cardNr.sendKeys(cardNumber);
		
		int m = faker.number().numberBetween(1, 12);
		String month = Integer.toString(m);
		if(m < 10) {
			month = "0" + Integer.toString(m);
		}
		String expDate = month + "/" + faker.number().numberBetween(18, 38);
		expected.add(expDate);
		orderPage.expireDate.sendKeys(expDate);
	
		orderPage.process.click();
		
		orderPage.viewAllOrders.click();
		AllOrdersPage allOrdersPage = new AllOrdersPage(driver);
		Set<String> result = allOrdersPage.getFirstRow(driver);
		
		assertTrue(allOrdersPage.compareSets(expected, result));
		
	} 
	
}

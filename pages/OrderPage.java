package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement product;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
	public WebElement pricePerPoint;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
	public WebElement discount;
	
	@FindBy(xpath = "//input[@class='btn_dark']")
	public WebElement calculate;
	
	//===========================================

	@FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
	public WebElement customerName;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement street;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement city;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement state;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zip;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_cardList")
	public List card;
	
	@FindBy(xpath="//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td")
	public WebElement visa;
	
	@FindBy(xpath="//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td[2]")
	public WebElement masterCard;
	
	@FindBy(xpath="//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td[3]")
	public WebElement americanExpress;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNr;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expireDate;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement process;
	
	@FindBy(xpath = "(//input[@class='btn_dark'])[2]")
	public WebElement reset;
	
	@FindBy(linkText = "View all orders")
	public WebElement viewAllOrders;
	
	
	
	
	
	
	
	
	
}

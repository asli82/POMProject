package pages;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrdersPage {

	public AllOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table[@class='SampleTable']/tbody/tr[2])")
	public WebElement tableRow1;
	
	public Set<String> getFirstRow(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr[2]/td"));
		Set<String> setList = new HashSet();
		for(int i = 0; i < list.size(); i++) {
			setList.add(list.get(i).getText());
		}
		return setList;
	}
	
	public boolean compareSets(Set<String> expected, Set<String> result) {
		boolean bool = false;
		for(String each : expected) {
			if(result.contains(each)) {
				bool = true;
			}else {
				bool = false;
				break;
			}
		}
		return bool;
	}
	
	
	
	
	
}

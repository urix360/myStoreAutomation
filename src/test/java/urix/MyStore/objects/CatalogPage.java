package urix.MyStore.objects;

import java.io.ObjectInputStream.GetField;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends MenuPage{
	
	@FindBy(css = ".category-name")
	WebElement header;
	@FindBy(css = "[title='Return to Home']")
	WebElement homeIcon;
	@FindBy(css = ".lighter")
	WebElement searchTitle;
	@FindBy(css = ".alert.alert-warning")
	WebElement alert;

	public CatalogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getHeader() {
		return header.getText();
	}
	
	public void returnHome() {
		click(homeIcon);
	}
	
	public String getSearchHeader() {
		return searchTitle.getText();
	}
	
	public String getAlert() {
		return alert.getText();
	}
	

}

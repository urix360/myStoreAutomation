package urix.MyStore.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{
	
	@FindBy (css = "#block_top_menu > ul > li:nth-child(3) > a")
	WebElement tshirtBtn;
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2)  li:nth-child(3) a")
	WebElement summerDresses;
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2)")
	WebElement dressesBtn;
	@FindBy(css = "#block_top_menu > ul > li:nth-child(1)")
	WebElement womenBtn;
	@FindBy(css = ".search_query.form-control.ac_input")
	WebElement searchBar;
	@FindBy(css = ".btn.btn-default.button-search")
	WebElement searchBtn;
	@FindBy (css = "#contact-link")
	WebElement contactUsBtn;
	@FindBy (css = "[title='Proceed to checkout']")
	WebElement proccedToCheckoutBtn;
	@FindBy (css = "[title='Continue shopping']")
	WebElement continueShoppingBtn;
	@FindBy (css = "[title='View my shopping cart']")
	WebElement Cart;
	@FindBy (css = "[title='Check out']")
	WebElement checkOutBtn;
	@FindBy (css = ".icon-home")
	WebElement homeBtn;
	@FindBy (css = ".youtube")
	WebElement youtubeBtn;

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	public void openTShirts() {
		click(tshirtBtn);
	}
	
	public void openSummerDresses() {
		actions.moveToElement(dressesBtn).perform();
		this.sleep(500);
		click(summerDresses);
	}
	
	public void openWomen() {
		click(womenBtn);
	}
	
	public void search(String text) {
		fillText(searchBar, text);
		click(searchBtn);
	}
	
	public void clearSearch() {
		searchBar.clear();
	}
	
	public void clickSearch() {
		click(searchBtn);
	}
	public void contactUs() {
		click(contactUsBtn);
	}
	
	public void openCheckout() {
		actions.moveToElement(Cart).perform();
		wait(checkOutBtn);
		click(checkOutBtn);
		
	}
	 public void clickCart() {
		click(Cart);
	}
	 
	 public void clickHome() {
		click(homeBtn);
	}
	 
	 public void clickYoutubeBtn() {
	    click(youtubeBtn);
	 }
	
	
	

}

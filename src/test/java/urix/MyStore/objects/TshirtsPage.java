package urix.MyStore.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TshirtsPage extends CatalogPage{

	@FindBy (css = "div.breadcrumb.clearfix > [title='Tops']")
	WebElement tops;
	@FindBy (css = "#categories_block_left .last")
	WebElement Blouses;
	
	public TshirtsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickTops() {
		click(tops);
	}
	
	public void clickBlouses() {
		click(Blouses);
	}

}

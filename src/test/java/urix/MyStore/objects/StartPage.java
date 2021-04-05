package urix.MyStore.objects;

import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends MenuPage{

	@FindBy(css = "#home-page-tabs > li:nth-child(2) > a")
	WebElement bestSellesrsBtn;
	@FindBy (css = "#home-page-tabs > li.active")
	WebElement bestSellersHighlighted;
	@FindBy (css = ".product_list.grid.row.homefeatured.tab-pane li")
	List<WebElement> productList;
	@FindBy (css = ".product_list.grid.row.homefeatured.tab-pane.active [title='Add to cart']")
	List<WebElement> productsAddButtonsList;
	@FindBy (css = ".product_list.grid.row.homefeatured.tab-pane .product-name")
	List<WebElement> productNamesList;
	public StartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void openBestSellers() {
		click(bestSellesrsBtn);
	}
	public boolean bestSellersIsSelected() {
		return bestSellersHighlighted.isEnabled();
	}
	
	public void addProductToCartByIndex(int index) {
		actions.moveToElement(productList.get(index)).perform();
	    click(productsAddButtonsList.get(index));
		
	}
	
	public void addProductToCartByIndexProceedToCheckout(int index) {
		actions.moveToElement(productList.get(index)).perform();
	    click(productsAddButtonsList.get(index));
	    wait(proccedToCheckoutBtn);
	    click(proccedToCheckoutBtn);
		
	}
	
	public void addProductToCartByIndexContinueShopping(int index) {
		actions.moveToElement(productList.get(index)).perform();
	    click(productsAddButtonsList.get(index));
	    wait(continueShoppingBtn);
	    click(continueShoppingBtn);
	    sleep(500);
	}
	
	public String getProductNameByIndex(int index) {
		System.out.println(productNamesList.get(index).getText()+"<<<<<");
		return productNamesList.get(index).getText();
	}

}

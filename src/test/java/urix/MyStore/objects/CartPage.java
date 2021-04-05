package urix.MyStore.objects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends MenuPage{

	@FindBy (css = "#cart_summary tbody .product-name a")
	private List<WebElement> productNamesList;
	@FindBy (css = ".icon-trash")
	private List<WebElement> deleteBtnsList;
	@FindBy (css = ".alert.alert-warning")
	private WebElement alert;
	@FindBy (css = "#summary_products_quantity")
	private WebElement productCounter;
	@FindBy (css = ".standard-checkout.button-medium")
	private WebElement checkOutBtn;
	@FindBy (css = "#center_column > form > p > button")
	private WebElement checkOutBtnExclusive;
	@FindBy (css = "#cart_navigation > button")
	private WebElement confirmBtn;
	@FindBy (css = "#cgv")
	private WebElement agreeCheckbox;
	@FindBy (css = "#email")
	private WebElement emailTextField;
	@FindBy (css = "#passwd")
	private WebElement passwordTextField;
	@FindBy (css = ".bankwire")
	private WebElement bankwire;
	@FindBy (css = "#center_column > div > p")
	private WebElement orderCompleteTitle;
	@FindBy (css = "#SubmitLogin")
	private WebElement submitLoginBtn;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getProductNameByIndex(int index) {
		return productNamesList.get(index).getText();
	}
	
	public boolean IsProductInCart(String name) {
		 for (WebElement webElement : productNamesList) {
			if(webElement.getText().equals(name)) {
				return true;
			}
		}
		 return false;
	}
	
	public void deleteProduct(int index) {
		click(deleteBtnsList.get(index));
	}
	
	public String getAlert() {
		return alert.getText();
	}
	
	public int getNumOfProducts() {
		try {
		String title = productCounter.getText();
		title = title.split(" ")[0];
		return Integer.parseInt(title);
		}
		catch (NoSuchElementException e) {
			return 0;
		}
		
	}
	
	public String checkOut(String email,String password) {
		click(checkOutBtn);
		login(email, password);
		wait(checkOutBtnExclusive);
		click(checkOutBtnExclusive);
		click(agreeCheckbox);
		click(checkOutBtn);
		wait(bankwire);
		click(bankwire);
		click(confirmBtn);
		return orderCompleteTitle.getText();
		
	}
	
	private void login(String email,String password) {
		fillText(emailTextField, email);
		fillText(passwordTextField, password);
		click(submitLoginBtn);
		
	}
	
	

}

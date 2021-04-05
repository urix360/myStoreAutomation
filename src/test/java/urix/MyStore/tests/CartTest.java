package urix.MyStore.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import urix.MyStore.objects.CartPage;
import urix.MyStore.objects.StartPage;

public class CartTest extends BaseTest{

	@Test
	public void addToCart() {
		int index = 1;
		StartPage st = new StartPage(driver);
		String productName = st.getProductNameByIndex(index);
		st.addProductToCartByIndexContinueShopping(index);
		st.openCheckout();
		CartPage cart = new CartPage(driver);
		Assert.assertEquals(cart.IsProductInCart(productName), true);
		
	}
	
	@Test
	public void deleteFromCartTest() throws InterruptedException {
		int index = 1;
		StartPage st = new StartPage(driver);
		st.addProductToCartByIndexProceedToCheckout(index);
		CartPage cart = new CartPage(driver);
		cart.deleteProduct(0);
		Thread.sleep(1000);
		Assert.assertEquals(cart.getAlert(), "Your shopping cart is empty.");
		
	}
	
	@Test
	public void addMultipleProductsTest() {
		CartPage cart = new CartPage(driver);
		cart.clickCart();
		int counter = cart.getNumOfProducts();
		cart.clickHome();
		StartPage sp = new StartPage(driver);
		sp.addProductToCartByIndexContinueShopping(0);
		sp.addProductToCartByIndexContinueShopping(1);
        sp.addProductToCartByIndexProceedToCheckout(2);
        Assert.assertEquals(cart.getNumOfProducts(), counter+3);
		
	}
	@Test
	public void followUsTest() throws InterruptedException {
		CartPage cart = new CartPage(driver);
		cart.clickCart();
		Thread.sleep(500);
		String main = driver.getWindowHandle();
		cart.clickYoutubeBtn();
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
		String title = driver.findElement(By.cssSelector(".style-scope.ytd-channel-name")).getText();
		driver.close();
		driver.switchTo().window(main);
		Assert.assertEquals(title, "Selenium Framework");
	}
	
	@Test
	public void checkOutTest() {
		StartPage sp = new StartPage(driver);
		sp.addProductToCartByIndexProceedToCheckout(0);
		CartPage cart = new CartPage(driver);
		String title = cart.checkOut("123@walla.com", "qwer13245");
		Assert.assertEquals(title, "Your order on My Store is complete.");
	}
}

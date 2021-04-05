package urix.MyStore.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import urix.MyStore.objects.CatalogPage;
import urix.MyStore.objects.ContactUsPage;
import urix.MyStore.objects.MenuPage;
import urix.MyStore.objects.StartPage;
import urix.MyStore.objects.TshirtsPage;

public class MenuTest extends BaseTest{

	@Test
	public void BlousesTest() {
		MenuPage mp = new MenuPage(driver);
		mp.openTShirts();
		mp.sleep(1000);
		TshirtsPage tp = new TshirtsPage(driver);
		tp.clickTops();
		tp.sleep(1000);
		tp.clickBlouses();
		tp.sleep(1000);
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "Blouses - My Store");
		tp.returnHome();
		
	}
	@Test
	public void SummerDressesTest() {
		MenuPage mp = new MenuPage(driver);
		mp.openSummerDresses();
		mp.sleep(500);
		CatalogPage cp = new CatalogPage(driver);
		AssertJUnit.assertEquals(cp.getHeader(), "Summer Dresses");
		cp.returnHome();
	}
	
	@Test
	public void womenTest() {
		MenuPage mp = new MenuPage(driver);
		mp.openWomen();
		CatalogPage cp = new CatalogPage(driver);
		AssertJUnit.assertEquals(cp.getHeader(), "Women");
		cp.returnHome();
		AssertJUnit.assertEquals(driver.getTitle(), "My Store");
	}
	
	@Test
	public void searchTest() {
		String text = "DRESS";
		MenuPage mp = new MenuPage(driver);
		mp.search(text);
		CatalogPage cp = new CatalogPage(driver);
		AssertJUnit.assertEquals(cp.getSearchHeader(), "\""+text+"\"");
		cp.returnHome();
		
	}
	
	@Test
	public void searchFailedTest() {
		CatalogPage cp = new CatalogPage(driver);
		cp.clearSearch();
		cp.clickSearch();
		AssertJUnit.assertEquals(cp.getAlert(), "Please enter a search keyword");
		cp.search("non");
		AssertJUnit.assertEquals(cp.getAlert(), "No results were found for your search \"non\"");
		cp.returnHome();
		
	}
	
	@Test
	public void bestSellersTest() {
		StartPage sp = new StartPage(driver);
		sp.openBestSellers();
		AssertJUnit.assertEquals(sp.bestSellersIsSelected(), true);
	}
	
	@Test
	public void contactSucceeded() throws InterruptedException {
		MenuPage mp = new MenuPage(driver);
		mp.contactUs();
		Thread.sleep(1000);
		ContactUsPage cp = new ContactUsPage(driver);
		cp.sendMessage(2, "123@walla.com", "hello MyStore");
		Thread.sleep(1000);
		AssertJUnit.assertEquals(cp.getAlertSuccess(), "Your message has been successfully sent to our team.");
		cp.returnHome();
	}
	
	@Test
	public void contactFailed() throws InterruptedException {
		MenuPage mp = new MenuPage(driver);
		mp.contactUs();
		Thread.sleep(1000);
		ContactUsPage cp = new ContactUsPage(driver);
		cp.sendMessage(0, "", "");
		Thread.sleep(1000);
		AssertJUnit.assertEquals(cp.isAlertErrorAppears(), true);
		cp.returnHome();
	}
	
	
	
}

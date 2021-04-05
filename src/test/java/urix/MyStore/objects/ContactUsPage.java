package urix.MyStore.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends CatalogPage{

	@FindBy (css = "#id_contact")
	WebElement subjectHeadingElement;
	@FindBy (css = "#email")
	WebElement email;
	@FindBy(css = "#message")
	WebElement message;
	@FindBy(css = ".alert.alert-success")
	WebElement alertSuccess;
	@FindBy (css = "#submitMessage")
	WebElement submitBtn;
	@FindBy (css = ".alert.alert-danger")
	WebElement alertError;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void sendMessage(int subjectHeading,String newEmail,String NewMessage) {
		Select selectObj = new Select(subjectHeadingElement);
		selectObj.selectByIndex(subjectHeading);
		fillText(email, newEmail);
		fillText(message, NewMessage);
		click(submitBtn);
	}
	
	public String getAlertSuccess() {
		return alertSuccess.getText();
	}
	
	public boolean isAlertErrorAppears() {
		return alertError.isDisplayed();
	}
	
	
	

}

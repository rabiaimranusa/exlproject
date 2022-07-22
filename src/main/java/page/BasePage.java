package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	
	public int generateRandomNo(int boundNo){
		Random rnd = new Random();
		int genratedNo = rnd.nextInt(boundNo);
		return genratedNo;
	}
	public void selectFromDropdown(WebElement element, String visableText) {
	    	Select sel = new Select( element);
	    	sel.selectByVisibleText(visableText);
			
		}
	
	}

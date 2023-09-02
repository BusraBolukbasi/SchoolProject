package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeanManagmentPage {

    public DeanManagmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='fw-semibold text-white bg-primary navbar-toggler collapsed']")
    public WebElement menubutonu;

    @FindBy(xpath = "(//*[text()='Vice Dean Management'])[2]")
    public WebElement ViceDeanButonu;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement ViceDeanName;


    public static void menuVeViceDeanTiklama(){
       DeanManagmentPage deanManagmentPage = new DeanManagmentPage();
       deanManagmentPage.menubutonu.click();
       deanManagmentPage.ViceDeanButonu.click();
    }


}

package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;


public class DeanManagmentPage {
    Faker name = new Faker();

    public DeanManagmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='header_link ms-2']")
    public WebElement loginButon;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement loginUsername;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//*[@class='fw-semibold btn btn-primary']")
    public WebElement loginSubmitButton;

    @FindBy(xpath = "//*[@class='fw-semibold text-white bg-primary navbar-toggler collapsed']")
    public WebElement menubutonu;

    @FindBy(xpath = "(//*[text()='Vice Dean Management'])[2]")
    public WebElement ViceDeanButonu;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement viceDeanName;

    @FindBy(xpath = "//*[@id='surname']")
    public WebElement viceDeanSurname;

    @FindBy(xpath = "//*[@id='birthPlace']")
    public WebElement viceDeanBirthPlace;

    @FindBy(xpath = "//*[@value='FEMALE']")
    public WebElement viceDeanFemaleGender;

    @FindBy(xpath = "//*[@value='MALE']")
    public WebElement viceDeanMaleGender;

    @FindBy(xpath = "//*[@id='birthDay']")
    public WebElement viceDeanDateOfBirth;

    @FindBy(xpath = "//*[@id='phoneNumber']")
    public WebElement viceDeanPhoneNumber;

    @FindBy(xpath = "//*[@id='ssn']")
    public WebElement viceDeanSnnNumber;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement viceDeanUserName;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement viceDeanPassword;

    @FindBy(xpath = "//*[text()='Submit']")
    public WebElement viceDeanSubmitButton;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement verifyAlert;

    @FindBy(xpath = "(//*[text()='Please enter valid phone number'])[1]")
    public WebElement verifyPhoneNumber;

    @FindBy(xpath = "//*[@class='invalid-feedback']")
    public WebElement requiedYazisi;

    @FindBy(xpath = "(//*[text()='Please enter valid SSN number'])[1]")
    public WebElement verifySsnNumber;


    public DeanManagmentPage menuVeViceDeanTiklama() {
        DeanManagmentPage deanManagmentPage = new DeanManagmentPage();
        deanManagmentPage.menubutonu.click();
        deanManagmentPage.ViceDeanButonu.click();
        return this;
    }

    public DeanManagmentPage zorunluAlanlar(String name, String lastname, String birthPlace, String gender,
                                            String dateOfBirth, String phoneNumber, String SSNnumber,
                                            String userName, String password) {

        if (name != null) {
            viceDeanName.sendKeys(name);
        }

        if (name != null) {
            viceDeanSurname.sendKeys(lastname);
        }

        if (birthPlace != null) {
            viceDeanBirthPlace.sendKeys(birthPlace);
        }

        if (gender != null) {
            if (gender.equalsIgnoreCase("FEMALE")) {
                ReusableMethods.click(viceDeanFemaleGender);
            } else if (gender.equalsIgnoreCase("MALE")) {
                ReusableMethods.click(viceDeanMaleGender);
            }
        }

        if (dateOfBirth != null) {
            viceDeanDateOfBirth.sendKeys(dateOfBirth);
        }

        if (phoneNumber != null) {
            viceDeanPhoneNumber.sendKeys(phoneNumber);
        }

        if (SSNnumber != null) {
            viceDeanSnnNumber.sendKeys(SSNnumber);
        }

        if (userName != null) {
            viceDeanUserName.sendKeys(userName);
        }

        if (password != null) {
            viceDeanPassword.sendKeys(password);
        }
        return this;

    }

    public DeanManagmentPage login(String username, String password){
        ReusableMethods.click(loginButon);
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
        ReusableMethods.click(loginSubmitButton);
        return this;
    }

    public DeanManagmentPage zorunluAlanlariBosBirak(){
        viceDeanPassword.click();
        viceDeanSubmitButton.click();
        return this;
    }
}

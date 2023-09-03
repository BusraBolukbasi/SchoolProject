package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomePage {
    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@href='/register']")
    private WebElement register;

    @FindBy(xpath = "//*[@id='name']")
    private WebElement name;

    @FindBy(id = "surname")
    private WebElement surname;

    @FindBy(id = "birthPlace")
    private WebElement birthPlace;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='gender' and @value='FEMALE']")
    private WebElement femaleGender;

    @FindBy(xpath = "//input[@name='gender' and @value='MALE']")
    private WebElement maleGender;

    @FindBy(id = "birthDay")
    private WebElement birthDay;

    @FindBy(id = "ssn")
    private WebElement ssn;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passWord;

    @FindBy(xpath = "//*[@class='fw-semibold btn btn-primary']")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@class='header_link ms-2']")
    private WebElement login;


    public HomePage registerClick() {
        register.click();
        return this;
    }

    public HomePage getMainPage(){

        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
        return this;
    }

    public HomePage getLogin(String username, String password){
        login.click();
        userName.sendKeys(username);
        passWord.sendKeys(password);
        registerButton.click();
        return this;
    }

    public HomePage registerButton() {
        ReusableMethods.click(registerButton);
        return this;
    }


    public HomePage registerUser(String nameValue, String surnameValue, String birthPlaceValue,
                                 String phoneNumberValue, String genderValue, String birthDayValue,
                                 String ssnValue, String userNameValue, String passwordValue) {


        if (nameValue != null) {
            name.sendKeys(nameValue);
        }

        if (surnameValue != null) {
            surname.sendKeys(surnameValue);
        }

        if (birthPlaceValue != null) {
            birthPlace.sendKeys(birthPlaceValue);
        }

        if (phoneNumberValue != null) {
            phoneNumber.sendKeys(phoneNumberValue);
        }

        if (genderValue != null) {
            if (genderValue.equalsIgnoreCase("FEMALE")) {
                femaleGender.click();
            } else if (genderValue.equalsIgnoreCase("MALE")) {
                maleGender.click();
            }
        }

        if (birthDayValue != null) {
            birthDay.sendKeys(birthDayValue);
        }

        if (ssnValue != null) {
            ssn.sendKeys(ssnValue);
        }

        if (userNameValue != null) {
            userName.sendKeys(userNameValue);
        }

        if (passwordValue != null) {
            passWord.sendKeys(passwordValue);
        }

        return this;
    }

}

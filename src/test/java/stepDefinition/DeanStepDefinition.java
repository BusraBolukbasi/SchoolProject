package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DeanManagmentPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DeanStepDefinition {

    DeanManagmentPage deanManagmentPage = new DeanManagmentPage();

    @Given("Kullanici {string} olarak giris yapar")
    public void kullaniciOlarakGirisYapar(String username) {
       deanManagmentPage.login(ConfigReader.getProperty("DeanName"), ConfigReader.getProperty("DeanPassword"));
    }

    @When("Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer")
    public void girisYaptiktanSonraSagUstteBulunanMenuButonunaTiklarVeVicdeanButonunuSecer() {
        deanManagmentPage.menuVeViceDeanTiklama();
    }

    @And("Kullanici Add Vicedean bolumundeki zorunlu alanlari doldurur")
    public void kullaniciAddVicedeanBolumundekiZorunluAlanlariDoldurur() {
        deanManagmentPage.zorunluAlanlar("Thomas", "Alls", "New York",
                "female", "12/8/1998", "767-456-1235", "167-54-8569",
                "TommyAlls", "TommyAlls1");
        ReusableMethods.bekle(2);
    }

    @And("Submit butonuna tiklar")
    public void submitButonunaTiklar() {
        ReusableMethods.bekle(2);
        ReusableMethods.click(deanManagmentPage.viceDeanSubmitButton);
    }

    @And("Hesabin olustugunu dogrula")
    public void hesabinOlustugunuDogrula() {
        ReusableMethods.visibleWait(deanManagmentPage.verifyAlert, 5);
        Assert.assertEquals("Vice dean Saved", deanManagmentPage.verifyAlert.getText());
    }

    @And("Kullanici Add Vicedean bolumundeki zorunlu alanlari bos birakir")
    public void kullaniciAddVicedeanBolumundekiZorunluAlanlariBosBirakir() {
       deanManagmentPage.zorunluAlanlar(null, null, null, null, null, null, null, null, null);
    }

    @Then("Requied yazisini dogrula")
    public void requiedYazisiniDogrula() {
        Assert.assertTrue(deanManagmentPage.requiedYazisi.isDisplayed());
    }

    @Given("Kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String str) {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }


    @Then("Submit butonuna tikla ve cikan alert ile phoneNumber'in invalid deger oldugunu dogrula")
    public void submitButonunaTiklaVeCikanAlertIlePhoneNumberInInvalidDegerOldugunuDogrula() {
        deanManagmentPage.viceDeanSubmitButton.click();
        ReusableMethods.visibleWait(deanManagmentPage.verifyPhoneNumber, 5);
        Assert.assertTrue(deanManagmentPage.verifyPhoneNumber.isDisplayed());

    }

    @And("Kullanici phoneNumber'a invalid bir numara girer")
    public void kullaniciPhoneNumberAInvalidBirNumaraGirer() {
        deanManagmentPage.viceDeanPhoneNumber.clear();
        //deanManagmentPage.viceDeanPhoneNumber.sendKeys("123-4567-147");
    }

    @And("Kullanici SSN'e invalid bir numara girer")
    public void kullaniciSSNEInvalidBirNumaraGirer() {
        deanManagmentPage.viceDeanSnnNumber.sendKeys("777-132-123");
    }

    @Then("Submit butonuna tikla ve cikan alert ile SSN'in invalid  deger oldugunu dogrula")
    public void submitButonunaTiklaVeCikanAlertIleSSNInInvalidDegerOldugunuDogrula() {
        deanManagmentPage.viceDeanSubmitButton.click();
        ReusableMethods.visibleWait(deanManagmentPage.verifySsnNumber, 5);
        Assert.assertTrue(deanManagmentPage.verifySsnNumber.isDisplayed());
    }

    @And("Kullanici Add Vicedean bolumundeki name {string}, lastName {string}, birthPlace {string}, gender {string}, dateOfBirth {string}, phone {string}, SSN {string}, userName {string}, password {string} doldurur")
    public void kullaniciAddVicedeanBolumundekiNameLastNameBirthPlaceGenderDateOfBirthPhoneSSNUserNamePasswordDoldurur(String name, String lastName, String birtPlace, String gender, String dateOfBirth, String phone, String ssn, String userName, String password) {
        deanManagmentPage.zorunluAlanlar(name, lastName, birtPlace, gender,dateOfBirth, phone, ssn, userName, password);
    }
}

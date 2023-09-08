package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.DeanManagmentPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DeanStepDefinition {

    DeanManagmentPage deanManagmentPage = new DeanManagmentPage();
    SoftAssert softAssert = new SoftAssert();

    Actions actions = new Actions(Driver.getDriver());


    @Given("Kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String str) {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));

    }

    @Given("Kullanici {string} olarak giris yapar")
    public void kullaniciOlarakGirisYapar(String username) {
        deanManagmentPage.login(ConfigReader.getProperty("DeanName"), ConfigReader.getProperty("DeanPassword"));
    }

    @When("Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer")
    public void girisYaptiktanSonraSagUstteBulunanMenuButonunaTiklarVeVicdeanButonunuSecer() {
        deanManagmentPage.menuVeViceDeanTiklama();
    }
    @And("Kullanici Add Vicedean bolumundeki name {string}, lastName {string}, birthPlace {string}, gender {string}, dateOfBirth {string}, phone {string}, SSN {string}, userName {string}, password {string} doldurur")
    public void kullaniciAddVicedeanBolumundekiNameLastNameBirthPlaceGenderDateOfBirthPhoneSSNUserNamePasswordDoldurur(String name, String lastName, String birtPlace, String gender, String dateOfBirth, String phone, String ssn, String userName, String password) {
        deanManagmentPage.zorunluAlanlar(name, lastName, birtPlace, gender, dateOfBirth, phone, ssn, userName, password);
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
        Assert.assertEquals("Required", deanManagmentPage.requiedYazisi.getText());
    }


    @Then("Submit butonuna tikla ve cikan alert ile phoneNumber'in invalid deger oldugunu dogrula")
    public void submitButonunaTiklaVeCikanAlertIlePhoneNumberInInvalidDegerOldugunuDogrula() {
        deanManagmentPage.viceDeanSubmitButton.click();
        ReusableMethods.visibleWait(deanManagmentPage.verifyPhoneNumber, 5);
        Assert.assertEquals("Please enter valid phone number", deanManagmentPage.verifyPhoneNumber.getText());

    }

    @And("Kullanici phoneNumber'a invalid bir numara girer")
    public void kullaniciPhoneNumberAInvalidBirNumaraGirer() {
        deanManagmentPage.viceDeanPhoneNumber.clear();
        deanManagmentPage.viceDeanPhoneNumber.sendKeys("a23-as67-147");
    }

    @And("Kullanici SSN'e invalid bir numara girer")
    public void kullaniciSSNEInvalidBirNumaraGirer() {
        deanManagmentPage.viceDeanSnnNumber.clear();
        deanManagmentPage.viceDeanSnnNumber.sendKeys("45a-a5-7563");
    }

    @Then("Submit butonuna tikla ve cikan alert ile SSN'in invalid  deger oldugunu dogrula")
    public void submitButonunaTiklaVeCikanAlertIleSSNInInvalidDegerOldugunuDogrula() {
        deanManagmentPage.viceDeanSubmitButton.click();
        ReusableMethods.visibleWait(deanManagmentPage.verifySsnNumber, 5);
        Assert.assertEquals("Please enter valid SSN number", deanManagmentPage.verifySsnNumber.getText());
    }


    @And("Kullanici SSN'e {int} karakterden az numara girer")
    public void kullaniciSSNEKarakterdenAzNumaraGirer(int sayi) {
        deanManagmentPage.viceDeanSnnNumber.sendKeys("125-1-1236");
    }

    @Then("Submit butonuna tikla ve cikan mesaj ile SSN'in {int} karakterden az oldugunu dogrula")
    public void submitButonunaTiklaVeCikanMesajIleSSNInKarakterdenAzOldugunuDogrula(int sayi) {
        Assert.assertEquals("Minimum 11 character (XXX-XX-XXXX)", deanManagmentPage.ssnMessage.getText());
    }


    @And("Kullanici phone alanina {int} karakterden az numara girer")
    public void kullaniciPhoneAlaninaKarakterdenAzNumaraGirer(int sayi) {
        deanManagmentPage.viceDeanPhoneNumber.sendKeys("124-55-1236");
    }

    @Then("Submit butonuna tikla ve cikan mesaj ile phone'in {int} karakterden az oldugunu dogrula")
    public void submitButonunaTiklaVeCikanMesajIlePhoneInKarakterdenAzOldugunuDogrula(int sayi) {
        Assert.assertEquals("Minimum 12 character (XXX-XXX-XXXX)", deanManagmentPage.phoneMessage.getText());
    }


    @And("Kullanici password alanina kucuk harf ve sayi iceren {int} karakterli bir sifre girer")
    public void kullaniciPasswordAlaninaKucukHarfVeSayiIcerenKarakterliBirSifreGirer(int sayi) {
        actions.doubleClick(deanManagmentPage.viceDeanPassword).perform();
        deanManagmentPage.viceDeanPassword.sendKeys(Keys.DELETE);
        deanManagmentPage.viceDeanPassword.sendKeys("elena123");


    }

    @Then("Password altinda cikan mesaji dogrula")
    public void passwordAltindaCikanMesajiDogrula() {
        softAssert.assertTrue(deanManagmentPage.viceDeanPassword.isDisplayed());
    }

    @And("Kullanici password alanina buyuk harf ve sayi iceren {int} karakterli bir sifre girer")
    public void kullaniciPasswordAlaninaBuyukHarfVeSayiIcerenKarakterliBirSifreGirer(int sayi) {
        actions.doubleClick(deanManagmentPage.viceDeanPassword).perform();
        deanManagmentPage.viceDeanPassword.sendKeys(Keys.DELETE);
        deanManagmentPage.viceDeanPassword.sendKeys("ELENA123");


    }

    @And("Kullanici password alanina buyuk harf ve kucuk harf iceren {int} karakterli bir sifre girer")
    public void kullaniciPasswordAlaninaBuyukHarfVeKucukHarfIcerenKarakterliBirSifreGirer(int sayi) {
        actions.doubleClick(deanManagmentPage.viceDeanPassword).perform();
        deanManagmentPage.viceDeanPassword.sendKeys(Keys.DELETE);
        deanManagmentPage.viceDeanPassword.sendKeys("ELENAback");

    }

    @And("Kullanici pasword alanina {int} karakterden az bir sifre girer")
    public void kullaniciPaswordAlaninaKarakterdenAzBirSifreGirer(int sayi) {
        actions.doubleClick(deanManagmentPage.viceDeanPassword).perform();
        deanManagmentPage.viceDeanPassword.sendKeys(Keys.DELETE);
        deanManagmentPage.viceDeanPassword.sendKeys("elena");

    }

    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.getDriver().close();
    }

}


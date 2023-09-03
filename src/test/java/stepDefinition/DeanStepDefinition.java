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
        deanManagmentPage.zorunluAlanlar("Kelli", "All", "New York",
                "female", "12/8/1998", null, "487-89-8657",
                "JemAll", "JemAll12");
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
        Assert.assertTrue(deanManagmentPage.verifyAlert.isDisplayed());
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


    @Then("Alert ile invalid deger oldugunu dogrula")
    public void alertIleInvalidDegerOldugunuDogrula() {
        Assert.assertTrue(deanManagmentPage.verifyPhoneNumber.isDisplayed());
    }

    @Then("Submit butonuna tikla ve cikan alert ile phoneNumber'in invalid deger oldugunu dogrula")
    public void submitButonunaTiklaVeCikanAlertIlePhoneNumberInInvalidDegerOldugunuDogrula() {
        deanManagmentPage.viceDeanSubmitButton.click();
        deanManagmentPage.viceDeanPhoneNumber.clear();
        deanManagmentPage.viceDeanPhoneNumber.sendKeys("123-4567-147");
    }
}

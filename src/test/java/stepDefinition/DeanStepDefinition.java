package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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
        deanManagmentPage.zorunluAlanlar("Jem", "All", "New York",
                "female", "12/8/1998", "455-632-5469", "487-89-8657",
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

    @Given("Kullanici anasayafa gider")
    public void kullaniciAnasayafaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }
}

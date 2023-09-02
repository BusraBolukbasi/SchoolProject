package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeanManagmentPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class DeanStepDefinition {
    HomePage homePage = new HomePage();
    DeanManagmentPage deanManagmentPage = new DeanManagmentPage();
    @Given("Kullanici {string} olarak giris yapar")
    public void kullaniciOlarakGirisYapar(String username, String password) {
        homePage.getLogin("DeanGiris", "Passworddean");
    }

    @When("Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar")
    public void girisYaptiktanSonraSagUstteBulunanMenuButonunaTiklar() {
        DeanManagmentPage.menuVeViceDeanTiklama();
    }

    @Then("Kullanici menudeki Vicedean butonuna tiklar")
    public void kullaniciMenudekiVicedeanButonunaTiklar() {

    }

    @And("Kullanici Add Vicedean bolumundeki zorunlu alanlari doldurur")
    public void kullaniciAddVicedeanBolumundekiZorunluAlanlariDoldurur() {
    }

    @And("Submit butonuna tiklar")
    public void submitButonunaTiklar() {
    }

    @And("Hesabin olustugunu dogrula")
    public void hesabinOlustugunuDogrula() {
    }
}

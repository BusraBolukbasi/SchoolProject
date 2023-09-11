package stepDefinition;

import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;
import pages.DeanManagmentPage;

public class DeanShouldBeAbleToSeeMessages {
    DeanManagmentPage deanManagmentPage = new DeanManagmentPage();

    SoftAssert softAssert = new SoftAssert();


    @When("Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve contact get all butonunu secer")
    public void giris_yaptiktan_sonra_sag_ustte_bulunan_menu_butonuna_tiklar_ve_contact_get_all_butonunu_secer() {
        deanManagmentPage.menuVeContactGetAllButonu();

    }
    @Then("Mesajlarin gorunur oldugunu dogrula")
    public void mesajlarin_gorunur_oldugunu_dogrula() {
        softAssert.assertTrue(deanManagmentPage.messages.isEmpty());
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}


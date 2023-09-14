package stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import pojos.VicedeanObjectPojo;
import pojos.VicedeanResponsePojo;
import pojos.VicedeanSavePojo;
import utilities.ObjectMapperUtils;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeanApiStepDefiniton {
    SoftAssert softAssert = new SoftAssert();
    VicedeanSavePojo expectedData;
    Response response;
    VicedeanResponsePojo actualData;
    Response response1;

    Response response2;
    JsonPath json;
    VicedeanSavePojo expectedData1;

    VicedeanResponsePojo actualData1;

    Response response3;
    JsonPath json1;

    // POST Islemi
    @Given("Vicedean eklemek icin Post Request hazirligi yapilir")
    public void vicedean_eklemek_icin_post_request_hazirligi_yapilir() {
        // Set the URL
        spec.pathParams("first", "vicedean", "second", "save");
    }

    @Given("Gonderilecek vicedean bilgileri hazirlanir")
    public void gonderilecek_vicedean_bilgileri_hazirlanir() {
        // Set the Expected Data
        expectedData = new VicedeanSavePojo("1996-10-11", "New York", "FEMALE", "Abbie", "AbbieKristof12", "845-143-6325", "756-98-5412", "Kristof", "AbbieKristoff");

    }

    @When("Vicedean eklemek icin Post Request gonderilir")
    public void vicedean_eklemek_icin_post_request_gonderilir() {
        // Send the Request and Get the Response
        response = given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();
        actualData = response.as(VicedeanResponsePojo.class);

    }

    @Then("Viceden bilgileri dogrulanir")
    public void viceden_bilgileri_dogrulanir() {
       assertEquals(200, response.statusCode());
       assertEquals(expectedData.getName(), actualData.getObject().getName());
       assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertTrue(actualData.getMessage().contains("Vice dean Saved"));
        assertTrue(actualData.getHttpStatus().contains("CREATED"));
    }

    // GET Islemi
    @Given("Vicedean sorgulamak icin Get islemi yapilir")
    public void vicedean_sorgulamak_icin_get_islemi_yapilir() {
        //https://managementonschools.com/app/vicedean/getViceDeanById/590
       spec.pathParams("first", "vicedean", "second", "getViceDeanById", "third", 609);
    }
    @When("Viceden sorgulamak icin Get Request gonderilir")
    public void viceden_sorgulamak_icin_get_request_gonderilir() {
        response1 = given(spec).when().get("{first}/{second}/{third}");
        response1.prettyPrint();
    }
    @Then("Body dogrulanir")
    public void body_dogrulanir() {
        json = response1.jsonPath();
        softAssert.assertEquals("AbbieKristoff", json.getString("username"));
        softAssert.assertEquals("Abbie", json.getString("name"));
        softAssert.assertEquals("Kristo", json.getString("surname"));

    }

    // PUT Islemi
    @Given("Viceden guncellemek icin Put hazirligi yapilir")
    public void viceden_guncellemek_icin_put_hazirligi_yapilir() {
        //https://managementonschools.com/app/vicedean/update/590
        spec.pathParams("first", "vicedean", "second", "update", "third", 609);
    }
    @Given("Guncellenecek vicedean bilgileri hazirlanir")
    public void guncellenecek_vicedean_bilgileri_hazirlanir() {
        expectedData1 = new VicedeanSavePojo("1996-10-11", "England", "FEMALE", "Abbie", "AbbieKristof12", "845-143-6325", "756-98-5412", "Kristof", "AbbieKristoff");

    }
    @When("Vicedean guncellemek icin Put Request gonderilir")
    public void vicedean_guncellemek_icin_put_request_gonderilir() {
        response2 = given(spec).body(expectedData1).when().put("{first}/{second}/{third}");
        response2.prettyPrint();
    }
    @Then("Gelen body dogrulanir")
    public void gelen_body_dogrulanir() {
        actualData1 = response2.as(VicedeanResponsePojo.class);
        assertEquals(expectedData1.getBirthPlace(), actualData1.getObject().getBirthPlace());
        assertTrue(actualData1.getMessage().contains("Vice dean Updated Successful"));

    }

    // DELETE Islemi
    @Given("Vicedean silmek icin Delete islemi yapilir")
    public void vicedean_silmek_icin_delete_islemi_yapilir() {
        //https://managementonschools.com/app/vicedean/delete/590
        spec.pathParams("first", "vicedean","second","delete", "third", 609);

    }
    @When("Silmek icin Delete Request gonderilir")
    public void silmek_icin_delete_request_gonderilir() {
        response3 = given(spec).when().delete("{first}/{second}/{third}");
        response3.prettyPrint();
    }
    @Then("Silindigini dogrula")
    public void silindigini_dogrula() {
         json1 = response3.jsonPath();
         assertEquals(200, response3.statusCode());
         assertEquals("Vice dean Deleted",json1.getString("message"));
    }



}

package stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import pojos.ViceDeanResponsePojo;
import pojos.ViceDeanSavePojo;
import pojos.VicedeanObjectPojo;

import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeanApiStepDefiniton {
    ViceDeanSavePojo expectedData;
    Response response;
    ViceDeanResponsePojo actualData;
    @Given("Vicedean eklemek icin Post Request hazirligi yapilir")
    public void vicedean_eklemek_icin_post_request_hazirligi_yapilir() {
        //Set the URL
        spec.pathParams("first", "app", "second", "vicedean", "third", "save");

    }
    @Given("Gonderilecek vicedean bilgileri hazirlanir")
    public void gonderilecek_vicedean_bilgileri_hazirlanir() {
        // Set the Expected data
        expectedData = new ViceDeanSavePojo("1996-12-11", "New York", "MALE", "Jackson", "JacksonWang1", "412-412-4563", "456-54-6582", "Wang", "WangJackson");
    }
    @When("Vicedean eklemek icin Post Request gonderilir")
    public void vicedean_eklemek_icin_post_request_gonderilir() {
        // Send the Request and Get the Response
        response = given(spec).body(expectedData).when().post("{first}/{second}/{third}");
        actualData = response.as(ViceDeanResponsePojo.class);
    }
    @Then("Viceden bilgileri dogrulanir")
    public void viceden_bilgileri_dogrulanir() {
        //Do Assertion
        assertEquals(200, response.statusCode());




    }
}

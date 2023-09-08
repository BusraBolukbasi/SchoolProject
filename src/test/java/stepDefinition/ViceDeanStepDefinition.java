package stepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.LessonManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ViceDeanStepDefinition {
    LessonManagementPage lessonManagementPage = new LessonManagementPage();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @Given("Anasayfaya git")
    public void anasayfayaGit() {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }

    @When("ViceDean olarak sayfaya login ol")
    public void vicedeanOlarakSayfayaLoginOl() {
        lessonManagementPage.loginButton.click();
        lessonManagementPage.userNameBox.sendKeys(ConfigReader.getProperty("DeanName"), ConfigReader.getProperty("DeanPassword"));
    }

    @Then("Lesson Program kismina tikla")
    public void lessonProgramKisminaTikla() {
        ReusableMethods.click(lessonManagementPage.lessonButton);
    }

    @When("Choose Lessons kismina tikla ve herhangi bir ders sec")
    public void chooseLessonsKisminaTiklaVeHerhangiBirDersSec() {
        lessonManagementPage.compulsoryBox.click();
    }

    @Then("Choose Day kismina tikla ve bir gun ismi sec")
    public void chooseDayKisminaTiklaVeBirGunIsmiSec() {
        lessonManagementPage.lessonNameBox.sendKeys(Keys.CLEAR);
        lessonManagementPage.lessonNameBox.sendKeys(faker.name().firstName());
    }

    @And("Choose Education Term kismindan bir donem ismi sec")
    public void chooseEducationTermKismindanBirDonemIsmiSec() {
        lessonManagementPage.creditScoreBox.sendKeys(Keys.CLEAR);
        lessonManagementPage.creditScoreBox.sendKeys(faker.number().digits(2));
    }

    @And("Start Time kismina sayisal bir deger gir")
    public void startTimeKisminaSayisalBirDegerGir() {

    }

    @And("Stop Time kismina sayisal bir deger gir")
    public void stopTimeKisminaSayisalBirDegerGir() {
    }

    @Then("Submit butonuna tikla ve kayit oldugunu dogrula")
    public void submitButonunaTiklaVeKayitOldugunuDogrula() {
        lessonManagementPage.submitButton.click();
    }

    @When("Submit butonuna tikla")
    public void submitButonunaTikla() {
        actions.doubleClick(lessonManagementPage.lessonNameBox).perform();
        lessonManagementPage.lessonNameBox.sendKeys(Keys.DELETE);
    }

    @Then("Choose Lessons kismini bos birak")
    public void chooseLessonsKisminiBosBirak() {
        lessonManagementPage.lessonNameRequired.isDisplayed();
    }

    @When("Choose Day,Choose Education Term,Start Time,Stop Time kismini doldur")
    public void chooseDayChooseEducationTermStartTimeStopTimeKisminiDoldur() {
        lessonManagementPage.lessonNameBox.sendKeys(faker.name().firstName());
    }

    @When("Choose Day kismini bos birak")
    public void chooseDayKisminiBosBirak() {
        actions.doubleClick(lessonManagementPage.creditScoreBox).perform();
        lessonManagementPage.creditScoreBox.sendKeys(Keys.DELETE);
    }

    @Then("Choose Lessons,Choose Education Term,Start Time,Stop Time  kismini doldur")
    public void chooseLessonsChooseEducationTermStartTimeStopTimeKisminiDoldur() {
        lessonManagementPage.creditScoreRequired.isDisplayed();
    }

    @Then("Choose Education Term kismini bos birak")
    public void chooseEducationTermKisminiBosBirak() {
        softAssert.assertTrue(lessonManagementPage.lessonNameRequired.isDisplayed());
        softAssert.assertTrue(lessonManagementPage.creditScoreRequired.isDisplayed());
    }

    @When("Choose Lessons,Choose Day,Start Time,Stop Time  kismini doldur Submit butonuna tikla")
    public void chooseLessonsChooseDayStartTimeStopTimeKisminiDoldurSubmitButonunaTikla() {
        Assert.assertFalse(lessonManagementPage.lessonList.isEmpty());
    }

    @Then("Start Time kismini bos birak")
    public void startTimeKisminiBosBirak() {
        List<WebElement> dersler;
        int indeks = -1;
        boolean flag = true;

        while (flag) {
            dersler = lessonManagementPage.dersListesi;
            for (int i = 0; i < dersler.size(); i++) {
                if (dersler.get(i).getText().equals("zooloji")) {
                    indeks = i;
                    actions.sendKeys(Keys.PAGE_UP).perform();
                    ReusableMethods.visibleWait(dersler.get(i), 3);
                    ReusableMethods.click
                            (dersler.get(indeks + 3));
                    flag = false;
                } else if (flag) {

                    ReusableMethods.click
                            (lessonManagementPage.birSonrakiSayfaButonu);
                }

            }

            //   ReusableMethods.bekle(2);
        }
    }

    @When("Choose Lessons,Choose Day,Choose Education Term,Stop Time kismini doldur")
    public void chooseLessonsChooseDayChooseEducationTermStopTimeKisminiDoldur() {
        ReusableMethods.visibleWait(lessonManagementPage.lessonDeleted, 3);
        softAssert.assertEquals("Lesson Deleted", lessonManagementPage.lessonDeleted.getText());
        // softAssert.assertTrue(lessonManagementPage.dersSilmeAlert.isDisplayed());
    }

    @When("Stop Time kismini bos birak")
    public void stopTimeKisminiBosBirak() {
        lessonManagementPage.startTimeBox.sendKeys("1500");
    }

    @Then("Choose Lessons,Choose Day,Choose Education Term,Start Time  kismini doldur")
    public void chooseLessonsChooseDayChooseEducationTermStartTimeKisminiDoldur() {

    }
}

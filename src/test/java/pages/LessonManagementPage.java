package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class LessonManagementPage {
    public LessonManagementPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@class='header_link ms-2']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement loginEnter;

    @FindBy(xpath = "//*[@id='controlled-tab-example-tab-lessonsList']")
    public WebElement lessonButton;

    @FindBy(xpath = "//*[@id='lessonName']")
    public WebElement lessonNameBox;

    @FindBy(xpath = "//*[@id='compulsory']")
    public WebElement compulsoryBox;

    @FindBy(xpath = "//*[@id='creditScore']")
    public WebElement creditScoreBox;

    @FindBy(xpath = "(//*[@class='fw-semibold btn btn-primary btn-lg'])[2]")
    public WebElement submitButton;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[4]")
    public WebElement lessonNameRequired;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[5]")
    public WebElement creditScoreRequired;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement dersSilmeAlert;

    @FindBy(xpath = "(//*[@class='fa-solid fa-trash'])[2]")
    public WebElement dersSilmeButton;

    @FindBy(xpath = "(//*[@role='button'])[18]")
    public WebElement sonSayfaButton;

    @FindBy(xpath = "(//*[@class='fa-solid fa-trash'])[7]")
    public WebElement sonSayfaDeleteButton;

    @FindBy(xpath = "//*[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
    public WebElement lessonDeletedAlert;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement createLessondAlert;

    @FindBy(xpath = "//*[@class='table-group-divider']")
    public List<WebElement> lessonList;

    @FindBy(xpath = "//*[@id='startTime']")
    public WebElement startTimeBox;

    @FindBy(xpath = "//*[@id='stopTime']")
    public WebElement stopTimeBox;

    @FindBy(xpath = "//*[@class=' css-13cymwt-control']")
    public WebElement chooseLessonsBox;

    @FindBy(xpath = "//*[@id='educationTermId']")
    public WebElement chooseEducationTermDdm;

    @FindBy(xpath = "//*[@id='controlled-tab-example-tab-lessonProgram']")
    public WebElement lessonProgramButton;

    @FindBy(xpath = "//*[@class='mb-3 form-select']")
    public WebElement chooseDayDdm;


    @FindBy(xpath = "(//*[text()='›'])[2]")
    public WebElement birSonrakiSayfaButonu;

    @FindBy(xpath = "//*[text()='Lesson Deleted']")
    public WebElement lessonDeleted;

    @FindBy(xpath = "//div[@id='controlled-tab-example-tabpane-lessonsList']//div[@class='mt-5 ms-3 me-3 text-center border border-3 shadow-sm bg-body rounded card border-warning']//table//tbody//tr//td")
    public List<WebElement> dersListesi;

    @FindBy(xpath = "(//*[@type='button'])[30]")
    public WebElement dersProgramiButton;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement dersProgramiAlert;




}

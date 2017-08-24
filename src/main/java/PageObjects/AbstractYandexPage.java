package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;

public abstract class AbstractYandexPage extends Page {
    protected static WebDriverWait WAIT = new WebDriverWait(
            PageFactory.getDriver(), PageFactory.getTimeOutInSeconds());

    @ElementTitle("Поисковая строка")
    @FindBy(xpath = "//*[@class='search2__input']//input")
    protected WebElement searchInput;

    @ElementTitle("Кнопка поиска")
    @FindBy(className = "search2__button")
    protected WebElement searchBtn;

    protected AbstractYandexPage() {
        PageFactory.initElements(PageFactory.getDriver(), this);
    }

    protected void init(WebElement... waitForElements) {
        PageFactory.initElements(PageFactory.getDriver(), this);
        for (WebElement waitForEl : waitForElements) {
            WAIT.until(ExpectedConditions.elementToBeClickable(waitForEl));
        }
    }

    @ActionTitle("ищет")
    public void search(String searchFor) {
        searchInput.sendKeys(searchFor);
        searchBtn.click();
    }

}
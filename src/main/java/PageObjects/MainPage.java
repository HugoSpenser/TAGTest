package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;

@PageEntry(title = "Главная страница яндекса")
public class MainPage extends AbstractYandexPage {

    @ElementTitle("яндекс.маркет")
    @FindBy(xpath = "//a[@data-id='market']")
    private WebElement marketLink;

    public MainPage() {
        init(marketLink);
        new WebDriverWait(PageFactory.getDriver(), PageFactory.getTimeOutInSeconds());
    }

    @ActionTitle("переходит в яндекс.маркет")
    public void clickBtn(String title) throws PageException {
        marketLink.click();
    }
}

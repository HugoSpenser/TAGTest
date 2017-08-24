package PageObjects;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import java.util.List;

@PageEntry(title = "Маркет. Результаты поиска")
public class MarketSearchResultsPage extends MarketMainPage {

    @ElementTitle("Результаты поиска")
    @FindBy(xpath = "//div[contains(@class,'layout__col_search-results_normal')]//div[contains(@class,'n-snippet-card')]")
    private List<WebElement> searchResultsNumber;

    @ElementTitle("Категория товаров")
    @FindBy(xpath = "//div[contains(@class, 'n-categories-panel-watcher')]")
    private WebElement filterPane;

    public MarketSearchResultsPage() {
        init(filterPane);
    }

    @ActionTitle("количество результатов поиска больше чем")
    public void checkElementQuantityGreaterThanParam(String num) {
        Assert.assertTrue(searchResultsNumber.size() > Integer.parseInt(num));
    }
}
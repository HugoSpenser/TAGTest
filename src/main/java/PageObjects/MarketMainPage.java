package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Маркет. Главная страница")
public class MarketMainPage extends AbstractYandexPage {

    @FindBy(className = "logo_part_market")
    private WebElement marketLogo;

    public MarketMainPage() {
        init(marketLogo);
    }
}

package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DateHelper;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private SelenideElement buyButton = $x("//span[text()='Купить']/ancestor::button");
    private SelenideElement numberField = $x("//span[text()='Номер карты']/following-sibling::span/input");
    private SelenideElement yearField = $x("//span[text()='Год']/following-sibling::span/input");
    private SelenideElement monthField = $x("//span[text()='Месяц']/following-sibling::span/input");
    private SelenideElement ownerField = $x("//span[text()='Владелец']/following-sibling::span/input");
    private SelenideElement CVCField = $x("//span[text()='CVC/CVV']/following-sibling::span/input");
    private SelenideElement continueButton = $x("//span[text()='Продолжить']/ancestor::button");
    private String clearInput = Keys.chord(Keys.CONTROL + "A", Keys.BACK_SPACE);
    private ElementsCollection notificationContent = $$x("//div[@class='notification__content']");
    private SelenideElement errorTextCVC = $x("//span[text()='CVC/CVV']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorTextOwner = $x("//span[text()='Владелец']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorTextNumbCard = $x("//span[text()='Номер карты']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorTextMonth = $x("//span[text()='Месяц']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorTextYear = $x("//span[text()='Год']/following-sibling::span[@class='input__sub']");

    public void inputNumbCard (DateHelper.CardInfo info) {
        buyButton.click();
        numberField.sendKeys(clearInput);
        numberField.setValue(info.getNumbCard());
        yearField.sendKeys(clearInput);
        yearField.setValue(info.getYear());
        monthField.sendKeys(clearInput);
        monthField.setValue(info.getMonth());
        ownerField.sendKeys(clearInput);
        ownerField.setValue(info.getOwner());
        CVCField.sendKeys(clearInput);
        CVCField.setValue(info.getCvc());
        continueButton.click();
    }

    public void shouldSuccessfully(String textSuccessfully) {
        notificationContent.first().shouldBe(Condition.visible, Duration.ofSeconds(15));
        notificationContent.first().shouldHave(Condition.text(textSuccessfully));
    }

    public void shouldNoAccess(String textError) {
        notificationContent.get(1).shouldBe(Condition.visible, Duration.ofSeconds(15));
        notificationContent.get(1).shouldHave(Condition.text(textError));
    }

    public void shouldErrorCVC(String textError) {
        errorTextCVC.shouldBe(Condition.visible, Condition.text(textError));
    }

    public void shouldErrorNumbCard(String errorText) {
        errorTextNumbCard.shouldBe(Condition.visible, Condition.text(errorText));
    }

    public void shouldErrorMonth(String errorText) {
        errorTextMonth.shouldBe(Condition.visible, Condition.text(errorText));
    }

    public void shouldErrorYear(String errorText) {
        errorTextYear.shouldBe(Condition.visible, Condition.text(errorText));
    }

    public void shouldErrorOwner(String errorText) {
        errorTextOwner.shouldBe(Condition.visible, Condition.exactText(errorText));
    }
}

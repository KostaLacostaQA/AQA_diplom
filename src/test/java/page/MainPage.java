package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DBInteraction;
import data.DateHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement buttonBuy = $x("//span[text()='Купить']/ancestor::button");
    private SelenideElement numberCard = $x("//span[text()='Номер карты']/following-sibling::span/input");
    private SelenideElement yearCard = $x("//span[text()='Год']/following-sibling::span/input");
    private SelenideElement monthCard = $x("//span[text()='Месяц']/following-sibling::span/input");
    private SelenideElement ownerCard = $x("//span[text()='Владелец']/following-sibling::span/input");
    private SelenideElement cardCVC = $x("//span[text()='CVC/CVV']/following-sibling::span/input");
    private SelenideElement continueButton = $x("//span[text()='Продолжить']/ancestor::button");
    private String clearInput = Keys.chord(Keys.CONTROL + "A", Keys.BACK_SPACE);
    private ElementsCollection notificationContent = $$x("//div[@class='notification__content']");
    private SelenideElement errorTextCVC = $x("//span[text()='CVC/CVV']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorTextOwner = $x("//span[text()='Владелец']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorTextNumbCard = $x("//span[text()='Номер карты']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorTextMonth = $x("//span[text()='Месяц']/following-sibling::span[@class='input__sub']");
    private SelenideElement errorTextYear = $x("//span[text()='Год']/following-sibling::span[@class='input__sub']");

    public void inputNumbCard (DateHelper.NumbCard infoNumbCard, DateHelper.Month infoMonth, DateHelper.Year infoYear, DateHelper.Owner infoOwner, DateHelper.CVC infoCVC) {
        buttonBuy.click();
        numberCard.sendKeys(clearInput);
        numberCard.setValue(infoNumbCard.getNumbCard());
        yearCard.sendKeys(clearInput);
        yearCard.setValue(infoYear.getYear());
        monthCard.sendKeys(clearInput);
        monthCard.setValue(infoMonth.getMonth());
        ownerCard.sendKeys(clearInput);
        ownerCard.setValue(infoOwner.getOwner());
        cardCVC.sendKeys(clearInput);
        cardCVC.setValue(infoCVC.getCvc());
        continueButton.click();
    }

    public void shouldSuccessfully() {
        notificationContent.first().shouldBe((Condition.exactText("Операция одобрена Банком.")), Duration.ofSeconds(10));
    }

    public void shouldNoAccess() {
        notificationContent.get(1).shouldBe((Condition.exactText("Ошибка! Банк отказал в проведении операции.")), Duration.ofSeconds(10));
    }

    public void shouldErrorCVC() {
        errorTextCVC.shouldBe(Condition.exactText("Неверный формат"));
    }

    public void shouldErrorNumbCard() {
        errorTextNumbCard.shouldBe(Condition.exactText("Неверный формат"));
    }

    public void shouldErrorMonth() {
        errorTextMonth.shouldBe(Condition.exactText("Неверный формат"));
    }

    public void shouldErrorYear() {
        errorTextYear.shouldBe(Condition.exactText("Неверный формат"));
    }

    public void shouldErrorRequiredToCompleteOwner() {
        errorTextOwner.shouldBe(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void shouldErrorShelfLifeMonth() {
        errorTextMonth.shouldBe(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void shouldErrorShelfLifeYear() {
        errorTextYear.shouldBe(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void shouldErrorExpiredYear() {
        errorTextYear.shouldBe(Condition.exactText("Истёк срок действия карты"));
    }



    public void shouldAPPROVED() {
        Assertions.assertEquals("APPROVED", DBInteraction.checkUser());
    }

    public void shouldDECLINED() {
        Assertions.assertEquals("DECLINED", DBInteraction.checkUser());
    }
}

package test;

import data.DBInteraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static data.DateHelper.*;

public class BuyTurTest extends SetUp {

    @Test
    @DisplayName("Payment by card. Successful payment by card with APPROVED status")
    void successfulPaymentAPPROVED() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldSuccessfully("Операция одобрена Банком");
        Assertions.assertEquals("APPROVED", DBInteraction.checkUser());
    }

    @Test
    @DisplayName("Payment by card. Reject card purchase with DECLINED status")
    void noAccessPaymentDECLINED() {

        CardInfo cardInfo = new CardInfo(numbCardDeclined(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldNoAccess("Ошибка! Банк отказал в проведении операции.");
        Assertions.assertEquals("DECLINED", DBInteraction.checkUser());
    }

    @Test
    @DisplayName("Payment by card. Enter Latin letters in the Card Number field")
    void enterLatinLettersInNumbCard() {

        CardInfo cardInfo = new CardInfo(numbCardLatinLetters(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorNumbCard("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Entering special characters in the Card Number field")
    void enterSpecialCharactersInNumbCard() {

        CardInfo cardInfo = new CardInfo(charactersField(16), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorNumbCard("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Entering one digit in the Card Number field")
    void enterOneDigitInNumbCard() {

        CardInfo cardInfo = new CardInfo(oneNumberField(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorNumbCard("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Enter 17 digits in the Card Number field")
    void enterMoreNumbsInNumbCard() {

        CardInfo cardInfo = new CardInfo(numbCardMoreNumbers(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldNoAccess("Ошибка! Банк отказал в проведении операции.");
    }

    @Test
    @DisplayName("Payment by card. Enter 16 zeros in the Card Number field")
    void enterMoreZeroInNumbCard() {

        CardInfo cardInfo = new CardInfo(numbCardMoreZeroNumb(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldNoAccess("Ошибка! Банк отказал в проведении операции.");
    }

    @Test
    @DisplayName("Payment by card. Sending an empty field Card number")
    void noEnterInNumbCard() {

        CardInfo cardInfo = new CardInfo(nothingField(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorNumbCard("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Enter Latin letters in the Month field")
    void enterLatinLettersInMonth() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), latinLetters(2), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorMonth("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Enter two zeros in the Month field")
    void enterTwoZeroInMonth() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthTwoZero(), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorMonth("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Payment by card. Enter the number 13 in the Month field")
    void enterThirteenNumbInMonth() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthThirteen(), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorMonth("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Payment by card. Entering three digits in the Month field")
    void enterThreeNumbsInMonth() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthThreeNumbers(), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorMonth("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Payment by card. Entering special characters in the Month field")
    void enterSpecialCharactersInMonth() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), charactersField(2), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorMonth("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Sending an empty field Month")
    void noEnterInMonth() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), nothingField(), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorMonth("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Enter a year in the Year field that is 5 years older than the current year")
    void enterFiveMoreInYear() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(5, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldSuccessfully("Операция одобрена Банком");
        Assertions.assertEquals("APPROVED", DBInteraction.checkUser());
    }

    @Test
    @DisplayName("Payment by card. Enter a year in the Year field that is 6 years older than the current year")
    void enterSixMoreInYear() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(6, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorYear("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Payment by card. Enter the year in the Year field, which is 1 year less than the current year")
    void enterOneLessInYear() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(-1, "yy"), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorYear("Истёк срок действия карты");
    }

    @Test
    @DisplayName("Payment by card. Enter Latin letters in the Year field")
    void enterLatinLettersInYear() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), latinLetters(2), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorYear("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Entering one digit in the Year field")
    void enterOneDigitInYear() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), oneNumberField(), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorYear("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Sending an empty field Year")
    void noEnterInYear() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), nothingField(), monthValid(0, "MM"), ownerName("en"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorYear("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Entering Cyrillic letters in the Owner field")
    void enterCyrillicInOwner() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("ru"), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorOwner("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Entering numbers in the Owner field")
    void enterNumbsInOwner() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerMoreNumbers(), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorOwner("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Entering special characters in the Owner field")
    void enterCharactersInOwner() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), charactersRandomOwner(), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorOwner("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Sending an empty field Owner")
    void noEnterInOwner() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), nothingField(), cvcValid());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorOwner("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Payment by card. Enter Latin letters in the CVC/CVV field")
    void enterLatinLettersInCVC() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), latinLetters(3));
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorCVC("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Entering 4 digits in the CVC/CVV field")
    void enterFourNumbsInCVC() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcFourNumb());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldSuccessfully("Операция одобрена Банком");
        Assertions.assertEquals("APPROVED", DBInteraction.checkUser());
    }

    @Test
    @DisplayName("Payment by card. Entering one digit in the CVC/CVV field")
    void enterOneNumbInCVC() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), oneNumberField());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorCVC("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Enter 3 zeros in the CVC/CVV field")
    void enterThreeZeroInCVC() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), cvcThreeZero());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorCVC("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Entering special characters in the CVC/CVV field")
    void enterCharactersInCVC() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), charactersField(3));
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorCVC("Неверный формат");
    }

    @Test
    @DisplayName("Payment by card. Sending an empty CVC/CVV field")
    void noEnterInCVC() {

        CardInfo cardInfo = new CardInfo(numbCardApproved(), yearDate(0, "yy"), monthValid(0, "MM"), ownerName("en"), nothingField());
        MainPage main = new MainPage();
        main.inputNumbCard(cardInfo);
        main.shouldErrorCVC("Неверный формат");
    }
}

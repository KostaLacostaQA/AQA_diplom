package test;

import data.DateHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class BuyTurTest extends SetUp {

    @Test
    @DisplayName("Payment by card. Successful payment by card with APPROVED status")
    void successfulPaymentAPPROVED() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldSuccessfully();
        main.shouldAPPROVED();
    }

    @Test
    @DisplayName("Payment by card. Reject card purchase with DECLINED status")
    void noAccessPaymentDECLINED() {
        var validNumbCard = DateHelper.NumbCard.numbCardDeclined();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldNoAccess();
        main.shouldDECLINED();
    }

    @Test
    @DisplayName("Payment by card. Enter Latin letters in the Card Number field")
    void enterLatinLettersInNumbCard() {
        var validNumbCard = DateHelper.NumbCard.numbCardLatinLetters();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorNumbCard();
    }

    @Test
    @DisplayName("Payment by card. Entering special characters in the Card Number field")
    void enterSpecialCharactersInNumbCard() {
        var validNumbCard = DateHelper.NumbCard.numbCardSpecialCharset();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorNumbCard();
    }

    @Test
    @DisplayName("Payment by card. Entering one digit in the Card Number field")
    void enterOneDigitInNumbCard() {
        var validNumbCard = DateHelper.NumbCard.numbCardSingleNumb();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorNumbCard();
    }

    @Test
    @DisplayName("Payment by card. Enter 17 digits in the Card Number field")
    void enterMoreNumbsInNumbCard() {
        var validNumbCard = DateHelper.NumbCard.numbCardMoreNumbers();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldNoAccess();
    }

    @Test
    @DisplayName("Payment by card. Enter 16 zeros in the Card Number field")
    void enterMoreZeroInNumbCard() {
        var validNumbCard = DateHelper.NumbCard.numbCardMoreZeroNumb();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldNoAccess();
    }

    @Test
    @DisplayName("Payment by card. Sending an empty field Card number")
    void noEnterInNumbCard() {
        var validNumbCard = DateHelper.NumbCard.numbCardNothing();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorNumbCard();
    }

    @Test
    @DisplayName("Payment by card. Enter Latin letters in the Month field")
    void enterLatinLettersInMonth() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthLatinLetters();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorMonth();
    }

    @Test
    @DisplayName("Payment by card. Enter two zeros in the Month field")
    void enterTwoZeroInMonth() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthTwoZero();
        var validYear = DateHelper.Year.yearOneMore();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorMonth();
    }

    @Test
    @DisplayName("Payment by card. Enter the number 13 in the Month field")
    void enterThirteenNumbInMonth() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthThirteen();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorShelfLifeMonth();
    }

    @Test
    @DisplayName("Payment by card. Entering three digits in the Month field")
    void enterThreeNumbsInMonth() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthThreeNumbers();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorShelfLifeMonth();
    }

    @Test
    @DisplayName("Payment by card. Entering special characters in the Month field")
    void enterSpecialCharactersInMonth() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthSpecialCharset();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorMonth();
    }

    @Test
    @DisplayName("Payment by card. Sending an empty field Month")
    void noEnterInMonth() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthNothing();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorMonth();
    }

    @Test
    @DisplayName("Payment by card. Enter a year in the Year field that is 5 years older than the current year")
    void enterFiveMoreInYear() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearFiveMore();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldSuccessfully();
        main.shouldAPPROVED();
    }

    @Test
    @DisplayName("Payment by card. Enter a year in the Year field that is 6 years older than the current year")
    void enterSixMoreInYear() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearSixMore();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorShelfLifeYear();
    }

    @Test
    @DisplayName("Payment by card. Enter the year in the Year field, which is 1 year less than the current year")
    void enterOneLessInYear() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearLessOne();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorExpiredYear();
    }

    @Test
    @DisplayName("Payment by card. Enter Latin letters in the Year field")
    void enterLatinLettersInYear() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearLatinLetters();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorYear();
    }

    @Test
    @DisplayName("Payment by card. Entering one digit in the Year field")
    void enterOneDigitInYear() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearOneNumb();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorYear();
    }

    @Test
    @DisplayName("Payment by card. Sending an empty field Year")
    void noEnterInYear() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearNothing();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorYear();
    }

    @Test
    @DisplayName("Payment by card. Entering Cyrillic letters in the Owner field")
    void enterCyrillicInOwner() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerNameCyrillic();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorCVC();
    }

    @Test
    @DisplayName("Payment by card. Entering numbers in the Owner field")
    void enterNumbsInOwner() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerMoreNumbers();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorCVC();
    }

    @Test
    @DisplayName("Payment by card. Entering special characters in the Owner field")
    void enterCharactersInOwner() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerMoreCharset();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorCVC();
    }

    @Test
    @DisplayName("Payment by card. Sending an empty field Owner")
    void noEnterInOwner() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcValid();
        var validOwner = DateHelper.Owner.ownerNothing();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorRequiredToCompleteOwner();
    }

    @Test
    @DisplayName("Payment by card. Enter Latin letters in the CVC/CVV field")
    void enterLatinLettersInCVC() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcLatinLetter();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorCVC();
    }

    @Test
    @DisplayName("Payment by card. Entering 4 digits in the CVC/CVV field")
    void enterFourNumbsInCVC() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcFourNumb();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldSuccessfully();
        main.shouldAPPROVED();
    }

    @Test
    @DisplayName("Payment by card. Entering one digit in the CVC/CVV field")
    void enterOneNumbInCVC() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcOneNumb();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorCVC();
    }

    @Test
    @DisplayName("Payment by card. Enter 3 zeros in the CVC/CVV field")
    void enterThreeZeroInCVC() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcThreeZero();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorCVC();
    }

    @Test
    @DisplayName("Payment by card. Entering special characters in the CVC/CVV field")
    void enterCharactersInCVC() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcCharset();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorCVC();
    }

    @Test
    @DisplayName("Payment by card. Sending an empty CVC/CVV field")
    void noEnterInCVC() {
        var validNumbCard = DateHelper.NumbCard.numbCardApproved();
        var validMonth = DateHelper.Month.monthValid();
        var validYear = DateHelper.Year.yearValid();
        var validCVC = DateHelper.CVC.cvcNothing();
        var validOwner = DateHelper.Owner.ownerName();

        MainPage main = new MainPage();
        main.inputNumbCard(validNumbCard, validMonth, validYear, validOwner, validCVC);
        main.shouldErrorCVC();
    }
}

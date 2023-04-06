package data;

import com.github.javafaker.Faker;;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateHelper {

    @Value
    public static class CardInfo {
        private String numbCard;
        private String year;
        private String month;
        private String owner;
        private String cvc;
    }

    public static String numbCardApproved() {
        return "1111 2222 3333 4444";
    }

    public static String numbCardDeclined() {
        return "5555 6666 7777 8888";
    }

    public static String numbCardMoreZeroNumb() {
        return "0000 0000 0000 0000";
    }

    public static String numbCardLatinLetters() {
        Faker faker = new Faker();
        return faker.lorem().word();
    }

    public static String oneNumberField() {
        Faker faker = new Faker();
        return Integer.toString(faker.random().nextInt(10));
    }

    public static String numbCardMoreNumbers() {
        Faker faker = new Faker();
        String numb = faker.finance().creditCard();
        String numbMore = Integer.toString(faker.random().nextInt(10));
        return (numb) + (numbMore);
    }

    public static String yearDate(int numberYear, String pattern) {
        return LocalDate.now().plusYears(numberYear).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String latinLetters(int number) {
        Faker faker = new Faker();
        return faker.regexify("[A-Z]{" + number + "}");
    }

    public static String monthValid(int numberMonth, String pattern) {
        return LocalDate.now().plusMonths(numberMonth).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String monthTwoZero() {
        return "00";
    }

    public static String nothingField() {
        return "";
    }

    public static String monthThirteen() {
        return "13";
    }

    public static String monthThreeNumbers() {
        Faker faker = new Faker();
        return Integer.toString(faker.random().nextInt(130, 999));
    }

    public static String charactersField(int numberCharacters) {
        Faker faker = new Faker();
        return faker.regexify("[!@#$%^&*-_+=()<>]{" + numberCharacters + "}");
    }

    public static String ownerName(String location) {
        Faker faker = new Faker(new Locale(location));
        return faker.name().firstName() + faker.name().lastName();
    }

    public static String ownerMoreNumbers() {
        Faker faker = new Faker();
        int random = faker.random().nextInt(10);
        return Integer.toString(random += random);
    }

    public static String charactersRandomOwner() {
        Faker faker = new Faker();
        int random = faker.random().nextInt(10);
        return faker.regexify("[!@#$%^&*-_+=()<>]{" + random + "}");
    }

    public static String cvcValid() {
        Faker faker = new Faker();
        return Integer.toString(faker.number().numberBetween(100, 999));
    }

    public static String cvcThreeZero() {
        return "000";
    }

    public static String cvcFourNumb() {
        Faker faker = new Faker();
        return Integer.toString(faker.random().nextInt(1000, 9999));
    }
}


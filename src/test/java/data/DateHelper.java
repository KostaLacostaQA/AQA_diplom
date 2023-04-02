package data;

import com.github.javafaker.Faker;;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateHelper {


    private DateHelper() {
    }

    @Value
    public static class NumbCard {

        private String numbCard;

        public static NumbCard numbCardApproved() {
            return new NumbCard("1111 2222 3333 4444");
        }

        public static NumbCard numbCardDeclined() {
            return new NumbCard("5555 6666 7777 8888");
        }

        public static NumbCard numbCardMoreZeroNumb() {
            return new NumbCard("0000 0000 0000 0000");
        }

        public static NumbCard numbCardNothing() { return  new NumbCard("");}

        public static NumbCard numbCardLatinLetters() {
            Faker faker = new Faker();
            return new NumbCard(faker.lorem().word());
        }

        public static NumbCard numbCardSpecialCharset() {
            Faker faker = new Faker();
            return new NumbCard(faker.regexify("[!@#$%^&*-_+=()<>]{16}"));
        }

        public static NumbCard numbCardSingleNumb() {
            Faker faker = new Faker();
            return new NumbCard(Integer.toString(faker.random().nextInt(10)));
        }

        public static NumbCard numbCardMoreNumbers() {
            Faker faker = new Faker();
            String numb = faker.finance().creditCard();
            String numbMore = Integer.toString(faker.random().nextInt(10));
            return new NumbCard((numb) + (numbMore));
        }
    }

    @Value
    public static class Year {

        private String year;

        public static Year yearValid() {
            String year = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
            return new Year(year);
        }

        public static Year yearFiveMore() {
            String years = LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("yy"));
            return new Year((years));
        }

        public static Year yearSixMore() {
            String years = LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
            return new Year(years);
        }

        public static Year yearOneMore() {
            String years = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
            return new Year(years);
        }

        public static Year yearLessOne() {
            String years = LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
            return new Year(years);
        }

        public static Year yearLatinLetters() {
            Faker faker = new Faker();
            return new Year(faker.regexify("[A-Z]{2}"));
        }

        public static Year yearOneNumb() {
            Faker faker = new Faker();
            return new Year(Integer.toString(faker.random().nextInt(10)));
        }

        public static Year yearNothing() {
            return new Year("");
        }

    }

    @Value
    public static class Month {

        private String month;

        public static Month monthValid() {
            Faker faker = new Faker();
            int result = faker.number().numberBetween(1, 12);
            int nowYear = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yy")));
            int nowMonth = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("MM")));
            int validYear = Integer.parseInt(Year.yearValid().year);
            for (int i = 0; i < 12; i++) {
                if (validYear == nowYear && result < nowMonth)  {
                    result++;
                }
            }
            return new Month(String.format("%02d", result));
        }

        public static Month monthTwoZero() {
            return new Month("00");
        }

        public static Month monthNothing() {
            return new Month("");
        }

        public static Month monthThirteen() {
            return new Month("13");
        }

        public static Month monthLatinLetters() {
            Faker faker = new Faker();
            return new Month(faker.regexify("[A-Z]{2}"));
        }

        public static Month monthThreeNumbers() {
            Faker faker = new Faker();
            return new Month(Integer.toString(faker.random().nextInt(130, 999)));
        }

        public static Month monthSpecialCharset() {
            Faker faker = new Faker();
            return new Month(faker.regexify("[!@#$%^&*-_+=()<>]{2}"));
        }
    }

    @Value
    public static class Owner {

        private String owner;

        public static Owner ownerName() {
            Faker faker = new Faker(new Locale("en"));
            return new Owner(faker.name().firstName() + faker.name().lastName());
        }

        public static Owner ownerNameCyrillic() {
            Faker faker = new Faker(new Locale("ru"));
            return new Owner(faker.name().firstName() + faker.name().lastName());
        }

        public static Owner ownerMoreNumbers() {
            Faker faker = new Faker();
            int random = faker.random().nextInt(10);
            return new Owner(Integer.toString(random += random));
        }

        public static Owner ownerMoreCharset() {
            Faker faker = new Faker();
            int random = faker.random().nextInt(10);
            return new Owner(faker.regexify("[!@#$%^&*-_+=()<>]{" + random + "}"));
        }

        public static Owner ownerNothing() {
            return new Owner("");
        }
    }

    @Value
    public static class CVC {
        private String cvc;

        public static CVC cvcValid() {
            Faker faker = new Faker();
            return new CVC(Integer.toString(faker.number().numberBetween(100, 999)));
        }

        public static CVC cvcThreeZero() {
            return new CVC("000");
        }

        public static CVC cvcLatinLetter() {
            Faker faker = new Faker();
            return new CVC(faker.regexify("[A-Z]{3}"));
        }

        public static CVC cvcFourNumb() {
            Faker faker = new Faker();
            return new CVC(Integer.toString(faker.random().nextInt(1000, 9999)));
        }

        public static CVC cvcOneNumb() {
            Faker faker = new Faker();
            return new CVC(Integer.toString(faker.random().nextInt(10)));
        }

        public static CVC cvcCharset() {
            Faker faker = new Faker();
            return new CVC(faker.regexify("[!@#$%^&*-_+=()<>]{3}"));
        }

        public static CVC cvcNothing() {
            return new CVC("");
        }
    }
}

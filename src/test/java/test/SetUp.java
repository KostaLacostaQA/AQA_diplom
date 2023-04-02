package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DBInteraction;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class SetUp {

    @BeforeEach
    void setUp() {
        open("http://localhost:8080/");
        DBInteraction.deleteUser();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownALl() {
        SelenideLogger.removeListener("allure");
    }
}

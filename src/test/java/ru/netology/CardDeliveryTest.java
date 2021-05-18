package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    void shouldTest() throws InterruptedException {
        String date = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Улан-Удэ");
        $(".calendar-input__custom-control input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $(".calendar-input__custom-control input").setValue(date);
        $("[name='name']").setValue("Криштиану Месси");
        $("[name='phone']").setValue("+79240000000");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id=notification]").waitUntil(visible, 15000).shouldHave(text("Встреча успешно забронирована на " + date));

    }
}

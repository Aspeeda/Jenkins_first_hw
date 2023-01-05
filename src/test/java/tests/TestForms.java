package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TestData;

import static io.qameta.allure.Allure.step;

@Epic("Jenkins")
@Story("Refactor test with Jenkins")
public class TestForms extends TestBase {

    @Test
    @Tag("registration")
    @DisplayName("Test filling form")
    void successfulRegistrationTest() {

        step("Зайти на страницу формы", () -> registrationPage.openPage());

        step("Заполнение полей формы", ()-> registrationPage.setName(TestData.name)
        .setSurName(TestData.surname)
        .setEmail(TestData.email)
        .setGender(TestData.gender)
        .setPhone(TestData.phNumber)
        .setBirthdate(TestData.day, TestData.month, TestData.year)
        .setSubject(TestData.subject)
        .setHobby(TestData.hobby)
        .uploadPic("img/" + TestData.picPath)
        .setAddress(TestData.address)
        .selectState(TestData.state)
        .selectCity(TestData.city)
        .clickSubmit());

        step("Проверка вывода значений из полей",() -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", TestData.name + " " + TestData.surname)
                    .verifyResult("Student Email", TestData.email)
                    .verifyResult("Gender", TestData.gender)
                    .verifyResult("Mobile", TestData.phNumber)
                    .verifyResult("Date of Birth", TestData.day + " " + TestData.month + "," + TestData.year)
                    .verifyResult("Subjects", TestData.subject)
                    .verifyResult("Hobbies", TestData.hobby)
                    .verifyResult("Picture", TestData.picPath)
                    .verifyResult("Address", TestData.address)
                    .verifyResult("State and City", TestData.state + " " + TestData.city);
        });
    }
}
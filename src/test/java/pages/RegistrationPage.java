package pages;

import components.CalendarComponent;
import components.VerifyModalResults;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    components.CalendarComponent CalendarComponent = new CalendarComponent();
    components.VerifyModalResults VerifyModalResults = new VerifyModalResults();
    /**
     * <b>КОНСТАНТЫ</b>
     */
    private final String TITLE = "Student Registration Form";

    /**
     * <b>Кнопка 'Подтвердить'</b>
     */
    public void clickSubmit() {
        $("#submit").click();
    }

    /**
     * <b>Открытие страницы, удаление рекламы</b>
     */
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    /**
     * <b>РАЗЛИЧНЫЕ МЕТОДЫ</b> <br><br>
     *
     * <b>Заполнить поле 'Имя'</b>
     */
    public RegistrationPage setName(String name) {
        $("#firstName").setValue(name);
        return this;
    }

    /**
     * <b>Заполнить поле 'Фамилия'</b>
     */
    public RegistrationPage setSurName(String surname) {
        $("#lastName").setValue(surname);
        return this;
    }

    /**
     * <b>Заполнить поле 'Email'</b>
     */
    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    /**
     * <b>Заполнить поле 'пол'</b>
     */
    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    /**
     * <b>Заполнить поле 'номер телефона'</b>
     */
    public RegistrationPage setPhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }

    /**
     * <b>Заполнить 'Дату рождения'</b>
     */
    public RegistrationPage setBirthdate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }

    /**
     * <b>Заполнить поле 'предмет'</b>
     */
    public RegistrationPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    /**
     * <b>Заполнить поле 'Хобби'</b>
     */
    public RegistrationPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    /**
     * <b>Загрузить картинку'</b>
     */
    public RegistrationPage uploadPic(String picPath) {
        $("#uploadPicture").uploadFromClasspath(picPath);
        return this;
    }

    /**
     * <b>Заполнить поле 'Адрес'</b>
     */
    public RegistrationPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    /**
     * <b>Выбрать штат</b>
     */
    public RegistrationPage selectState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    /**
     * <b>Выбрать город</b>
     */
    public RegistrationPage selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        VerifyModalResults.verifyModalAppears();

        return this;
    }
    /**
     * <b>Проверка введенных данных</b>
     */
    public RegistrationPage verifyResult(String key, String value) {
        VerifyModalResults.verifyResult(key, value);
        return this;
    }
}


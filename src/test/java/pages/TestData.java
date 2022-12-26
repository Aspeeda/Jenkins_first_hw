package pages;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestData {
    static Faker faker = new Faker();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    static String[] birthday = dateFormat.format(faker.date().birthday()).split(" ");

    public static String name = faker.name().firstName(),
            email = faker.internet().emailAddress(),
            surname = faker.name().lastName(),
            phNumber = faker.phoneNumber().subscriberNumber(10),
            subject = "English",
            address = faker.address().fullAddress(),
            gender = "Male",
            day = birthday[0],
            month = birthday[1],
            year = birthday[2],
            hobby = "Sports",
            state = "NCR",
            city = "Delhi",
            picPath = "1.jpg";
}

package userData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class OrderDate {

    public static Faker fakerRU = new Faker(new Locale("ru"));
    public static Faker fakerUS = new Faker(new Locale("en-US"));
    public static String registeredEmail = "fff@1r.ru";
    public static String InvalidAddressEmail = "dasdasd";
    public static String newEmail = fakerUS.internet().emailAddress();
    public static String newPhone = fakerRU.phoneNumber().subscriberNumber(9);
    public static String newName = fakerRU.name().firstName();
}

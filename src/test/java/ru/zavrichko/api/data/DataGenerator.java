package ru.zavrichko.api.data;

import com.github.javafaker.Faker;
import ru.zavrichko.api.models.Pet;
import ru.zavrichko.api.models.User;
import ru.zavrichko.api.models.Order;

public class DataGenerator {
    public static User getUser(int minimumLength, int maximumLength, boolean includeUppercase,
                                  boolean includeSpecial, boolean includeDigit) {
        Faker faker = new Faker();
        return User.builder()
                .id(faker.hashCode())
                .userName(faker.name().username())
                .firstName(faker.name().username())
                .lastName(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password(minimumLength, maximumLength, includeUppercase,
                        includeSpecial, includeDigit))
                .phone(faker.phoneNumber().phoneNumber())
                .userStatus(faker.hashCode())
                .build();
    }

    public static Order getOrder(int minimumLength, int maximumLength, boolean includeUppercase,
                                    boolean includeSpecial, boolean includeDigit) {
        Faker faker = new Faker();
        return Order.builder()
                .id(faker.hashCode())
                .petId(faker.hashCode())
                .quantity(faker.hashCode())
                .shipDate("1976-04-23T15:41:21.141+0000")
                .status("placed")
                .complete(true)
                .build();
    }

    public static Pet getPet(int minimumLength, int maximumLength, boolean includeUppercase,
                                boolean includeSpecial, boolean includeDigit) {
        Faker faker = new Faker();
        return Pet.builder()
                .id(faker.hashCode())
                .name(faker.name().name())
                .status("placed")
                .build();
    }
}

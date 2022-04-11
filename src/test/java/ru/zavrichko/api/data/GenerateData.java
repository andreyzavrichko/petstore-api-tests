package ru.zavrichko.api.data;

import com.github.javafaker.Faker;
import ru.zavrichko.api.models.NewPet;
import ru.zavrichko.api.models.NewUser;
import ru.zavrichko.api.models.NewOrder;

public class GenerateData {
    public static NewUser getUser(int minimumLength, int maximumLength, boolean includeUppercase,
                                  boolean includeSpecial, boolean includeDigit) {
        Faker faker = new Faker();
        return NewUser.builder()
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

    public static NewOrder getOrder(int minimumLength, int maximumLength, boolean includeUppercase,
                                    boolean includeSpecial, boolean includeDigit) {
        Faker faker = new Faker();
        return NewOrder.builder()
                .id(faker.hashCode())
                .petId(faker.hashCode())
                .quantity(faker.hashCode())
                .shipDate("1976-04-23T15:41:21.141+0000")
                .status("placed")
                .complete(true)
                .build();
    }

    public static NewPet getPet(int minimumLength, int maximumLength, boolean includeUppercase,
                                boolean includeSpecial, boolean includeDigit) {
        Faker faker = new Faker();
        return NewPet.builder()
                .id(faker.hashCode())
                .name(faker.name().name())
                .status("placed")
                .build();
    }

}

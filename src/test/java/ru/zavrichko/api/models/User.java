package ru.zavrichko.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;


    @Override
    public String toString() {
        return "{ \"id\": \"" + id + "\", \"username\": \"" + userName + "\", \"firstName\": \"" + firstName + "\", " +
                "\"lastName\": \"" + lastName + "\", \"email\": \"" + email + "\", \"password\": \"" + password + "\"," +
                " \"phone\": \"" + phone + "\", \"userStatus\": \"" + userStatus + "\" }";
    }
}


package ru.zavrichko.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Integer id;
    private Integer userStatus;
    private String email;
    private String phone;
    private String firstName;
    private String username;
    private String lastName;
    private String password;
}

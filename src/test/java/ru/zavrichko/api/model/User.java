package ru.zavrichko.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Integer id;
    private Integer userStatus;
    private String email;
    private String phone;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("username")
    private String username;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("password")
    private String password;
}

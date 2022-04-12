package ru.zavrichko.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {
    private Integer id;
    private String name;
    private String status;


    @Override
    public String toString() {
        return "{ \"id\": \"" + id + "\", \"name\": \"" + name + "\", \"status\": \"" + status + "\" }";
    }
}

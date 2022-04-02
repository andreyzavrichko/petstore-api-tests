package ru.zavrichko.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrder {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;


    @Override
    public String toString() {
        return "{ \"id\": \"" + id + "\", \"petId\": \"" + petId + "\", \"quantity\": \"" + quantity + "\", \"shipDate\": \"" + shipDate + "\", \"status\": \"" + status + "\", \"complete\": \"" + complete + "\" }";
    }
}

package com.example.rest_API.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    private String nameValue;

    private String number;

    @JsonProperty("user_email") //사용할 임의의 문장지정
    private String email;

    private Boolean isKorean;


    @JsonIgnore
    public String getNameValue() {
        return nameValue;
    }
}

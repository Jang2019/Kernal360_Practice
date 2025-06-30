package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserRegisterRequest {


    private String name;

    private String Nickname;

    @NotBlank
    @Size(min = 1, max = 12)
    private String password;

    @NotNull
    @Max(100)
    @Min(1)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
    //@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 형식이 맞지 않는다")
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @YearMonth(pattern = "yyyy-MM")
    private String yearMonth;

    @AssertTrue(message = "name or Nickname 은 존재 필요")
    public boolean nameCheck(){

        if(!name.isBlank()){
            return true;
        }

        if(!Nickname.isBlank()){
            return true;
        }

        return false;
    }
}

package com.example.rest_API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String name;

    private String number;

    private String category;
}

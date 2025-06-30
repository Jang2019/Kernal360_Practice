package com.example.rest_API.controller;

import com.example.rest_API.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping(path = "")
    //@ResponseBody
    public ResponseEntity<UserRequest> user(){ //임의로 커스텀 해서 응답 보내기
        var user = new UserRequest();
        user.setNameValue("홍길동");
        user.setNumber("10");
        user.setEmail("jang@naver.com");

        log.info("user: {}",user);

        var response = ResponseEntity
                .status(HttpStatus.CREATED)
                .header("x-custom","hi")
                .body(user);
        return response;
    }
}

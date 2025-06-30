package com.example.rest_API.controller;

import com.example.rest_API.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController //Rest컨트롤러 역활을 하게 해주는 것
@RequestMapping("/api") //이 형태의 주소를 받아들이겠다는 것
public class RestApiController {

    @GetMapping(path = "/hello") //하위 주소를 처리하는 것
    public String hello(){
        var html = "<html> <body> <h1> Hello </h1> </body> </html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}/num/{num}/is-man/{isMan}")
    public String echo(@PathVariable(name = "message") String msg,
                       @PathVariable int num,
                       @PathVariable boolean isMan){
        System.out.println("echo message" +msg.toUpperCase());
        System.out.println(isMan);
        return msg.toUpperCase();
    }

    @GetMapping(path = "/book")
    public void queryParam(@RequestParam String num,@RequestParam String num2){
        System.out.println(num);
        System.out.println(num2);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(BookQueryParam bookQueryParam){
        System.out.println(Integer.parseInt(bookQueryParam.getNum()) + Integer.parseInt(bookQueryParam.getNum2()));

    }

    @DeleteMapping(path = {"/user/{userName}/delete","/user/{userName}/del"})
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}",userName);
    }

}

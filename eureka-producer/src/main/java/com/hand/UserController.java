package com.hand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @GetMapping("/hi")
    public String SayHi(){
        return "hi, i'm ben";
    }


}

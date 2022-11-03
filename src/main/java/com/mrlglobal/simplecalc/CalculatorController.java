package com.mrlglobal.simplecalc;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
    @PostMapping("/calc")
    CalculatorOperation Calc(@RequestBody CalculatorOperation operation){
        return operation;
    }

}

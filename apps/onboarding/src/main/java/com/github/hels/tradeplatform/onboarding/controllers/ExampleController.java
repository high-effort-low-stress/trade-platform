package com.github.hels.tradeplatform.onboarding.controllers;

import com.github.hels.tradeplatform.onboarding.models.ExampleModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExampleController {
    @GetMapping("test")
    public String get(){
        var a = new ExampleModel();
        a.setAttribute("attribute");
        log.info("{}", a);
        return "Olá mundo";
    }
}

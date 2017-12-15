package org.lynn.springboot.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello2")
public class Hello2Controller {
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(){
        return "index";
    }
}

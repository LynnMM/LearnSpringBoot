package org.lynn.springboot.girl.controller;

import org.lynn.springboot.girl.config.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private PersonProperties person;

    @RequestMapping(value = {"/say", "/hi"}, method = RequestMethod.GET)
    public String say(){
        return person.getName();
    }

    @RequestMapping(value = {"/say2/{id}", "/{id}/say2"}, method = RequestMethod.GET)
    public String say2(@PathVariable("id") Integer id){
        return "id: " + id;
    }

    //@PutMapping
    //@DeleteMapping
    //@PostMapping
    @GetMapping(value = "/say3")
    public String say3(){
        return person.getName();
    }
}

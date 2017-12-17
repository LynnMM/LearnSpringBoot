package org.lynn.springboot.girl.controller;

import org.lynn.springboot.girl.GirlApplication;
import org.lynn.springboot.girl.dal.PersonRepository;
import org.lynn.springboot.girl.model.Person;
import org.lynn.springboot.girl.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    /**
     * 查询所有Person
     * @return
     */
    @GetMapping(value = "/all")
    public List<Person> personList(){
        return personRepository.findAll();
    }

    /**
     * 添加一个Person
     * @param name
     * @param age
     */
    @PostMapping(value = "/add")
    public Person addPerson(@RequestParam("name") String name, @RequestParam("age") Integer age){
        Person p = new Person();
        p.setName(name);
        p.setAge(age);

        return personRepository.save(p);
    }

    /**
     * 查询一个Person
     * @param id
     * @return
     */
    @GetMapping(value = "/get/{id}")
    public Person getPerson(@PathVariable("id") Integer id){
        return personRepository.findOne(id);
    }

    /**
     * 通过年龄查询Person
     * @param age
     * @return
     */
    @GetMapping(value = "/get/age/{age}")
    public List<Person> getPersonListByAge(@PathVariable("age") Integer age){
        return personRepository.findByAge(age);
    }

    /**
     * 更新一个person
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public Person updatePerson(@PathVariable("id") Integer id,
                             @RequestParam("name") String name,
                             @RequestParam("age") Integer age){
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setAge(age);
        return personRepository.save(p);
    }

    /**
     * 删除一个Person
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void deletePerson(@PathVariable("id") Integer id){
        personRepository.delete(id);
    }

    @PostMapping(value = "/insert2")
    public void insertTwoPerson(){
        personService.insertTwoPerson();
    }
}

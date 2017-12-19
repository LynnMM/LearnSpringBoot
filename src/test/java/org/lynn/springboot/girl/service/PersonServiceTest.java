package org.lynn.springboot.girl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lynn.springboot.girl.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Test
    public void getPersonByIdTest(){
        Person person = personService.getPersonById(2);
        assertEquals(new Integer(13), person.getAge());
    }
}

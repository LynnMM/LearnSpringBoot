package org.lynn.springboot.girl.service;

import org.lynn.springboot.girl.dal.PersonRepository;
import org.lynn.springboot.girl.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void insertTwoPerson(){
        Person pA = new Person();
        pA.setName("Moris");
        pA.setAge(24);
        personRepository.save(pA);

        Person pB = new Person();
        pB.setName("Lyn");
        pB.setAge(24);
        personRepository.save(pB);
    }
}

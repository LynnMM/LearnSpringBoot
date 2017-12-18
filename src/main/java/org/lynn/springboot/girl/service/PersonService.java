package org.lynn.springboot.girl.service;

import org.lynn.springboot.girl.dao.PersonDao;
import org.lynn.springboot.girl.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public void insertTwoPerson(){
        Person pA = new Person();
        pA.setName("Moris");
        pA.setAge(24);
        personDao.save(pA);

        Person pB = new Person();
        pB.setName("Lyn");
        pB.setAge(24);
        personDao.save(pB);
    }
}

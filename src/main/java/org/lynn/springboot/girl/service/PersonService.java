package org.lynn.springboot.girl.service;

import org.lynn.springboot.girl.dao.PersonDao;
import org.lynn.springboot.girl.domain.Person;
import org.lynn.springboot.girl.enums.ResultEnum;
import org.lynn.springboot.girl.exception.PersonException;
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

    public void getAge(Integer id) throws PersonException{
        Person person = personDao.findById(id);
        Integer age = person.getAge();
        if (age < 10){
            throw new PersonException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16){
            throw new PersonException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Id查询Person的信息
     * @param id
     * @return
     */
    public Person getPersonById(Integer id){
        return personDao.findById(id);
    }
}

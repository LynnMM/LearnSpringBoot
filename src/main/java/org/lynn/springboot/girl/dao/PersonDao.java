package org.lynn.springboot.girl.dao;

import org.lynn.springboot.girl.domain.Person;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PersonDao extends Repository<Person, Integer> {

    /**
     * 保存一个Person
     * @param person
     * @return
     */
    public Person save(Person person);

    /**
     * 查询所有Person
     * @return
     */
    public List<Person> findAll();


    /**
     * 通过Id查询
     * @param id
     * @return
     */
    public Person findById(Integer id);

    /**
     * 通过年龄来查询
     * @param age
     * @return
     */
    public List<Person> findByAge(Integer age);

    /**
     * 通过id删除person
     * @param id
     */
    public void delete(Integer id);
}

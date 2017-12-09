package com.glory.service.impl;

import com.glory.entity.Person;
import com.glory.dao.PersonRepository;
import com.glory.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XRom
 * On 11/16/2017.11:58 PM
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired(required = true)
    private PersonRepository personRepository;

    @Override
    public Long savePerson() {
        Person person = new Person();
        person.setUsername("黄凌淞");
        person.setPhone("18408287865");
        person.setAddress("chenDu");
        person.setRemark("this is Test");
        return personRepository.save(person);
    }
}

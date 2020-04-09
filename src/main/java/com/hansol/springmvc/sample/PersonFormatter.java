package com.hansol.springmvc.sample;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;


import java.text.ParseException;
import java.util.Locale;

//@Component
public class PersonFormatter implements Formatter<Person> {

    @Override
    public Person parse(String param, Locale locale) throws ParseException {
        Person person = new Person();
        person.setName(param);
        return person;
    }

    @Override
    public String print(Person person, Locale locale) {
        return person.toString();
    }
}

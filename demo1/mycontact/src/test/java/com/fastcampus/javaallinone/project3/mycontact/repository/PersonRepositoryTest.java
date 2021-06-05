package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest // 스프링부트 테스트임을 명시
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    //personRepository Bean을 주입해줌
    
    @Test
    void crud(){
        Person person = new Person();
        // 1. 해시값이 출력되는 이유? toString이 오버라이딩 안되었기 때문
        // 2. 각 필드값을 입력 불가: getter/setter 만들어줘야함

        person.setName("kim");
        person.setAge(10);
        person.setBloodType("A");

        personRepository.save(person);

        System.out.println(personRepository.findAll());

// 3. 해당 데이터값들을 자동으로 체크하도록(검증) 만들기
        List<Person> people = personRepository.findAll();

        Assertions.assertEquals(people.size(),1);
        Assertions.assertEquals(people.get(0).getName(),"kim");
        Assertions.assertEquals(people.get(0).getAge(),10);
        Assertions.assertEquals(people.get(0).getBloodType(),"A");
    }
    @Test
    void hashCodeAndEquals(){
        Person person1 = new Person("kim",10);
        Person person2= new Person("kim",10);

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }
}
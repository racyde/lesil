package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Transactional      // 자동롤백되도록~
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

        person.setName("john");
        person.setAge(10);
        person.setBloodType("A");

        personRepository.save(person);


// 3. 해당 데이터값들을 자동으로 체크하도록(검증) 만들기
        List<Person> result = personRepository.findByName("john");

        Assertions.assertEquals(result.size(),1);
        Assertions.assertEquals(result.get(0).getName(),"john");
        Assertions.assertEquals(result.get(0).getAge(),10);
        Assertions.assertEquals(result.get(0).getBloodType(),"A");

    }

    @Test
    void findByBloodType(){ // findByBloodType 쿼리메서드 테스트

//        givenPerson("John",5,"A");

        List<Person> result = personRepository.findByBloodType("A");

//        Assertions.assertEquals(result.size(),0);
//        Assertions.assertEquals(result.get(0).getName(),"martin");
//        Assertions.assertEquals(result.get(1).getName(),"benny");


    }

    //메서드 오버로딩
    private void givenPerson(String name, int age, String bloodType){
        givenPerson(name,age,bloodType,null);
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday){

        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthday));   // 필수값은 아니므로 setter로 넣음
        personRepository.save(person);
    }


    @Test
    void findByBirthdayBetween(){// findByBirthdayBetween 쿼리메서드 테스트
        givenPerson("kim",10,"A",LocalDate.of(1991,8,15));
        givenPerson("lee",9,"B",LocalDate.of(1992,7,10));
        givenPerson("denis",8,"O",LocalDate.of(1993,1,5));
        givenPerson("sophia",7,"AB",LocalDate.of(1994,6,30));
        givenPerson("benny",6,"A",LocalDate.of(1995,8,30));

        List<Person> result = personRepository.findByMonthOfBirthDay(8);

        result.forEach(System.out::println);
    }

}
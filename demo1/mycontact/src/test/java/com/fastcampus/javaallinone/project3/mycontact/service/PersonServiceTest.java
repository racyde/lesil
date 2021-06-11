package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;


    @Test
    void getPeopleExcludeBlocks(){  // 이것도 쿼리 메서드를 이용해서 간략화 해보자
    //블럭되지 않은 사람들
        givenPeople();
//        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

    //stream을 통해서 뿌리는 식으로 표현해보자
        result.forEach(System.out::println);

//        Assertions.assertEquals(result.size(),2);
        Assertions.assertEquals(result.get(0).getName(),"kim");
        Assertions.assertEquals(result.get(1).getName(),"lee");
    }

    @Test
    void getPeopleByName(){ // 이름을 조건으로 Person들을 가져오는 메서드 생성
        givenPeople();

        List<Person> result = personService.getPeopleByName("kim");

        result.forEach(System.out::println);
//        Assertions.assertEquals(result.size(),2);
//        Assertions.assertEquals(result.get(0).getName(),"kim");

    }



//    private void givenBlocks() {
//        givenBlock("kim");
//    }

//    private Block givenBlock(String name) { //Block을 리턴하도록...
//        return blockRepository.save(new Block(name));
//    }



    @Test
    void getPerson(){
        givenPeople();

        Person person = personService.getPerson(3L);

//        Assertions.assertEquals(person.getName(),"oh");
    }


    private void givenPeople() {
        givenPerson("kim",10,"A");
        givenPerson("lee",9,"B");
        givenBlockPerson("oh",7,"AB");
        givenBlockPerson("kim",11,"O"); // 얘만 블락되도록 코딩
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name,age,bloodType));
    }

    private void givenBlockPerson(String name,int age, String bloodType){

        Person blockPerson = new Person(name,age,bloodType);
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);
    }

}
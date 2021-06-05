package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks(){

        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

//        System.out.println(result);
    //stream을 통해서 뿌리는 식으로 표현해보자
        result.forEach(System.out::println);

    }

    private void givenBlocks() {
        givenBlock("kim");
    }

    private Block givenBlock(String name) { //Block을 리턴하도록...
        return blockRepository.save(new Block(name));
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
        blockPerson.setBlock(givenBlock(name));
        personRepository.save(blockPerson);
    }

}
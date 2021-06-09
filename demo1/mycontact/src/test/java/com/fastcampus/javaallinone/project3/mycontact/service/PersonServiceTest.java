package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
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
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks(){  // 이것도 쿼리 메서드를 이용해서 간략화 해보자

        givenPeople();
//        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

    //stream을 통해서 뿌리는 식으로 표현해보자
        result.forEach(System.out::println);

    }

    @Test
    void getPeopleByName(){ // 이름을 조건으로 Person들을 가져오는 메서드 생성
        givenPeople();

        List<Person> result = personService.getPeopleByName("kim");

        result.forEach(System.out::println);

    }



//    private void givenBlocks() {
//        givenBlock("kim");
//    }

//    private Block givenBlock(String name) { //Block을 리턴하도록...
//        return blockRepository.save(new Block(name));
//    }

    @Test
    void cascadeTest(){ //cascade가 어떻게 동작하는지 확인용 메서드
        givenPeople();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
//        person.getBlock().setStartDate(LocalDate.now());
//        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);


        //이 person을 삭제하는 코딩
//        personRepository.delete(person);
//        personRepository.findAll().forEach(System.out::println);
//        blockRepository.findAll().forEach(System.out::println); //하지만 blockRepository에는 지운사람이 남아 있다.


        person.setBlock(null);  //블럭을 해제
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }


    @Test
    void getPerson(){
        givenPeople();

        Person person = personService.getPerson(3L);
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
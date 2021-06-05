package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service    //해당클래스가 Service Bean임을 표시
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
//    @Autowired    // 관계설정을 하여서 쓸모없어짐
//    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks(){
        List<Person> people = personRepository.findAll();

        // 이제 관계설정(relation)을 걸었으므로 이렇게 할 필요가 없다
//        List<Block> blocks = blockRepository.findAll();
        // 두 객체를 비교하여 빼고 싶은데 현재 객체가 다르므로 바로 뺄 수 없다

        //일단 Block  에 있는 name 변수값만 가져오자(스트림.map)
        // 이제 관계설정(relation)을 걸었으므로 이렇게 할 필요가 없다
//        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());
                    // Block::getName 은 String값이므로 toList를 통해 List화시킨다

        //people에서 blockNames를 빼주자(스트림.filter)
        //!(not)을 통해서 빼주기

        // 블럭데이터만 없는(null) 사람만 가져오기(filter)
        return people.stream().filter(person -> person.getBlock() ==null).collect(Collectors.toList());
    }
}

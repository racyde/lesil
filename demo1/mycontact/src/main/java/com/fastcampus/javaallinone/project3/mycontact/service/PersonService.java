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
    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks(){
        List<Person> people = personRepository.findAll();
        List<Block> blocks = blockRepository.findAll();
        // 두 객체를 비교하여 빼고 싶은데 현재 객체가 다르므로 바로 뺄 수 없다

        //일단 Block  에 있는 name 변수값만 가져오자(스트림.map)
        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());
                    // Block::getName 은 String값이므로 toList를 통해 List화시킨다

        //people에서 blockNames를 빼주자(스트림.filter)
        //!(not)을 통해서 빼주기
        return people.stream().filter(person -> !blockNames.contains(person.getName())).collect(Collectors.toList());
    }
}

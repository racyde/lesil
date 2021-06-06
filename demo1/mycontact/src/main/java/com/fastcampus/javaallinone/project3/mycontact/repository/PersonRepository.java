package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // JpaRepository를 상속 받으면 기본적으로 CRUD 인터페이스를 제공해줌
    List<Person> findByName(String name);   // find = select, By=where 의 뜻(쿼리 기준)

    List<Person> findByBlockIsNull();   // 블럭이 널값인 경우(차단이 되지않은경우)만 가져온다는 뜻

    List<Person> findByBloodType(String bloodType);

    List<Person> findByBirthdayBetween(LocalDate startDate, LocalDate endDate); //생일 기준 쿼리메서드 생성

}

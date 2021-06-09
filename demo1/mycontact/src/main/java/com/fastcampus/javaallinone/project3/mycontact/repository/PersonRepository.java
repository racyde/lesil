package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // JpaRepository를 상속 받으면 기본적으로 CRUD 인터페이스를 제공해줌
    List<Person> findByName(String name);   // find = select, By=where 의 뜻(쿼리 기준)

    List<Person> findByBlockIsNull();   // 블럭이 널값인 경우(차단이 되지않은경우)만 가져온다는 뜻

    List<Person> findByBloodType(String bloodType);

//    @Query(value = "select person from Person person where person.birthday.monthOfBirthday=?1 and person.birthday.dayOfBirthday=?2")
    //jpql: 약간은 다른 쿼리인데 엔티티 기반으로 쿼리를 실행시키는 것    ?1 : 첫번째 인자를 의미
//    List<Person> findByMonthOfBirthDay(int monthOfBirthday, int dayOfBirthday); //생일 기준 쿼리메서드 생성
    //만약에 @Query 어노테이션에서 이름 기반으로 인자(?1 부분)를 바꾸고 싶다면?  @Param 어노테이션
@Query(value = "select person from Person person where person.birthday.monthOfBirthday=:monthOfBirthday")
// @Qyuery 어노테이션 안에서는 ?1 -> :파라미터명
//  nativeQuery=true 옵션을 통해서 실제 sql 문법으로 작성 가능
    List<Person> findByMonthOfBirthDay(@Param("monthOfBirthday") int monthOfBirthday);
}

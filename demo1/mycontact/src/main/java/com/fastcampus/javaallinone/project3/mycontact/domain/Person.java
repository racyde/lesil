package com.fastcampus.javaallinone.project3.mycontact.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Person {

    @Id //해당 컬럼이 Domain Entity의 Pk임을 명시함
    @GeneratedValue //해당 컬럼의 값은 자동으로 생성되는 값임을 명시함(디폴트 전략값=auto)
    private Long id;

//    @Getter // lombok에 있는 getter//setter
//    @Setter
    private String name;


    private int age;


    private String hobby;


    private String bloodType;


    private String address;


    private LocalDate birthday; //java7부터 제공하는 날짜 객체

    private String job;

    @ToString.Exclude   // ToString 되는 것 제외하는 방법(ex. 패스워드)
    private String phoneNumber;

}

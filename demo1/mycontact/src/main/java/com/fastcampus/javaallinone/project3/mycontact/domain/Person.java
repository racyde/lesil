package com.fastcampus.javaallinone.project3.mycontact.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id //해당 컬럼이 Domain Entity의 Pk임을 명시함
    @GeneratedValue //해당 컬럼의 값은 자동으로 생성되는 값임을 명시함(디폴트 전략값=auto)
    private Long id;

    private String name;

    private int age;

    //1. 인텔리제이 자동완성화 코드 사용
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    //2. generate -getter and setter 이용

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

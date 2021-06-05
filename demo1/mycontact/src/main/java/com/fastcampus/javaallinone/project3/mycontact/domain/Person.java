package com.fastcampus.javaallinone.project3.mycontact.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Getter
//@Setter
//@ToString
@NoArgsConstructor  //인자가 없는 생성자 생성
@AllArgsConstructor
@RequiredArgsConstructor    //필요한 field variable을 @NonNull로 선언하고, 해당 파라미터를 가지는 생성자를 생성해줌
//@EqualsAndHashCode
@Data   //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode를 한꺼번에 선언해줌
public class Person {

    @Id //해당 컬럼이 Domain Entity의 Pk임을 명시함
    @GeneratedValue //해당 컬럼의 값은 자동으로 생성되는 값임을 명시함(디폴트 전략값=auto)
    private Long id;

//    @Getter // lombok에 있는 getter//setter
//    @Setter
    @NonNull
    private String name;

    @NonNull
    private int age;


    private String hobby;

    @NonNull
    private String bloodType;


    private String address;


    private LocalDate birthday; //java7부터 제공하는 날짜 객체

    private String job;

    @ToString.Exclude   // ToString 되는 것 제외하는 방법(ex. 패스워드)
    private String phoneNumber;

    //엔티티간 연관 관계 설정
    @OneToOne   //해당 Person에 대해 Block을 지정했느냐 안했느냐 이므로 1:1로
    private Block block;

}

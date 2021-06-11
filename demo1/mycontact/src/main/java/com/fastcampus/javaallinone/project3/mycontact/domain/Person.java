package com.fastcampus.javaallinone.project3.mycontact.domain;

import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import lombok.*;
import org.hibernate.annotations.Tables;

import javax.persistence.*;
import javax.validation.Valid;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //해당 컬럼의 값은 자동으로 생성되는 값임을 명시함(디폴트 전략값=auto)
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

    @Valid
    @Embedded   //다른 객체를 Entity의 속성으로 가져옴
    private Birthday birthday; //java7부터 제공하는 날짜 객체

    
    private String job;

    @ToString.Exclude   // ToString 되는 것 제외하는 방법(ex. 패스워드)
    private String phoneNumber;

    //엔티티간 연관 관계 설정
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude   // 를 해서 쿼리문을 한번만 실행되도록 --> 쿼리문 최소화
    //Person 객체에 PERSIST, MERGE, REMOVE 의 액션이 생겼을 때에 Block 엔티티도 함께 처리하겠다는 뜻
    // 이를 간략화하면 (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    // ==> CascadeType.ALL 로 정리가능
    //orphanRemoval = true => 연관 엔티티(블럭)가 해제되는 순간 해당 엔티티(블럭)가 사라짐
    //cascade => Person 엔티티에서 블록에 대한 영속성을 함께 관리하겠다는 뜻
    // fetch = FetchType.EAGER ---> 쿼리문을 보면 left outer join으로 하나의 쿼리문으로 실행됨
        //, optional = false    ---> 해당 엔티티(블럭)의 값이 항상 필요하다는 뜻
        // -->  이 경우 쿼리문을 보면  inner join 으로 하나의 쿼리문 형태로 실행됨
    //fetch = FetchType.LAZY    ---> 쿼리문을 join하지않고 따로 따로 쿼리문 실행됨(Person 엔티티, Block 엔티티)
        // .LAZY 를 하면 필요할 때만 Block 객체를 불러온다

    //해당 Person에 대해 Block을 지정했느냐 안했느냐 이므로 1:1로
    private Block block;

}

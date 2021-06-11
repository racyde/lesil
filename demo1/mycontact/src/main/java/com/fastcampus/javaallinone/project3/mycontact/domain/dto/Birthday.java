package com.fastcampus.javaallinone.project3.mycontact.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Embeddable //자기 객체를 다른 Entity의 속성으로 사용할 수 있음
@Data
@NoArgsConstructor
public class Birthday {

    // int형이므로 1~12월을 초과하는 값이 지정될 수 있으므로 이를 맞게해줘야함
    private Integer yearOfBirthday;     //int형과 달리 Integer형은 null값이 허용됨
    @Min(1)
    @Max(12)
    private Integer monthOfBirthday;
    @Min(1)
    @Max(31)
    private Integer dayOfBirthday;
    // 하지만 2월 31일같은 날은 없는 날이지만 출력되는 문제 발생...그러므로
    // 따로 LocalDate 타입으로 메서드 생성
    public Birthday(LocalDate birthday){
        this.yearOfBirthday=birthday.getYear();
        this.monthOfBirthday=birthday.getMonthValue();
        this.dayOfBirthday=birthday.getDayOfMonth();
    }

}

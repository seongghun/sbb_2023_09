package com.sbs.sbb.user;

import com.sbs.sbb.Hobby;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserAddForm {

    @NotEmpty(message = "나이는 필수항목입니다.")
    private int age;//나이

    @NotEmpty(message = "지역는 필수항목입니다.")
    private String living;//사는 지역

    private List<Hobby> hobby;//취미 여려개 추가할 수 있게 변경하기

    @NotEmpty(message = "키는 필수항목입니다.")
    private int tall; //키

    private String body_type; //체형

    private boolean smoking; //흡연 유무

    private String drinking; //음주 유무

    private String style; //스타일(성격)

    private String religion; //종교

    private String mbti; //MBTI

    private String school; //학력

    private String job; //직장
}

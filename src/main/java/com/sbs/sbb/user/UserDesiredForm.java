package com.sbs.sbb.user;

import com.sbs.sbb.Hobby;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDesiredForm {
    private int desired_age; //원하는 나이 어떻게 구현할지 다시 고민

    private String desired_living; //원하는 지역

    private List<Hobby> desired_hobby;//취미 여려개 추가할 수 있게 변경하기

    private int desired_tall; // 원하는 키 어떻게 범위 설정할지 다시 고민

    private String desired_body_type; //원하는 체형

    private boolean desired_smoking; // 원하는 흡연 유무

    private String desired_drinking; // 원하는 음주 유무

    private String desired_style; //원하는 스타일

    private String desired_religion; //원하는 종교

    private String desired_mbti; //원하는 MBTI
}

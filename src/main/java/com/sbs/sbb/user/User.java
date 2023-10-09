package com.sbs.sbb.user;

import com.sbs.sbb.Hobby;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //회원가입 할 때 기본 정보
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String nickname;
    private String gender; //성별
    //기본 프로필 기입
    private int age;//나이

    private String living;//사는 지역

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hobby> hobby;//취미 여려개 추가할 수 있게 변경하기

    private int tall; //키

    private String body_type; //체형

    private boolean smoking; //흡연 유무

    private String drinking; //음주 유무

    private String style; //스타일(성격)

    private String religion; //종교

    private String mbti; //MBTI

    private String school; //학력
    private String job; //직장
    private int desired_age; //원하는 나이 어떻게 구현할지 다시 고민
    private String desired_living; //원하는 지역
    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hobby> desired_hobby;//취미 여려개 추가할 수 있게 변경하기
    private int desired_tall; // 원하는 키 어떻게 범위 설정할지 다시 고민
    private String desired_body_type; //원하는 체형
    private boolean desired_smoking; // 원하는 흡연 유무
    private String desired_drinking; // 원하는 음주 유무
    private String desired_style; //원하는 스타일
    private String desired_religion; //원하는 종교
    private String desired_mbti; //원하는 MBTI
    //여러개를 선택해야할 때의 칼럼
}

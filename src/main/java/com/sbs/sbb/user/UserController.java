package com.sbs.sbb.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//회원가입
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        userService.create(userCreateForm.getUsername(), userCreateForm.getPassword1(),
                userCreateForm.getNickname(), userCreateForm.getGender());
        return "redirect:/";
    }
   //기본 프로필 작성
    @GetMapping("/add")
    public String add(UserAddForm userAddForm) {
        return "add_from";
    }

    @PostMapping("/add")
    public String add(@Valid UserAddForm userAddForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_form";
        }
        userService.add_profile(userAddForm.getAge(),userAddForm.getLiving(),userAddForm.getHobby(),
                userAddForm.getTall(),userAddForm.getBody_type(),userAddForm.isSmoking(),
                userAddForm.getDrinking(),userAddForm.getStyle(),userAddForm.getReligion(),
                userAddForm.getMbti(),userAddForm.getSchool(),userAddForm.getJob());
        return "redirect:/";
    }


    @GetMapping("/desired")
    public String desired(UserDesiredForm userDesiredForm) {
        return "desired_form";
    }

    @PostMapping("/desired")
    public String desired(@Valid UserDesiredForm userDesiredForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "desired_form";
        }

        userService.add_desired(userDesiredForm.getDesired_age(),userDesiredForm.getDesired_living(),
                userDesiredForm.getDesired_hobby(),userDesiredForm.getDesired_tall(),
                userDesiredForm.getDesired_body_type(),userDesiredForm.isDesired_smoking(),
                userDesiredForm.getDesired_drinking(),userDesiredForm.getDesired_style(),
                userDesiredForm.getDesired_religion(),userDesiredForm.getDesired_mbti());
        return "redirect:/";
    }

}

package com.pknu.backboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu.backboard.service.MemberService;
import com.pknu.backboard.validation.MemberForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @GetMapping("/signup")
    public String getSignUp(MemberForm memberForm) {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String setSignUp(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){

            return "member/signup";
        }
        if(!memberForm.getPassword1().equals(memberForm.getPassword2())){
            bindingResult.rejectValue("password2", "passwordIncorrect", "패스워드가 일치하지 않습니다.");
            return "member/signup";
        }

        boolean isExist = this.memberService.getExistMember(memberForm.getUsername());
        if(isExist == true){
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다");
            return "member/signup";
        }
        // 이미 존재하느 유저이름(이메일) 있으면 등록방지
        try {
            
            this.memberService.setMember(memberForm.getUsername(), memberForm.getPassword1(), memberForm.getPassword2());
        } catch(DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다");
            return "member/signup";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "member/signup";
        }
        
        return "redirect:/"; // HOME로 이동
    }

    
}

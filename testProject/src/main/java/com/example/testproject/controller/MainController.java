package com.example.testproject.controller;

import com.example.testproject.dto.MemberDto;
import com.example.testproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * packageName    : com.example.testproject.controller
 * fileName       : MainController
 * author         : 김재홍
 * date           : 24. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 13.        김재홍       최초 생성
 */
@Controller
public class MainController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/regist")
    public String regist() {
        return "registForm";
    }

    @PostMapping("/regist")
    public String registProc(MemberDto member) {

        memberService.insertMember(member);  // 회원가입

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}

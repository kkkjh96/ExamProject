package com.example.testproject.controller;

import ch.qos.logback.core.net.SMTPAppenderBase;
import com.example.testproject.dto.AnswerDto;
import com.example.testproject.dto.AnswersDto;
import com.example.testproject.dto.ExamDto;
import com.example.testproject.dto.MemberDto;
import com.example.testproject.service.ExamService;
import com.example.testproject.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * packageName    : com.example.testproject.controller
 * fileName       : ExamController
 * author         : 김재홍
 * date           : 24. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 13.        김재홍       최초 생성
 */
@Controller
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @Autowired
    MemberService memberService;

    @GetMapping("/list")
    public String examList(HttpSession session) {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        MemberDto userDetails = (MemberDto) authentication.getPrincipal();

        session.setAttribute("user", userDetails); // 로그인한 user정보를 session attribute로 저장.

        return "/exam/list";

    }

    @GetMapping("/korean")
    public String takeExam(Model model) {

        List<ExamDto> questions = examService.koreanExamList();

        model.addAttribute("questions", questions);

        return "/exam/korean";
    }

    @PostMapping("/korean")
    public String takeKorean(AnswersDto answers) {

        double score = examService.insertKoreanAnswer(answers);
        System.out.println("점수 : " + score);

        return "redirect:/exam/math";
    }

    @GetMapping("/math")
    public String takeMath(Model model) {

        List<ExamDto> questions = examService.mathExamList();

        model.addAttribute("questions", questions);

        return "/exam/math";
    }

    @PostMapping("/math")
    public String takeMath(AnswersDto answers) {

        double score = examService.insertMathAnswer(answers);
        System.out.println("점수 : " + score);

        return "redirect:/exam/history";
    }

    @GetMapping("/history")
    public String takeHistory(Model model) {

        List<ExamDto> questions = examService.historyExamList();

        model.addAttribute("questions", questions);

        return "/exam/history";
    }

    @PostMapping("/history")
    public String takeHistory(AnswersDto answers) {

        double score = examService.insertHistoryAnswer(answers);
        System.out.println("점수 : " + score);

        return "redirect:/exam/list";
    }

    @GetMapping("/result")
    public String result(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        MemberDto userDetails = (MemberDto) authentication.getPrincipal();

        String username = userDetails.getUsername();

        MemberDto member = memberService.selectMember(username);

        model.addAttribute("member", member);

        return "/exam/result";

    }

}



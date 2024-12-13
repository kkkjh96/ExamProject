package com.example.testproject.service;

import com.example.testproject.dao.ExamDao;
import com.example.testproject.dao.MemberDao;
import com.example.testproject.dto.AnswerDto;
import com.example.testproject.dto.AnswersDto;
import com.example.testproject.dto.ExamDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.example.testproject.service
 * fileName       : ExamServiceImpl
 * author         : 김재홍
 * date           : 24. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 13.        김재홍       최초 생성
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamDao examDao;

    @Autowired
    MemberDao memberDao;

    @Override
    public List<ExamDto> koreanExamList() {

       return  examDao.koreanExamList();

    }

    @Override
    public double insertKoreanAnswer(AnswersDto answers) {

        List<AnswerDto> answerList = answers.getAnswers();

        System.out.println(answerList);

        double score = 0;
        String username = null;
        for(AnswerDto answer : answerList){
            score += examDao.countKoreanScore(answer);
            username = answer.getUsername();
            examDao.insertKoreanAnswer(answer);
        }

        int totalScore = examDao.totalKoreanScore();

        System.out.println(username + "username");

        score = (score / totalScore) * 100;

        memberDao.updateKoreanScore(username, score);

        return score;

    }

    @Override
    public List<ExamDto> mathExamList() {

        return  examDao.mathExamList();

    }

    @Override
    public double insertMathAnswer(AnswersDto answers) {

        List<AnswerDto> answerList = answers.getAnswers();

        System.out.println(answerList);

        double score = 0;
        String username = null;
        for(AnswerDto answer : answerList){
            score += examDao.countMathScore(answer);
            username = answer.getUsername();
            examDao.insertMathAnswer(answer);
        }

        int totalScore = examDao.totalMathScore();

        System.out.println(username + "username");

        score = (score / totalScore) * 100;

        memberDao.updateMathScore(username, score);

        return score;

    }
    @Override
    public List<ExamDto> historyExamList() {

        return  examDao.historyExamList();

    }

    @Override
    public double insertHistoryAnswer(AnswersDto answers) {

        List<AnswerDto> answerList = answers.getAnswers();

        System.out.println(answerList);

        double score = 0;
        String username = null;
        for(AnswerDto answer : answerList){
            score += examDao.countHistoryScore(answer);
            username = answer.getUsername();
            examDao.insertHistoryAnswer(answer);
        }

        int totalScore = examDao.totalHistoryScore();

        System.out.println(username + "username");

        score = (score / totalScore) * 100;

        memberDao.updateHistoryScore(username, score);

        return score;

    }

}

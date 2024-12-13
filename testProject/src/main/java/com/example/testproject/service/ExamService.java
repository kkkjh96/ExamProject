package com.example.testproject.service;

import com.example.testproject.dto.AnswerDto;
import com.example.testproject.dto.AnswersDto;
import com.example.testproject.dto.ExamDto;

import java.util.List;

/**
 * packageName    : com.example.testproject.service
 * fileName       : ExamService
 * author         : 김재홍
 * date           : 24. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 13.        김재홍       최초 생성
 */
public interface ExamService {

    List<ExamDto> koreanExamList();

    double insertKoreanAnswer(AnswersDto answersDto);

    List<ExamDto> mathExamList();

    double insertMathAnswer(AnswersDto answersDto);


    List<ExamDto> historyExamList();

    double insertHistoryAnswer(AnswersDto answersDto);


}

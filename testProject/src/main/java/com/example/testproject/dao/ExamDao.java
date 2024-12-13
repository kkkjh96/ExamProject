package com.example.testproject.dao;

import com.example.testproject.dto.AnswerDto;
import com.example.testproject.dto.ExamDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * packageName    : com.example.testproject.dao
 * fileName       : ExamDao
 * author         : 김재홍
 * date           : 24. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 13.        김재홍       최초 생성
 */
@Mapper
public interface ExamDao {

    int insertKoreanAnswer(@Param("answer") AnswerDto answer);

    List<ExamDto> koreanExamList();
    int countKoreanScore(@Param("answer") AnswerDto answer);
    int totalKoreanScore();

    int insertMathAnswer(@Param("answer") AnswerDto answer);

    List<ExamDto> mathExamList();
    int countMathScore(@Param("answer") AnswerDto answer);
    int totalMathScore();

    int insertHistoryAnswer(@Param("answer") AnswerDto answer);

    List<ExamDto> historyExamList();
    int countHistoryScore(@Param("answer") AnswerDto answer);
    int totalHistoryScore();

}

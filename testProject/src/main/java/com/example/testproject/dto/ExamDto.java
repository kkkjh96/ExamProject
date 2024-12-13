package com.example.testproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * packageName    : com.example.testproject.dto
 * fileName       : ExamDto
 * author         : 김재홍
 * date           : 24. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 13.        김재홍       최초 생성
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamDto {

    private String qno;
    private String question;
    private String answer;
    private String scode;
    private String qcd;
    private String questionChoices;

    // 쉼표로 연결된 questionChoice를 리스트로 변환
    public List<String> getQuestionChoiceList() {
        if (questionChoices == null || questionChoices.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(questionChoices.split(","));
    }

}

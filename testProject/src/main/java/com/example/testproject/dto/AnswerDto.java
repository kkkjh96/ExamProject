package com.example.testproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.testproject.dto
 * fileName       : ChoiceDto
 * author         : 김재홍
 * date           : 24. 12. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 13.        김재홍       최초 생성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerDto {

    private String username;
    private String qno;
    private String answer;

}

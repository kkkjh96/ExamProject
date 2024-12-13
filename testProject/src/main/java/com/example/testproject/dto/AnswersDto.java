package com.example.testproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.example.testproject.dto
 * fileName       : AnswersDto
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
public class AnswersDto {

    private List<AnswerDto> answers;

}

package com.example.testproject.service;

import com.example.testproject.dto.MemberDto;

/**
 * packageName    : com.example.securityboard_241212.service
 * fileName       : MemberService
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */
public interface MemberService {

    int insertMember(MemberDto member);

    MemberDto selectMember(String id);

}

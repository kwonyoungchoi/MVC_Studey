package org.example.springstudy.service;

import org.assertj.core.api.Assertions;
import org.example.springstudy.domain.Member;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalAccessError e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123123");
        }
    }
        //then


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
package org.example.springstudy.service;

import org.example.springstudy.domain.Member;
import org.example.springstudy.repository.MemberRepository;
import org.example.springstudy.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {

        //같은 이름이 있는 중복 회원X
        velivalidateDuplicateMember(member); //중복 회원 검증

        memberRepository.save(member);
        return member.getId();

    }

    private void velivalidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}

package com.hello.core.member;

import com.hello.core.member.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}

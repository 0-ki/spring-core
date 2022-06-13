package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10% 할인한다.")
    void vip_o() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discountPrice = rateDiscountPolicy.discount(member, 15000);
        assertThat(discountPrice).isEqualTo(1500);
    }

    @Test
    @DisplayName("VIP 가 아니면 할인하지 않는다.")
    void vip_x() {
        Member member = new Member(2L, "memberA", Grade.BASIC);
        int discountPrice = rateDiscountPolicy.discount(member, 15000);
        assertThat(discountPrice).isEqualTo(1500);
    }
}
package study.spring.core;

import study.spring.core.discount.DiscountPolicy;
import study.spring.core.discount.FixDiscountPolicy;
import study.spring.core.discount.RateDiscountPolicy;
import study.spring.core.member.MemberService;
import study.spring.core.member.MemberServiceImpl;
import study.spring.core.member.MemoryMemberRepository;
import study.spring.core.order.OrderService;
import study.spring.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 중복 제거 및 따로 뺴기

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

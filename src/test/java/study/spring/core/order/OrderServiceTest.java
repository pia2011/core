package study.spring.core.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.spring.core.member.Grade;
import study.spring.core.member.Member;
import study.spring.core.member.MemberService;
import study.spring.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }

}

package study.spring.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.core.AppConfig;
import study.spring.core.member.MemberRepository;
import study.spring.core.member.MemberServiceImpl;
import study.spring.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = = " + memberRepository);

        Assertions.assertSame(memberRepository, memberService.getMemberRepository());
        Assertions.assertSame(memberRepository, orderService.getMemberRepository());
        // 분명 new를 실행하면서 새로운 주소가 부여될것 같은데, 실상은 모두 같은 주소를 가지고 있다. 즉 같은 객체를 참조하고 있는 것이다.
        // 스프링 컨테이너는 @Bean


    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}

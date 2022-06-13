package study.spring.core.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.core.AppConfig;
import study.spring.core.member.MemberService;
import study.spring.core.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("구체 타입으로 조회") // 좋은 코드가 아님
    void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("빈 이름으로 조회X") // 실패 테스트
    void findBeanByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));
    }
}

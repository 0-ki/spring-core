package com.hello.core.singleton;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("Spring 없는 순수 DI 컨테이너인 경우")
    void pureContainer() {
        // DI 컨테이너 클래스
        AppConfig appConfig = new AppConfig();

        // 해당 클래스의 사용 요청이 2회 온 경우
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // 각 객체도 2번, 생성자 주입하는 객체 또한 각각
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Singleton Pattern 적용")
    void singletonServiceTest() {
        // DIP 위반
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        // isSame 은 ==
        // isEqual 은 .eqauls()
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
        Assertions.assertThat(singletonService1).isInstanceOf(SingletonService.class);
        singletonService1.logic();
    }

    @Test
    @DisplayName("Spring Container의 싱글톤 관리")
    void springContainerBeanTest() {
        // 스프링 컨테이너
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 해당 클래스의 사용 요청이 2회 온 경우
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 각 객체도 2번, 생성자 주입하는 객체 또한 각각
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}

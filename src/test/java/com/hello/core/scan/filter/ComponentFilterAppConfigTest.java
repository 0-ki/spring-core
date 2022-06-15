package com.hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = CustomIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = CustomExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {}

    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        IncludeBean includeBean = ac.getBean("includeBean", IncludeBean.class);
        Assertions.assertThat(includeBean).isNotNull();
    }
}

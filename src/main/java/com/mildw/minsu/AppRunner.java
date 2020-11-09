package com.mildw.minsu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

// 스프링에서는 프로필(Profile)을 통해 런타임 환경을 설정할 수 있는 기능을 제공한다.
// 프로필이란 환경에 따라 필요한 Bean값이 달라질 수 있는데 이것을 쉽게 관리할 수 있도록 도와주는 기능
// 그걸 사용하기위한 Runner 클래스

@Component
public class AppRunner implements ApplicationRunner {
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = ctx.getEnvironment();
    }
}

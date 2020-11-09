package com.mildw.minsu.advice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


// @Bean과 다른점이라면 bean은 개발자가 직접 제어 불가능한 외부 라이브러리를 Bean으로 만들때.
// @Component는 개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 어노테이션

@Aspect // @EnableAspectJAutoProxy 어노테이션을 통해 사용 
@Component
public class ViewSelectorAspect {

}

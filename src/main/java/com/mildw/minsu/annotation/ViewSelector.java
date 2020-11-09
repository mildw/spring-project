package com.mildw.minsu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메소드에만 커스텀 어노테이션 적용
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 클래스를 메모리에 적재하기 위함
public @interface ViewSelector { // 다음에 사용해보자.
}

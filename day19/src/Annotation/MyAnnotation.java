package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.EventListener;

@Target(ElementType.METHOD) //表示只有方法可以使用此注解
public @interface MyAnnotation {

}
/*
@Target(ElementType.FIELD) //表示只有成员方法可用此注解
@Target(ElementType.class) //表示只能放在类上用此注解
。。。。*/

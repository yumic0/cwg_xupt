package com.bjsxt.ref.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtMethod {
    String mtdName();
    String returnName();
    String[] paramType() default "";
    String returnType() default "";
}

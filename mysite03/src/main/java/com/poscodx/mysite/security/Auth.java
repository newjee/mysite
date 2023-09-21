package com.poscodx.mysite.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE}) //type=class
public @interface Auth {
//  public String value() default "";
    public String Role() default "USER" ;

    public boolean test() default false;
}


package com.annotations;

import java.lang.annotation.*;

/**
 * 用于注解表名
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}

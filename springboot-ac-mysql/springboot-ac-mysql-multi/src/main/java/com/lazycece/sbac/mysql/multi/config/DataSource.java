package com.lazycece.sbac.mysql.multi.config;

import java.lang.annotation.*;

/**
 * @author lazycece
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {

    String value();
}

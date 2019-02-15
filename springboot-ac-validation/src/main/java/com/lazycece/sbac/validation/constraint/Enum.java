package com.lazycece.sbac.validation.constraint;

import com.lazycece.sbac.validation.constraint.validator.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * To validate a enum's value is right or not .
 *
 * example one, if a enum like
 * <code>
 * public enum Sex {
 *
 *     MALE, FEMALE, OTHER
 * }
 * </code>
 * can use the annotation as <code>@Enum(clazz = Sex.class)</code>, and param sex = 0;
 * Or use the annotation as <code>@Enum(clazz = Sex.class, method = "name")</code>,
 * and param sex = "MALE";
 *
 * example two, if a enum like
 * <code>
 *     public enum Role {
 *
 *     ADMIN(1, "ADMIN"),
 *     TEST(2, "TEST"),
 *     DEVELOP(3, "DEVELOP");
 *
 *     private int value;
 *     private String desc;
 *
 *     Role(int value, String desc) {
 *         this.value = value;
 *         this.desc = desc;
 *     }
 *
 *     public int getValue() {
 *         return value;
 *     }
 *
 *     public void setValue(int value) {
 *         this.value = value;
 *     }
 *
 *     public String getDesc() {
 *         return desc;
 *     }
 *
 *     public void setDesc(String desc) {
 *         this.desc = desc;
 *     }
 * }
 * </code>
 * can use the annotation as <code>@Enum(clazz = Role.class, method = "getValue")</code>,
 * and param role = 1; Or use the annotation as <code>@Enum(clazz = Role.class,
 * method = "getDesc")</code>,and param role = "ADMIN";
 *
 *
 *
 *
 * @author lazycece
 * @date 2019/2/15
 */
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(Enum.List.class)
@Constraint(validatedBy = {EnumValidator.class})
public @interface Enum {

    String message() default "{*.validation.constraint.Enum.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * the enum's class-type
     *
     * @return Class
     */
    Class<?> clazz();

    /**
     * the method's name ,which used to validate the enum's value
     *
     * @return method's name
     */
    String method() default "ordinal";

    /**
     * Defines several {@link Enum} annotations on the same element.
     *
     * @see Enum
     */
    @Documented
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @interface List {
        Enum[] value();
    }
}

package com.lazycece.sbac.validation.constraint.validator;

import com.lazycece.sbac.validation.constraint.Enum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * @author lazycece
 * @date 2019/2/15
 */
public class EnumValidator implements ConstraintValidator<Enum, Object> {

    private Enum annotation;

    @Override
    public void initialize(Enum constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        Object[] objects = annotation.clazz().getEnumConstants();
        try {
            Method method = annotation.clazz().getMethod(annotation.method());
            for (Object o : objects) {
                if (value.equals(method.invoke(o))) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}

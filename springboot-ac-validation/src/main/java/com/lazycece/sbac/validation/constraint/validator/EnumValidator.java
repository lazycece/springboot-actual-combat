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

        Object[] objects = annotation.enumClazz().getEnumConstants();
//        Method method = annotation.enumClazz().getMethod(annotation.enumValueMethod());

        return true;
    }
}

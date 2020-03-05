package doan.stores.validation.annotation;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class EqualsStringValidator implements ConstraintValidator<EqualsString, Object> {
    private String first;
    private String second;
    private String message;

    @Override
    public void initialize(EqualsString constraintAnnotation) {
        first = constraintAnnotation.first();
        second = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        boolean valid = true;
        try {
            String[] firstObject = BeanUtils.getArrayProperty(object, first);
            String[] secondObject = BeanUtils.getArrayProperty(object, second);
            if (!StringUtils.isEmpty(firstObject[0]) && !StringUtils.isEmpty(secondObject[0]) && !firstObject[0].equals(secondObject[0])) {
                valid = false;
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            //ignore
        }
        if (!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(first)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}

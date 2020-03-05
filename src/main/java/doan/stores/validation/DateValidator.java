package doan.stores.validation;

import doan.stores.validation.annotation.Date;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator implements ConstraintValidator<Date, String> {

    private String datePattern;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)) {
            return true;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
            return sdf.format(sdf.parse(value)).equals(value);
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public void initialize(Date constraintAnnotation) {
        datePattern = constraintAnnotation.pattern();
    }
}

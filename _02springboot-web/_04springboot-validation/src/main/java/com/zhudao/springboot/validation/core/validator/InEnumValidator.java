package com.zhudao.springboot.validation.core.validator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * InEnumValidator
 *
 * @Description: InEnumValidator
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/13 16:28
 */
public class InEnumValidator implements ConstraintValidator<InEnum, Integer> {

    /**
     * 值数组
     */
    private Set<Integer> values;

    @Override
    public void initialize(InEnum annotation) {

        IntArrayValuable[] values = annotation.value().getEnumConstants();
        if (values.length == 0) {
            this.values = Collections.emptySet();
        } else {
            this.values = Arrays.stream(values[0].array())
                    .boxed()
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if (values.contains(value)) {
            return true;
        }
        // 校验不通过，自定义提示语句（因为，注解上的 value 是枚举类，无法获得枚举类的实际值）
        context.disableDefaultConstraintViolation(); // 禁用默认的 message 的值
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()
                .replaceAll("\\{value}", values.toString())).addConstraintViolation(); // 重新添加错误提示语句
        return false;
    }
}

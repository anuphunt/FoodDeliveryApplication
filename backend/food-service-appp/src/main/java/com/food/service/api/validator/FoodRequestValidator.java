package com.food.service.api.validator;

import com.food.service.api.model.FoodResource;
import com.food.service.util.RequestValidationMessage;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

import static com.food.service.core.util.Constants.VALID_EMAIL_ADDRESS_REGEX;

public class FoodRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return FoodResource.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        FoodResource foodResource = (FoodResource) target;
        if (foodResource.getName() == null || foodResource.getName().isEmpty()) {
            errors.reject("food.name", RequestValidationMessage.AUTHOR_NAME_EMPTY);
        }
        if (foodResource.getMobile() == null || foodResource.getMobile().isEmpty()) {
            errors.reject("food.email", RequestValidationMessage.AUTHOR_MOBILE_EMPTY);
        }
        if(!(VALID_EMAIL_ADDRESS_REGEX.matcher(foodResource.getEmail()).find())){
            errors.reject("food.email", RequestValidationMessage.AUTHOR_EMAIL_INCORRECT);

        }
        if (foodResource.getEmail() == null || foodResource.getEmail().isEmpty()) {
            errors.reject("food.mobile", RequestValidationMessage.AUTHOR_EMAIL_EMPTY);
        }
        if (foodResource.getBirthDate() == null || foodResource.getBirthDate().after(new Date())) {
            errors.reject("food.name", RequestValidationMessage.AUTHOR_DOB_WRONG);
        }

    }
}

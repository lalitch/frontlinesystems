package com.plessentials.frontlinesystems.utils;

import com.plessentials.frontlinesystems.exceptions.ErrorResponseException;
import com.plessentials.frontlinesystems.models.User;
import org.springframework.http.HttpStatus;

public class Validations {
    public static void validateUser(User user) {
        if(StringUtils.IsNullEmptyOrBlank(user.getName())) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "Name"));
        }
    }
}

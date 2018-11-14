package com.plessentials.frontlinesystems.utils;

import com.plessentials.frontlinesystems.exceptions.ErrorResponseException;
import com.plessentials.frontlinesystems.models.Address;
import com.plessentials.frontlinesystems.models.User;
import org.springframework.http.HttpStatus;

public class Validations {
    public static void validateUser(User user) {
        if(user == null) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "User"));
        }

        if(!StringUtils.IsNullEmptyOrBlank(user.getId())) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("InvalidProperty", "Id"));
        }

        if(StringUtils.IsNullEmptyOrBlank(user.getName())) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "Name"));
        }

        if(StringUtils.IsNullEmptyOrBlank(user.getSsn())) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "SSN"));
        }

        Validations.validateAddress(user.getAddress());
    }

    public static void validateAddress(Address address) {
        if(address == null) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "Address"));
        }

        if(StringUtils.IsNullEmptyOrBlank(address.getLine1())) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("InvalidProperty", "Address.Line1"));
        }

        if(StringUtils.IsNullEmptyOrBlank(address.getCity())) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "Address.City"));
        }

        if(address.getZip() == 0) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "Address.Zip"));
        }
    }
}

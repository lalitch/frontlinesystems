package com.plessentials.frontlinesystems.utils;

import com.plessentials.frontlinesystems.exceptions.ErrorResponseException;
import com.plessentials.frontlinesystems.models.*;
import org.springframework.http.HttpStatus;

public class Validations {
    public static void validateUser(User user) {
        if(user == null) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "User"));
        }

        if(StringUtils.IsNullEmptyOrBlank(user.getName())) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "Name"));
        }

        if(StringUtils.IsNullEmptyOrBlank(user.getSsn())) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "SSN"));
        }

        Validations.validateAddress(user.getAddress());
        Validations.validateUserId(user.getId());
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

    public static void validateLine(Line line){
        if(line == null) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "line"));
        }

        if(!StringUtils.IsNullEmptyOrBlank(line.getNumber())){
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("InvalidProperty", "number"));
        }

        if(StringUtils.IsNullEmptyOrBlank(line.getUserName())){
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "userName"));
        }

        Validations.validatePlan(line.getPlan());
    }

    public static void validatePlan(Plan plan){
        if(plan == null) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "plan"));
        }

        if(plan.getMonthlyCharges() == 0){
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "monthlyCharges"));
        }
    }

    public  static void validateUserId(String userId){
        if(StringUtils.IsNullEmptyOrBlank(userId)){
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST, ResourceUtils.getLocalizedString("MissingProperty", "userId"));
        }
    }
}

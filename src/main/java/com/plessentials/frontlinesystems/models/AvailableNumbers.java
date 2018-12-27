package com.plessentials.frontlinesystems.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.plessentials.frontlinesystems.utils.StringUtils;

import java.util.List;
import java.util.UUID;

@DynamoDBTable(tableName = "availableNumbers")
public class AvailableNumbers {
    private String number;

    @DynamoDBHashKey
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

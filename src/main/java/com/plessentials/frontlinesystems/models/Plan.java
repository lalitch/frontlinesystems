package com.plessentials.frontlinesystems.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Plan {
    private int monthlyCharges;

    public int getMonthlyCharges() {
        return monthlyCharges;
    }

    public void setMonthlyCharges(int monthlyCharges) {
        this.monthlyCharges = monthlyCharges;
    }
}

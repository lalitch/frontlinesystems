package com.plessentials.frontlinesystems.dataproviders;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DataProvider<T> {
    AmazonDynamoDB dynamoDBClient;
    DynamoDBMapper dynamoDBMapper;

    public DataProvider() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                "",
                "");

        this.dynamoDBClient = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();

        this.dynamoDBMapper = new DynamoDBMapper(this.dynamoDBClient);
    }

    public void save(T data) {
        this.dynamoDBMapper.save(data);
    }

    public void delete(T data) {
        this.dynamoDBMapper.delete(data);
    }

    public T get(Class<T> tClass, String id) {
        return this.dynamoDBMapper.load(tClass, id);
    }
}

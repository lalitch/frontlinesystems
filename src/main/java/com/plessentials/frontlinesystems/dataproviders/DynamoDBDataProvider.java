package com.plessentials.frontlinesystems.dataproviders;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBDataProvider<T> implements IDataProvider<T> {
    private AmazonDynamoDB dynamoDBClient;
    private DynamoDBMapper dynamoDBMapper;
    private Class<? extends T> tClass;

    public DynamoDBDataProvider(Class<? extends T> tClass) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                "",
                "");

        this.dynamoDBClient = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();

        this.dynamoDBMapper = new DynamoDBMapper(this.dynamoDBClient);

        this.tClass = tClass;
    }

    public void save(T data) {
        this.dynamoDBMapper.save(data);
    }

    public void delete(T data) {
        this.dynamoDBMapper.delete(data);
    }

    public T get(String id) {
        return this.dynamoDBMapper.load(this.tClass, id);
    }
}

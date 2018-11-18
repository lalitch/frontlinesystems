package com.plessentials.frontlinesystems.dataproviders;


public class MongoDBDataProvider<T> implements IDataProvider<T> {
    private final String connectionString = "mongodb://plessentials:fqe9Tq7bo6M5YnKs3ygo5BhAEAqo8NcMoqEqh05RaW6f9KgVbGCgQWD5aHUrlzbVvjFLlgyEZmtpT5CIxZ0okw==@plessentials.documents.azure.com:10255/?ssl=true&replicaSet=globaldb";

    private Class<T> tClass;

    public MongoDBDataProvider(Class<T> tClass, String collectionName)
    {
        this.tClass = tClass;
    }

    public void save(T data) {

    }

    public void delete(T data) {

    }

    public T get(String id) {
        return null;
    }
}

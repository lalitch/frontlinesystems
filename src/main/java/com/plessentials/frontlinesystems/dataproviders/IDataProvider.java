package com.plessentials.frontlinesystems.dataproviders;

public interface IDataProvider<T> {
    void save(T data);

    void delete(T data);

    T get(String id);
}

package com.plessentials.frontlinesystems.dataproviders;

import java.util.List;

public interface IDataProvider<T> {
    void save(T data);

    void delete(T data);

    T get(String id);

    List<T> listAndDelete(int count);
}

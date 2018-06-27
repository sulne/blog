package com.github.sulne.blog.dao;

import java.util.List;

public interface BaseDao<T> {
    void create(T object);

    void delete(String id);

    void update(T object);

    T get(String id);

    List<T> list();
}

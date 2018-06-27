package com.github.sulne.blog.service;

import java.util.List;

public interface BaseService<T> {
    void create(T object);

    void delete(String id);

    void update(T object);

    T get(String id);

    List<T> list();
}

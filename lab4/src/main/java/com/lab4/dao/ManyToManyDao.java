package com.lab4.dao;

import com.lab4.domain.DepartureFireman;

import java.util.List;
import java.util.Optional;

public interface ManyToManyDao<T, ID1, ID2> {
    List<T> findAll();

    Optional<T> findById(ID1 id1, ID2 id2);

    String create(T entity);

    String update(ID1 id1, ID2 id2, T entity);

    String delete(ID1 id1, ID2 id2);
}
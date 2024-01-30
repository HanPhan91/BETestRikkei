package com.test.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<E, T> {

    List<E> findAll();

    E getById(T id);

    Optional<E> findById(T id);

    E save(E e);

    void delete(E e);

    void deleteById(T id);

}

package org.yesser.service;

import org.yesser.dao.IGenericDAO;

import java.util.List;
import java.util.Map;

public interface IGenericService<T> extends IGenericDAO<T> {
    List<T> getAll();
    void deleteAll();

    T getById(Long id);

    T getId(Long i);

    T getByName(String name);

}

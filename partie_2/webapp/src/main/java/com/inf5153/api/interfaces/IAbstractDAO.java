package com.inf5153.api.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;


/**
 * Class definition for an Abstract DAO
 */

@Repository
public interface IAbstractDAO<T,ID> {
    public List<T> getAll();
    public T get(ID id);
    public T save(T model);
    public void delete(ID id);
    public Long count();
}

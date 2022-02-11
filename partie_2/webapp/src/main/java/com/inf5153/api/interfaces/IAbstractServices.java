package com.inf5153.api.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IAbstractServices<T,ID> {
    public List<T> fetchAll();
    public T fetchOneById(ID id);
    public T createOrSave(T model);
    public void delete(ID id);
    public Long count();
    
}

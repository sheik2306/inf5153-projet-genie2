package com.inf5153.api.services;

import java.util.List;

import com.inf5153.api.daos.AbstractDAO;
import com.inf5153.api.interfaces.IAbstractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService<T,ID> implements IAbstractServices<T,ID>{

    @Autowired
    AbstractDAO<T,ID> dao;

    public List<T> fetchAll() {
        return dao.getAll();
    }
    public T fetchOneById(ID id) {
        return dao.get(id);
    }
    public T createOrSave(T model) {
        return dao.save(model);
    }
    public void delete(ID id) {
        dao.delete(id);
    }
    public Long count() {
        return dao.count();
    }
}

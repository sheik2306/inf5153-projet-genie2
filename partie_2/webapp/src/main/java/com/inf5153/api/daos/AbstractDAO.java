package com.inf5153.api.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import com.inf5153.api.interfaces.IAbstractDAO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Abstract class with basic CRUD SQL operations
 * using JPArepository<T,ID>  
 * This class fetches a T object from the Database
 * @param T A data object from "models"
 * @param ID The data object id type ( Integer/ Long)
 * 
 * @package "models"
 */

@Service
public abstract class AbstractDAO<T,ID> implements IAbstractDAO<T,ID> {
    
    @Autowired
    JpaRepository<T,ID> repository;

    public List<T> getAll() {
        return repository.findAll();
    }

    public T get(ID id) {
        Optional<T> t =  repository.findById(id);
        T model = t.get();
        return model;
    }    

    public T save(T model) {
        return repository.save(model);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    public Long count() {
        return repository.count();
    }
    
    
}

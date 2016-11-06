package com.ncblog.dataaccess.repositories;

/**
 * Created by Администратор on 04.11.2016.
 */

import com.ncblog.dataaccess.specifications.Specification;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.Post_Like;
import com.ncblog.domain.User;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.Collection;
import java.util.List;

/**
 * Created by ivan on 01.11.16.
 */
public class GenericRepository<T> {

    private GenericDao<T> dao;

    public GenericRepository(GenericDao<T> dao) {
        this.dao = dao;
    }
    public GenericRepository(Class<T> typeParameterClass) {
        this.dao = new GenericDao(typeParameterClass);
    }
    public void add(T entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }
    public void addAll(Collection<T> allEntities) {
        dao.openCurrentSessionwithTransaction();
        for(T entity : allEntities){
            dao.persist(entity);
        }
        dao.closeCurrentSessionwithTransaction();
    }
    public void update(T entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }
    public void updateAll(Collection<T> allEntities) {
        dao.openCurrentSessionwithTransaction();
        for(T entity : allEntities){
            dao.update(entity);
        }
        dao.closeCurrentSessionwithTransaction();
    }
    public T get(int id) {
        dao.openCurrentSession();
        T foundEntity = dao.findById(id);
        dao.closeCurrentSession();
        return foundEntity;
    }

//    public T get(String id) {
//        return get(UUID.fromString(id));
//    }

    public T getOne(Specification<T>...specification) {
        dao.openCurrentSession();
        List<T> results = dao.findAllBySpecification(specification);
        dao.closeCurrentSession();
        switch (results.size()){
            case 0:
                throw new NoResultException();
            case 1:
                return results.get(0);
            default:
                throw new NonUniqueResultException("Result list has "+results.size()+" items instead of one");
        }
    }

    public T getFirst(Specification<T>...specification) {
        dao.openCurrentSession();
        List<T> results = dao.findAllBySpecification(specification);
        dao.closeCurrentSession();
        switch (results.size()) {
            case 0:
                throw new NoResultException();
            default:
                return results.get(0);
        }
    }

    public List<T> getEvery(Specification<T>...specification) {
        dao.openCurrentSession();
        List<T> results = dao.findAllBySpecification(specification);
        dao.closeCurrentSession();
        return results;
    }

//    public <T> List getAllBySql(String query) {
//        return dao.findAllBySql(query);
//    }

    public List<T> getAll() {
        dao.openCurrentSession();
        List<T> foundEntities = dao.findAll();
        dao.closeCurrentSession();
        return foundEntities;
    }

    public void remove(T entity) {
        dao.openCurrentSessionwithTransaction();
        dao.delete(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void remove(int id) {
        dao.openCurrentSessionwithTransaction();
        T foundEntity = dao.findById(id);
        dao.delete(foundEntity);
        dao.closeCurrentSessionwithTransaction();
    }
//    public void remove(String id) {
//        remove(UUID.fromString(id));
//    }
    public void removeAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }
    public GenericDao getDao() {
        return dao;
    }






}

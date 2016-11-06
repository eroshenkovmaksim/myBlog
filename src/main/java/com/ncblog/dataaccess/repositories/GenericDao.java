package com.ncblog.dataaccess.repositories;

/**
 * Created by Администратор on 04.11.2016.
 */
import com.ncblog.dataaccess.specifications.Specification;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
public class GenericDao<T>  {
    private Session currentSession;
    //    private String tableName;
    private Transaction currentTransaction;
    private final Class<T> typeParameterClass;
    GenericDao(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
//        this.tableName = MappingInfoUtil.getTableName(typeParameterClass);
    }
    //    public Session openCurrentSession() {
//        currentSession = HibernateUtil.getSessionFactory().openSession();
//        return currentSession;
//    }
    public void openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
    }
    //    public Session openCurrentSessionwithTransaction() {
//        currentSession = HibernateUtil.getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }
    public void openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }
    public void closeCurrentSession() {
        currentSession.close();
    }
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    public void persist(T entity) {
        getCurrentSession().save(entity);
    }
    public void update(T entity) {
        getCurrentSession().update(entity);
    }
    public T findById(int id) {
        return typeParameterClass.cast(getCurrentSession().get(typeParameterClass, id));
    }

    public <T> List findAllBySpecification(Specification<T>...specification) {
        Criteria criteria = getCurrentSession().createCriteria(specification[0].getType());
        for(Specification<T> detail : specification) {
            criteria.add(detail.toCriterion());
        }
        return criteria.list();
    }

//    public <T> List findAllBySql(String query) {
//        return getCurrentSession().createQuery(query).list();
//    }

    public List<T> findAll() {
        List<T> books = (List<T>) getCurrentSession().createCriteria(typeParameterClass).list();
        return books;
    }
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }
    public void deleteAll() {
        List<T> entityList = findAll();
        for (T entity : entityList) {
            delete(entity);
        }
    }
}
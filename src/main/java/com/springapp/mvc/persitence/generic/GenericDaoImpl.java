package com.springapp.mvc.persitence.generic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by novy on 31.05.14.
 */
public abstract class GenericDaoImpl<Entity, Key extends Serializable> implements GenericDao<Entity, Key> {
    private SessionFactory sessionFactory;
    private Class<Entity> entityClass;

    public GenericDaoImpl(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(Entity entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Entity entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(Entity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Entity getByPrimaryKey(Key key) {
        return (Entity)getCurrentSession().get(entityClass, key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Entity> getAll() {
        return (Collection<Entity>)getCurrentSession().createQuery("from " + entityClass.getName()).list();
    }
}

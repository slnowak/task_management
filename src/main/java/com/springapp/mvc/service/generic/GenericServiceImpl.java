package com.springapp.mvc.service.generic;

import com.springapp.mvc.persitence.generic.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by novy on 06.06.14.
 */
@Transactional
public abstract class GenericServiceImpl<Dao extends GenericDao<Entity, Key>, Entity, Key extends Serializable>
        implements GenericService<Dao, Entity, Key> {

    protected Dao dao;

    public GenericServiceImpl(Dao dao) {
        this.dao = dao;
    }


    @Override
    public void create(Entity entity) {
        dao.create(entity);
    }

    @Override
    public void update(Entity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(Key key) {
        Entity entity = dao.getByPrimaryKey(key);
        dao.delete(entity);
    }

    @Override
    public Entity getByPrimaryKey(Key key) {
        return dao.getByPrimaryKey(key);
    }

    @Override
    public List<Entity> getAll() {
        return dao.getAll();
    }
}

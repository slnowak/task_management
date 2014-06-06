package com.springapp.mvc.service.generic;

import com.springapp.mvc.persitence.generic.GenericDao;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * Created by novy on 06.06.14.
 */
public interface GenericService<Dao extends GenericDao<Entity, Key>, Entity, Key extends Serializable> {
    public void create(Entity entity);
    public void update(Entity entity);
    public void delete(Key key);
    public Entity getByPrimaryKey(Key key);
    public List<Entity> getAll();
}

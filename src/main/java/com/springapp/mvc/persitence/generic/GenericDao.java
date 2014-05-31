package com.springapp.mvc.persitence.generic;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by novy on 31.05.14.
 */
public interface GenericDao<Entity, Key extends Serializable> {
    public void create(Entity entity);
    public void update(Entity entity);
    public void delete(Entity entity);
    public Entity getByPrimaryKey(Key key);
    public Collection<Entity> getAll();
}

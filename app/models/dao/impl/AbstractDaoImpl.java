package models.dao.impl;


import com.avaje.ebean.Ebean;
import io.ebean.Model;
import io.ebean.Finder;
import com.avaje.ebean.SqlUpdate;
import models.dao.AbstractDao;
import models.dao.utils.ListPager;
import models.domain.AbstractEntity;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Table;
import java.util.Iterator;
import java.util.List;
import models.dao.utils.ListPager;

/**
 * Created by yenny on 8/31/16.
 */
public abstract class AbstractDaoImpl<K, E> implements AbstractDao<K, E> {
	
	
    public Finder<K, E> find;
    private Class<E> type;

    public AbstractDaoImpl(Class<E> type){
        this.type = type;
        find = new Finder<K, E>(type);
    }
    
    

    @Override
    public E create(E entity){
        ((AbstractEntity) entity).setId(null);
        ((Model) entity).save();
        return entity;
    }

    @Override
    public E update(E entity){
        //warm: si no exite el <id> pero tampoco se le manda actualizar campos, no genera una excepción
        ((Model) entity).update();
        return entity;
    }
    

    @Override
    public boolean delete(K id) {
        E entity = find.byId(id);
        ((Model) entity).delete();
        return true;
    }

   /* @Override
    public boolean delete(List<K> ids) {
        List<Object> findIds = find.findIds();
        Iterator<K> iterator = ids.iterator();

        while (iterator.hasNext()){
            K id = iterator.next();
            if(!findIds.contains(id)){
                throw new EntityNotFoundException("Element with id=" + id + " not found");
            }
        }

        String sql = "DELETE FROM " + this.type.getAnnotation(Table.class).name() + " WHERE id IN ( :ids ) ";
        SqlUpdate upd = Ebean.createSqlUpdate(sql);
        upd.setParameter("ids", ids);
        upd.execute();
        return true;
    }*/

    @Override
    public E findById(K id){
        E entity = find.byId(id);
        return entity;
    }
    
    @Override
    public boolean existEntity(K id){
    	boolean exist = false;
        E entity = find.byId(id);
        if(entity!=null){
        	exist = true;
        }
        return exist;
    }

    @Override
    public List<E> findAll(){
        List<E> entities = find.all();
        return entities;
    }

    @Override
    public ListPager findAll(Integer pageIndex, Integer pageSize){
        List<E> entities = find.all();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
    }
}
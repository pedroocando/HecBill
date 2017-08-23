package models.dao;

import models.dao.utils.ListPager;

import java.util.List;

/**
 * Created by yenny on 8/30/16.
 */

public interface AbstractDao <K, E>{

    E create(E entity); 

    E update(E entity);

    boolean delete(K id);
    
    boolean existEntity(K id);

   // boolean delete(List<K> ids);

    E findById(K id);

    List<E> findAll();

    ListPager findAll(Integer pageIndex, Integer pageSize);
}
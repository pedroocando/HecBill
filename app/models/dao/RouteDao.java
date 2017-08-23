package models.dao;

import java.util.List;

import models.dao.utils.ListPager;
import models.domain.Route;
/**
*
* @author Pedro Ocando
* 2017
*/
public interface RouteDao extends AbstractDao<Integer, Route> {
	
	ListPager findByType (Integer type,Integer pageIndex, Integer pageSize);
	
	ListPager findBystatus (Integer status,Integer pageIndex, Integer pageSize);
}

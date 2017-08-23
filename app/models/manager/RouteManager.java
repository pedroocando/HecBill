package models.manager;

import play.mvc.Result;

public interface RouteManager {
	
	Result create(Integer id);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByStatus(Integer partner, Integer status,Integer pageIndex,Integer pageSize);
	
	Result findByType(Integer partner, Integer type,Integer pageIndex,Integer pageSize);
}

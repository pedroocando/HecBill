package models.manager;

import play.mvc.Result;

public interface ExtraDataManager {
	
	Result create(Integer id);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
}

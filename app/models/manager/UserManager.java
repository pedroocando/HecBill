package models.manager;

import play.mvc.Result;

public interface UserManager {
	
	Result create(Integer id);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByPartner(Integer partner,Integer id,Integer pageIndex,Integer pageSize);
	
	Result findByRole(Integer partner,Integer role,Integer pageIndex,Integer pageSize);
}

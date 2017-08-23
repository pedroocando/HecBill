package models.manager;

import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public interface PartnerManager {
	
	Result create();
	
	Result update(Integer id);
	
	Result delete(Integer id);
	
	Result findById(Integer id);
	
	Result findByParent(Integer id_parent,Integer pageIndex, Integer pageSize);
	
	Result findByPhone (String phone);
	
	Result findByName (String name);
	
	Result findByCity (Integer id_city,Integer pageIndex, Integer pageSize);
	
	Result findByTokenAndId(String token,Integer id);
	
	Result findByemail (String email);
	
	Result findAll(Integer index,Integer size);
	

}

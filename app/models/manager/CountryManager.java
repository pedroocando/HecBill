package models.manager;

import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public interface CountryManager {
	
	Result create(Integer partner);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer index,Integer size);
}

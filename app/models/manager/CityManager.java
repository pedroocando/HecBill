package models.manager;

import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public interface CityManager {
	
Result create(Integer id);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByCountry(Integer partner,Integer id_country, Integer pageIndex,Integer pageSize);
}

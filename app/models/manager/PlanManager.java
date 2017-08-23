package models.manager;

import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public interface PlanManager {
	
	Result create(Integer partner);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByPartner(Integer id_partner, Integer pageIndex,Integer pageSize);
	
	Result findByStatus(Integer id_partner,Integer status, Integer pageIndex,Integer pageSize);
	
	Result findPlanPartner(Integer partner, Integer plan);
}

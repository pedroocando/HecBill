package controllers;

import models.manager.HasPlanManager;
import models.manager.impl.HasPlanManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public class HasPlan extends Controller {
	
	private static HasPlanManager planM = new HasPlanManagerImpl();
	
	public Result create(Integer id) {
        return planM.create(id);
    }
	
	public Result update(Integer partner,Integer id){
		return planM.update(partner,id);
	}
	
	public Result findById(Integer partner,Integer id){
		return planM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return planM.delete(partner,id);
	}
	
	public Result findByCustomer(Integer partner,Integer id_customer,Integer pageIndex,Integer pageSize){
		return planM.findByCustomer(partner,id_customer, pageIndex, pageSize);
	}
	
	public Result findByStatus(Integer partner,Integer id_status,Integer pageIndex,Integer pageSize){
		return planM.findByStatus(partner,id_status, pageIndex, pageSize);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return planM.findAll(partner,index, size);
	}
}

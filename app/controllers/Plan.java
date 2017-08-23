package controllers;
import models.manager.PlanManager;
import models.manager.impl.PlanManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class Plan extends Controller {
	
	private static PlanManager planM = new PlanManagerImpl();
	
	public Result create(Integer partner) {
        return planM.create(partner);
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
	
	public Result findByPartner(Integer id_partner,Integer pageIndex,Integer pageSize){
		return planM.findByPartner(id_partner, pageIndex, pageSize);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return planM.findAll(partner,index, size);
	}
	
	public Result findByPlanPartner(Integer partner,Integer plan){
		return planM.findPlanPartner(partner,plan);
	}
}

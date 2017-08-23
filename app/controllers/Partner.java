package controllers;
import models.manager.PartnerManager;
import models.manager.impl.PartnerManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class Partner extends Controller {
	
	private static PartnerManager partnerM = new PartnerManagerImpl();
	
	public Result create() {
        return partnerM.create();
    }
	
	public Result update(Integer id){
		return partnerM.update(id);
	}
	
	public Result findById(Integer id){
		return partnerM.findById(id);
	}
	
	public Result findAll(Integer index,Integer size){
		return partnerM.findAll(index, size);
	}
	
	public Result delete(Integer id){
		return partnerM.delete(id);
	}
	
	public Result findByParent(Integer id_parent,Integer pageIndex,Integer pageSize){
		return partnerM.findByParent(id_parent, pageIndex, pageSize);
	}
	
	public Result findByPhone(String phone){
		return partnerM.findByPhone(phone);
	}
	
	public Result findByCity(Integer id_city,Integer pageIndex,Integer pageSize){
		return partnerM.findByCity(id_city, pageIndex, pageSize);
	}
	
	public Result findByName(String name){
		return partnerM.findByName(name);
	}
	
	public Result findByEmail(String email){
		return partnerM.findByemail(email);
	}
}

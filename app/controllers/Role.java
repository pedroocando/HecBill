package controllers;
import models.manager.RoleManager;
import models.manager.impl.RoleManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class Role extends Controller {
	
	private static RoleManager roleM = new RoleManagerImpl();
	
	public Result create(Integer id) {
        return roleM.create(id);
    }
	
	public Result update(Integer partner, Integer id){
		return roleM.update(partner,id);
	}
	
	public Result findById(Integer partner, Integer id){
		return roleM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return roleM.delete(partner,id);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return roleM.findAll(partner,index, size);
	}
}

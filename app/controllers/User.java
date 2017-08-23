package controllers;

import models.manager.TagManager;
import models.manager.UserManager;
import models.manager.impl.TagManagerImpl;
import models.manager.impl.UserManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class User extends Controller {
							
	private static UserManager userM = new UserManagerImpl();
	
	public Result create(Integer id) {
        return userM.create(id);
    }
	
	public Result update(Integer partner, Integer id){
		return userM.update(partner,id);
	}
	
	public Result findById(Integer partner, Integer id){
		return userM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return userM.delete(partner,id);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return userM.findAll(partner,index, size);
	}
	
	public Result findByPartner(Integer partner,Integer id,Integer index,Integer size){
		return userM.findByPartner(partner,id,index, size);
	}
	
	public Result findByRole(Integer partner,Integer role ,Integer index,Integer size){
		return userM.findByRole(partner,role,index, size);
	}

}

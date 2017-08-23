package controllers;
import models.manager.TagRoleManager;
import models.manager.impl.TagRoleManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class TagRole extends Controller {
	
	private static TagRoleManager tagM = new TagRoleManagerImpl();
	
	public Result create(Integer id) {
        return tagM.create(id);
    }
	
	public Result update(Integer partner, Integer id){
		return tagM.update(partner,id);
	}
	
	public Result findById(Integer partner, Integer id){
		return tagM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return tagM.delete(partner,id);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return tagM.findAll(partner,index, size);
	}

}

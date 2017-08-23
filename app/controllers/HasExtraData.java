package controllers;
import models.manager.HasExtraDataManager;
import models.manager.impl.HasExtraDataManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class HasExtraData extends Controller {
	
	private static HasExtraDataManager extraM = new HasExtraDataManagerImpl();
	
	public Result create(Integer id) {
        return extraM.create(id);
    }
	
	public Result update(Integer partner,Integer id){
		return extraM.update(partner,id);
	}
	
	public Result findById(Integer partner,Integer id){
		return extraM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return extraM.delete(partner,id);
	}
	
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return extraM.findAll(partner,index, size);
	}

}

package controllers;

import models.manager.ExtraDataManager;
import models.manager.impl.ExtraDataManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public class ExtraData extends Controller {
	
	private static ExtraDataManager extraM = new ExtraDataManagerImpl();
	
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

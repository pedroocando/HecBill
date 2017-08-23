package controllers;

import models.manager.ConfigManager;
import models.manager.impl.ConfigManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

/**
*
* @author Pedro Ocando
* 2017
*/
public class Config extends Controller {
	
	private static ConfigManager configM = new ConfigManagerImpl();
	
	public Result create(Integer id) {
        return configM.create(id);
    }
	
	public Result update(Integer partner,Integer id){
		return configM.update(partner,id);
	}
	
	public Result findById(Integer partner,Integer id){
		return configM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return configM.delete(partner,id);
	}
	
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return configM.findAll(partner,index, size);
	}
	
	public Result findByKey(Integer partner,String key){
		return configM.findByKey(partner,key);
	}
}

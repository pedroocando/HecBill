package controllers;

import models.manager.FrecuencyManager;
import models.manager.impl.FrecuencyManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class Frecuency extends Controller {
	
	private static FrecuencyManager fM = new FrecuencyManagerImpl();
	
	public Result create(Integer id) {
        return fM.create(id);
    }
	
	public Result update(Integer partner,Integer id){
		return fM.update(partner,id);
	}
	
	public Result findById(Integer partner,Integer id){
		return fM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return fM.delete(partner,id);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return fM.findAll(partner,index, size);
	}
	
	public Result findByPartner(Integer partner,Integer id){
		return fM.findByPartner(partner,id);
	}
}

package controllers;

import models.manager.RouteTagManager;
import models.manager.impl.RouteTagManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class RouteTag extends Controller {
	
	private static RouteTagManager rouM = new RouteTagManagerImpl();
	
	public Result create(Integer id) {
        return rouM.create(id);
    }
	
	public Result update(Integer partner, Integer id){
		return rouM.update(partner,id);
	}
	
	public Result findById(Integer partner, Integer id){
		return rouM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return rouM.delete(partner,id);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return rouM.findAll(partner,index, size);
	}

}

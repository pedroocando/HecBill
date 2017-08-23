package controllers;

import models.manager.RoleManager;
import models.manager.RouteManager;
import models.manager.impl.RoleManagerImpl;
import models.manager.impl.RouteManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class Route extends Controller {
	
	private static RouteManager rouM = new RouteManagerImpl();
	
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
	
	public Result findByStatus(Integer partner,Integer status,Integer index,Integer size){
		return rouM.findByStatus(partner,status,index, size);
	}
	
	public Result findByType(Integer partner,Integer type,Integer index,Integer size){
		return rouM.findByType(partner,type,index, size);
	}
}

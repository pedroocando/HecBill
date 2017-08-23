package controllers;
import models.manager.ItemTypeManager;
import models.manager.impl.ItemTypeManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class ItemType extends Controller {
	
	private static ItemTypeManager itemM = new ItemTypeManagerImpl();
	
	public Result create(Integer id) {
        return itemM.create(id);
    }
	
	public Result update(Integer partner, Integer id){
		return itemM.update(partner,id);
	}
	
	public Result findById(Integer partner, Integer id){
		return itemM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return itemM.delete(partner,id);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return itemM.findAll(partner,index, size);
	}

}

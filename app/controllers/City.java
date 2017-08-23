package controllers;
/**
*
* @author Pedro Ocando
* 2017
*/
import models.manager.CityManager;
import models.manager.impl.CityManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class City extends Controller {
	
	private static CityManager cityM = new CityManagerImpl();
	
	public Result create(Integer id) {
        return cityM.create(id);
    }
	
	public Result update(Integer partner,Integer id){
		return cityM.update(partner,id);
	}
	
	public Result findById(Integer partner,Integer id){
		return cityM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return cityM.delete(partner,id);
	}
	
	public Result findByCountry(Integer partner,Integer id_country,Integer pageIndex,Integer pageSize){
		return cityM.findByCountry(partner,id_country, pageIndex, pageSize);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return cityM.findAll(partner,index, size);
	}

}

package controllers;

import models.manager.CountryManager;
import models.manager.impl.CountryManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

/**
*
* @author Pedro Ocando
* 2017
*/
public class Country extends Controller {
	
	private static CountryManager countryM = new CountryManagerImpl();
	
	public Result create(Integer partner) {
        return countryM.create(partner);
    }
	
	public Result update(Integer partner,Integer id){
		return countryM.update(partner,id);
	}
	
	public Result findById(Integer partner,Integer id){
		return countryM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return countryM.delete(partner,id);
	}
	
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return countryM.findAll(partner,index, size);
	}
}

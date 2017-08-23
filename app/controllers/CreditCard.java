package controllers;

import models.manager.CityManager;
import models.manager.CreditCardManager;
import models.manager.impl.CityManagerImpl;
import models.manager.impl.CreditCardManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

/**
*
* @author Pedro Ocando
* 2017
*/
public class CreditCard extends Controller {
	
	private static CreditCardManager creditM = new CreditCardManagerImpl();
	
	public Result create(Integer partner,Integer customer) {
        return creditM.create(partner,customer);
    }
	
	public Result update(Integer partner,Integer customer,Integer id){
		return creditM.update(partner,customer,id);
	}
	
	public Result findById(Integer partner,Integer customer,Integer id){
		return creditM.findById(partner,customer,id);
	}
	
	public Result delete(Integer partner,Integer customer,Integer id){
		return creditM.delete(partner,customer,id);
	}
	
	public Result findByCustomer(Integer partner,Integer id_customer,Integer pageIndex,Integer pageSize){
		return creditM.findByCustomer(partner,id_customer, pageIndex, pageSize);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return creditM.findAll(partner,index, size);
	}
}

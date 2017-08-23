package controllers;

import models.manager.CityManager;
import models.manager.CustomerManager;
import models.manager.impl.CityManagerImpl;
import models.manager.impl.CustomerManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public class Customer extends Controller {
	
	private static CustomerManager cusM = new CustomerManagerImpl();
	
	public Result create(Integer id) {
        return cusM.create(id);
    }
	
	public Result update(Integer partner, Integer id){
		return cusM.update(partner,id);
	}
	
	public Result findById(Integer partner, Integer id){
		return cusM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return cusM.delete(partner,id);
	}
	
	public Result findByPartner(Integer partner,Integer id_partner,Integer pageIndex,Integer pageSize){
		return cusM.findByPartner(partner,id_partner, pageIndex, pageSize);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return cusM.findAll(partner,index, size);
	}
	
	public Result findByStatus(Integer partner,Integer status,Integer pageIndex,Integer pageSize){
		return cusM.findByStatus(partner,status, pageIndex, pageSize);
	}
	
	public Result findByIdentifier(Integer partner,String ident){
		return cusM.findByIdentifier(partner,ident);
	}
	
	public Result findByPhone(Integer partner,String phone){
		return cusM.findByPhone(partner,phone);
	}
	
	public Result findByContract(Integer partner,String cont){
		return cusM.findByContract(partner,cont);
	}
	
	public Result findByEmail(Integer partner,String email){
		return cusM.findByEmail(partner,email);
	}
	
	public Result findByInvoice(Integer partner,Integer invoice){
		return cusM.findByInvoice(partner,invoice);
	}
	
	
}

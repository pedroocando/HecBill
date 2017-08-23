package controllers;

import models.manager.CreditCardManager;
import models.manager.InvoiceManager;
import models.manager.impl.CreditCardManagerImpl;
import models.manager.impl.InvoiceManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class Invoice extends Controller {
	
	private static InvoiceManager invM = new InvoiceManagerImpl();
	
	public Result create(Integer partner,Integer customer) {
        return invM.create(partner,customer);
    }
	
	public Result update(Integer partner,Integer customer,Integer id){
		return invM.update(partner,customer,id);
	}
	
	public Result findById(Integer partner,Integer customer,Integer id){
		return invM.findById(partner,customer,id);
	}
	
	public Result delete(Integer partner,Integer customer,Integer id){
		return invM.delete(partner,customer,id);
	}
	
	public Result findByCustomer(Integer partner,Integer id_customer,Integer pageIndex,Integer pageSize){
		return invM.findByCustomer(partner,id_customer, pageIndex, pageSize);
	}
	
	public Result findByStatus(Integer partner,Integer status,Integer pageIndex,Integer pageSize){
		return invM.findByStatus(partner,status, pageIndex, pageSize);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return invM.findAll(partner,index, size);
	}

}

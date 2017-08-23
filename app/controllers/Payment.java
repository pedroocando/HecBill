package controllers;
import models.manager.PaymentManager;
import models.manager.impl.PaymentManagerImpl;
import play.mvc.Controller;
import play.mvc.Result;

public class Payment extends Controller {
	
	private static PaymentManager payM = new PaymentManagerImpl();
	
	public Result create(Integer id) {
        return payM.create(id);
    }
	
	public Result update(Integer partner, Integer id){
		return payM.update(partner,id);
	}
	
	public Result findById(Integer partner, Integer id){
		return payM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return payM.delete(partner,id);
	}
	
	public Result findByInvoice(Integer partner,Integer invoice){
		return payM.findByInvoice(partner,invoice);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return payM.findAll(partner,index, size);
	}
}

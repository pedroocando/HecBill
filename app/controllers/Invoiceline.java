package controllers;
import models.manager.InvoiceLineManager;
import models.manager.impl.InvoiceLineManagerImple;
import play.mvc.Controller;
import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public class Invoiceline extends Controller {
	
private static InvoiceLineManager invM = new InvoiceLineManagerImple();
	
	public Result create(Integer id) {
        return invM.create(id);
    }
	
	public Result update(Integer partner,Integer id){
		return invM.update(partner,id);
	}
	
	public Result findById(Integer partner,Integer id){
		return invM.findById(partner,id);
	}
	
	public Result delete(Integer partner,Integer id){
		return invM.delete(partner,id);
	}
	
	public Result findByInvoice(Integer partner,Integer id_invoice,Integer pageIndex,Integer pageSize){
		return invM.findByInvoice(partner,id_invoice, pageIndex, pageSize);
	}
	
	public Result findAll(Integer partner,Integer index,Integer size){
		return invM.findAll(partner,index, size);
	}
}

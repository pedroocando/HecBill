package models.manager;

import play.mvc.Result;

public interface InvoiceLineManager {
	
	Result create(Integer id);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByInvoice(Integer partner,Integer id_invoice, Integer pageIndex,Integer pageSize);
}

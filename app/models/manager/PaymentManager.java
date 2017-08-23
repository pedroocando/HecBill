package models.manager;

import play.mvc.Result;

public interface PaymentManager {
	
	Result create(Integer partner);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByInvoice(Integer partner,Integer invoice);
}

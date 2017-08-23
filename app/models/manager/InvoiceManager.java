package models.manager;

import play.mvc.Result;

public interface InvoiceManager {
	
	Result create(Integer partner,Integer customer);
	
	Result update(Integer partner,Integer customer,Integer id);
	
	Result delete(Integer partner,Integer customer,Integer id);
	
	Result findById(Integer partner,Integer customer,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByCustomer(Integer partner,Integer Customer,Integer pageIndex,Integer pageSize);
	
	Result findByStatus(Integer partner,Integer status,Integer pageIndex,Integer pageSize);
	
}

package models.manager;

import play.mvc.Result;

public interface CreditCardManager {
	
	Result create(Integer partner,Integer customer);
	
	Result update(Integer partner,Integer customer,Integer id);
	
	Result delete(Integer partner,Integer customer,Integer id);
	
	Result findById(Integer partner,Integer customer,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByCustomer(Integer partner,Integer id_customer, Integer pageIndex,Integer pageSize);
}

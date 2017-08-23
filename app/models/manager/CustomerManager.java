package models.manager;

import play.mvc.Result;

public interface CustomerManager {
	
	Result create(Integer id);
	
	Result update(Integer partner,Integer id);
	
	Result delete(Integer partner,Integer id);
	
	Result findById(Integer partner,Integer id);
	
	Result findAll(Integer partner,Integer pageIndex,Integer pageSize);
	
	Result findByPartner(Integer partner,Integer id_partner,Integer pageIndex, Integer pageSize);
	
	Result findByIdentifier(Integer partner,String identifier);
	
	Result findByPhone(Integer partner,String phone);
	
	Result findByStatus(Integer partner,Integer status,Integer pageIndex, Integer pageSize);
	
	Result findByContract(Integer partner,String num_contract);
	
	Result findByEmail(Integer partner,String email);
	
	Result findByInvoice(Integer partner,Integer id_invoice);
	
	
}

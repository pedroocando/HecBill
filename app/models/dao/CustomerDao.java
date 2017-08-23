package models.dao;

import java.util.List;

import models.dao.utils.ListPager;
import models.domain.Customer;

public interface CustomerDao extends AbstractDao<Integer, Customer> {
	
	ListPager findByPartner (Integer id_partner,Integer pageIndex, Integer pageSize);
	
	Customer findByIdentifier (String identifier);
	
	Customer findByPhone (String phone);
	
	ListPager findByStatus (Integer status,Integer pageIndex, Integer pageSize);
	
	Customer findByContract (String num_contract);
	
	Customer findByEmail (String email);
	
	Customer findByInvoice (Integer id_invoice);/// busqueda por Factura actual 
	
}

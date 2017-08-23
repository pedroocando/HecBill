package models.dao;

import java.util.Date;
import java.util.List;

import models.dao.utils.ListPager;
import models.domain.Invoice;
/**
*
* @author Pedro Ocando
* 2017
*/
public interface InvoiceDao extends AbstractDao<Integer, Invoice> {
	
	ListPager findByCustomer (Integer id_customer,Integer pageIndex, Integer pageSize);
	
	ListPager findByStatus (Integer estatus,Integer pageIndex, Integer pageSize);

}

package models.dao;

import models.dao.utils.ListPager;
import models.domain.Invoice_line;
/**
*
* @author Pedro Ocando
* 2017
*/
public interface Invoice_lineDao extends AbstractDao<Integer, Invoice_line> {
	
	ListPager findByInvoice (Integer id_invoice,Integer pageIndex,Integer pageSize);
	
}

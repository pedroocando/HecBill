package models.dao;

import java.util.List;

import models.dao.utils.ListPager;
import models.domain.Customer_has_plan;

/**
*
* @author Pedro Ocando
* 2017
*/

public interface Customer_has_planDao extends AbstractDao<Integer, Customer_has_plan> {
	
	ListPager findByCustomer(Integer id_customer,Integer pageIndex, Integer pageSize);
	
	ListPager findByStatus(Integer status,Integer pageIndex, Integer pageSize);
	
}

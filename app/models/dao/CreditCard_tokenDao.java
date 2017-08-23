package models.dao;

import java.util.List;

import models.dao.utils.ListPager;
import models.domain.CreditCard_token;

/**
*
* @author Pedro Ocando
* 2017
*/

public interface CreditCard_tokenDao extends AbstractDao<Integer, CreditCard_token> {

	ListPager findByCustomer(Integer id_customer, Integer pageIndex, Integer pageSize); // Tarjetas de un customer
	
	Boolean findByTokenAndID(Integer id, String token);
	
}

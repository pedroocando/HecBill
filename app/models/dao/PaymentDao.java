package models.dao;

import java.util.Date;
import java.util.List;

import models.domain.Payment;

/**
*
* @author Pedro Ocando
* 2017
*/
public interface PaymentDao extends AbstractDao<Integer, Payment> {
	
	Payment findByInvoice (Integer id_invoice);

}

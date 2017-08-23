package models.manager.responseUtils.responseObject;

import java.util.Date;
/**
*
* @author Pedro Ocando
* 2017
*/
public class InvoiceResponse extends AbstractEntityResponse {
	public Integer id_customer;
	
	public Integer id_plan;
	
	public Double total_invoice;
	
	public Integer paymentAttempts_invoice;
	
	public Integer status_invoice; // 0 : Cobrar - 1: Cobrada - 2: procesando
	
	public Double balance_invoice;
	
	public Date dateCreated_invoice;
	
	public Date lastUpdated_invoice;
	
	public Double feeRate_partner;
	
	public Double taxtRate_invoice;
}

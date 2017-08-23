package models.manager.responseUtils.responseObject;

import java.util.Date;
/**
*
* @author Pedro Ocando
* 2017
*/
public class PaymentResponse extends AbstractEntityResponse {
	public Integer id_invoice;
	
	public Integer id_token;
	
	public Double amount_payment;
	
	public Date dateCreated_payment;
	
	public String type_payment; // S:Sale - R:Refound - BI: Consulta de saldo
	
	public String resultStatus_payment;
	
	public String descriptioon_payment;
}

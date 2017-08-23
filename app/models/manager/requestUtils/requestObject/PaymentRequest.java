package models.manager.requestUtils.requestObject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
/**
*
* @author Pedro Ocando
* 2017
*/
public class PaymentRequest {
	public Integer id_invoice;
	
	public Integer id_token;
	
	public Double amount_payment;
	
	public Date dateCreated_payment;
	
	public String type_payment; // S:Sale - R:Refound - BI: Consulta de saldo
	
	public String resultStatus_payment;
	
	public String descriptioon_payment;
}

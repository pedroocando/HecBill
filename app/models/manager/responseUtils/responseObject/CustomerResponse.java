package models.manager.responseUtils.responseObject;

import java.util.Date;
/**
*
* @author Pedro Ocando
* 2017
*/
public class CustomerResponse extends AbstractEntityResponse {
	
	public Integer id_partner;
	
	public String identifier_customer; // DNI o Cedula
	
	public String name_customer;

	public String lastName_customer;

	public String phoneNumber_customer;

	public String adress_customer;

	public Date dateAdmission_customer; /// comienzo del plan
	
	public Date dateExperiation_customer;/// fecha que se debe realizar el cobro
	
	public Date birthDate_customer;
	
	public Date dateUpdated_customer; // actualizacion de datos
	
	public Boolean notify_customer; // Evento de cobro 
	
	public Integer status_customer;
	
	public String numContrac_customer;
	
	public Double balance_customer;/// monto que adeuda el afiliado
	
	public Integer 	idCurrent_invoice ; // factura actual
	
	public Date lastOkBillingDate; // ultimo intento de cobro exitoso
	
	public String email_customer;
}

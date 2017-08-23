package models.manager.responseUtils.responseObject;
/**
*
* @author Pedro Ocando
* 2017
*/
public class PartnerResponse extends AbstractEntityResponse {
	
	public Integer idParent_partner;
	
	public String name_partner;
	
	public String adress_partner;
	
	public String phone_partner;
	
	public Integer status_partner; /// Valores - 1: Activo - 0:Inactivo
	
	public Integer id_city;
	
	public Double feeRate_partner;
	
	public Integer idNumPriority_partner;
	
	public String email_partner;
	
    public String token;  // Token de validacion para validar operaciones

}

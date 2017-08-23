package models.manager.responseUtils.responseObject;

import java.util.Date;
/**
*
* @author Pedro Ocando
* 2017
*/
public class UserResponse extends AbstractEntityResponse {
	public Integer id_role;
	
	public Integer id_partner;
	
	public String name_user;
	
	public String lastName_user;

	public String pass_user;
	
	public Date lastDateLogin_user;
	
	public Integer status_user; // 1:Activo - 0:Inactivo
}

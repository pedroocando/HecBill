package models.manager.requestUtils.requestObject;
/**
*
* @author Pedro Ocando
* 2017
*/
import java.util.Date;

public class UserRequest {
	public Integer id_role;
	
	public Integer id_partner;
	
	public String name_user;
	
	public String lastName_user;

	public String pass_user;
	
	public Date lastDateLogin_user;
	
	public Integer status_user; // 1:Activo - 0:Inactivo
}

package models.manager.responseUtils.responseObject;
/**
*
* @author Pedro Ocando
* 2017
*/
public class PlanResponse extends AbstractEntityResponse  {
	public Integer id_partner;
	
	public String idPlan_partner;
	
	public String name_plan;
	
	public Double feeCost_plan;
	
	public Double enrollmentCost_plan;
	
	public Integer id_frecuency;
	
	public Integer status_plan ; /// 1:Activo - 0:Inactivo
	
	public Double taxRate_plan;
}

package models.manager.responseUtils.responseObject;

import java.util.Date;
/**
*
* @author Pedro Ocando
* 2017
*/
public class CustomerPlanResponse extends AbstractEntityResponse{
	public Integer id_plan;
	
	public Integer id_customer;
	
	public Date startdate_customerPlan;
	
	public Date endDate_customerPlan;
	
	public Integer status_customerPlan;
}

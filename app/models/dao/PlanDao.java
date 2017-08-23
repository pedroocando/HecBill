package models.dao;

import java.util.List;

import models.dao.utils.ListPager;
import models.domain.Plan;
/**
*
* @author Pedro Ocando
* 2017
*/
public interface PlanDao extends AbstractDao<Integer, Plan> {
	
	ListPager findByPartner(Integer id_partner, Integer pageIndex,Integer pageSize);
	
	ListPager findBystatus (Integer status,Integer pageIndex,Integer pageSize);
	
	Plan 	  findPlanPartner(Integer partner,Integer plan);

}

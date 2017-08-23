package models.dao.impl;

import java.util.List;

import io.ebean.Ebean;
import models.dao.PlanDao;
import models.dao.utils.ListPager;
import models.domain.Plan;

public class PlanDaoImpl extends AbstractDaoImpl<Integer, Plan> implements PlanDao {
	public PlanDaoImpl() {
        super(Plan.class);
    }

	@Override
	public ListPager findByPartner(Integer id_partner,Integer pageIndex,Integer pageSize) {
		List<Plan> entities = Ebean.find(Plan.class).where().eq("id_partner", id_partner).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public ListPager findBystatus(Integer status,Integer pageIndex,Integer pageSize) {
		List<Plan> entities = Ebean.find(Plan.class).where().eq("status_plan", status).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public Plan findPlanPartner(Integer partner, Integer plan) {
		Plan p = Ebean.find(Plan.class).where().eq("id_partner", partner).eq("id", plan).findUnique();
		return p;
	}

}

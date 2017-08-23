package models.dao.impl;

import java.util.List;

import io.ebean.Ebean;
import models.dao.CityDao;
import models.dao.Customer_has_planDao;
import models.dao.utils.ListPager;
import models.domain.City;
import models.domain.Customer_has_plan;

public class HasPlanDaoImpl extends AbstractDaoImpl<Integer, Customer_has_plan> implements Customer_has_planDao {

	public HasPlanDaoImpl() {
        super(Customer_has_plan.class);
    }

	@Override
	public ListPager findByCustomer(Integer id_customer,Integer pageIndex, Integer pageSize) {
		List<Customer_has_plan> entities = Ebean.find(Customer_has_plan.class).where().eq("id_customer", id_customer).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public ListPager findByStatus(Integer status,Integer pageIndex, Integer pageSize) {
		List<Customer_has_plan> entities = Ebean.find(Customer_has_plan.class).where().eq("status_customerPlan", status).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

}

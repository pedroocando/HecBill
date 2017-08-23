package models.dao.impl;

import java.util.List;

import io.ebean.Ebean;
import models.dao.RouteDao;
import models.dao.utils.ListPager;
import models.domain.Route;

public class RouteDaoImpl extends AbstractDaoImpl<Integer, Route> implements RouteDao {
	
	public RouteDaoImpl() {
        super(Route.class);
    }

	@Override
	public ListPager findByType(Integer type, Integer pageIndex, Integer pageSize) {
		List<Route> entities = Ebean.find(Route.class).where().eq("route_type", type).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public ListPager findBystatus(Integer status, Integer pageIndex, Integer pageSize) {
		List<Route> entities = Ebean.find(Route.class).where().eq("status_route", status).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}
}

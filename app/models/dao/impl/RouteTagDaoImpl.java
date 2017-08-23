package models.dao.impl;
import models.dao.Route_tagDao;
import models.domain.Route_tag;

public class RouteTagDaoImpl extends AbstractDaoImpl<Integer, Route_tag> implements Route_tagDao {
	
	public RouteTagDaoImpl() {
        super(Route_tag.class);
    }
}

package models.dao.impl;

import java.util.List;

import io.ebean.Ebean;
import models.dao.CustomerDao;
import models.dao.UserDao;
import models.dao.utils.ListPager;
import models.domain.Customer;
import models.domain.User;

public class UserDaoImpl extends AbstractDaoImpl<Integer, User> implements UserDao {
	
	public UserDaoImpl() {
        super(User.class);
    }

	@Override
	public ListPager findByRole(Integer role, Integer pageIndex, Integer pageSize) {
		List<User> entities = Ebean.find(User.class).where().eq("id_role", role).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public ListPager findByPartner(Integer partner, Integer pageIndex, Integer pageSize) {
		List<User> entities = Ebean.find(User.class).where().eq("id_partner", partner).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}
}

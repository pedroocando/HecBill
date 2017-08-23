package models.dao.impl;

import models.dao.RoleDao;
import models.domain.Role;

public class RoleDaoImpl extends AbstractDaoImpl<Integer, Role> implements RoleDao {
	
	public RoleDaoImpl() {
        super(Role.class);
    }

}

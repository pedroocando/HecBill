package models.dao.impl;

import models.dao.RoleDao;
import models.dao.Tag_roleDao;
import models.domain.Role;
import models.domain.Tag_role;

public class TagRoleDaoImpl extends AbstractDaoImpl<Integer, Tag_role> implements Tag_roleDao{
	
	public TagRoleDaoImpl() {
        super(Tag_role.class);
    }
	
}

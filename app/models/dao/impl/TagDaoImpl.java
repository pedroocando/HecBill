package models.dao.impl;

import models.dao.TagDao;
import models.domain.Tag;

public class TagDaoImpl extends AbstractDaoImpl<Integer, Tag> implements TagDao {
	
	public TagDaoImpl() {
        super(Tag.class);
    }
	
}

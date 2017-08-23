package models.dao.impl;
import models.dao.Item_typeDao;
import models.domain.Item_type;

public class ItemTypeDaoImpl extends AbstractDaoImpl<Integer, Item_type> implements Item_typeDao {
	
	public ItemTypeDaoImpl() {
        super(Item_type.class);
    }
	
}

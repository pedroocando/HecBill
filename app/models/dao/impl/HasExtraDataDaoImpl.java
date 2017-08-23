package models.dao.impl;
import models.dao.Customer_has_extraDataDao;
import models.domain.Customer_has_extraData;

public class HasExtraDataDaoImpl extends AbstractDaoImpl<Integer, Customer_has_extraData> implements Customer_has_extraDataDao {
	
	public HasExtraDataDaoImpl() {
        super(Customer_has_extraData.class);
    }
	
}

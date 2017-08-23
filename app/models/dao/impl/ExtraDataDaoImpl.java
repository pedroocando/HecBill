package models.dao.impl;
import models.dao.ExtraData_CustomerDao;
import models.domain.ExtraData_customer;

public class ExtraDataDaoImpl extends AbstractDaoImpl<Integer, ExtraData_customer> implements ExtraData_CustomerDao {
	
	public ExtraDataDaoImpl() {
        super(ExtraData_customer.class);
    }
}

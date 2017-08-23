package models.dao.impl;

import java.util.Date;
import java.util.List;

import io.ebean.Ebean;
import models.dao.CustomerDao;
import models.dao.InvoiceDao;
import models.dao.utils.ListPager;
import models.domain.Customer;
import models.domain.Invoice;

public class InvoiceDaoImpl extends AbstractDaoImpl<Integer, Invoice> implements InvoiceDao {
	
	public InvoiceDaoImpl() {
        super(Invoice.class);
    }

	@Override
	public ListPager findByCustomer(Integer id_customer,Integer pageIndex, Integer pageSize) {
		List<Invoice> entities = Ebean.find(Invoice.class).where().eq("id_customer", id_customer).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public ListPager findByStatus(Integer estatus,Integer pageIndex, Integer pageSize) {
		List<Invoice> entities = Ebean.find(Invoice.class).where().eq("status_invoice", estatus).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

}

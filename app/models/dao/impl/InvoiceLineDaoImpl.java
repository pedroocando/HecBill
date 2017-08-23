package models.dao.impl;

import java.util.List;

import io.ebean.Ebean;
import models.dao.Invoice_lineDao;
import models.dao.utils.ListPager;
import models.domain.Invoice_line;

public class InvoiceLineDaoImpl extends AbstractDaoImpl<Integer, Invoice_line> implements Invoice_lineDao {
	
	public InvoiceLineDaoImpl() {
        super(Invoice_line.class);
    }

	@Override
	public ListPager findByInvoice(Integer id_invoice, Integer pageIndex, Integer pageSize) {
		List<Invoice_line> entities = Ebean.find(Invoice_line.class).where().eq("id_invoice", id_invoice).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}
	
}

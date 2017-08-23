package models.dao.impl;

import io.ebean.Ebean;
import models.dao.PaymentDao;
import models.domain.Payment;

public class PaymentDaoImpl extends AbstractDaoImpl<Integer, Payment> implements PaymentDao {
	
	public PaymentDaoImpl() {
        super(Payment.class);
    }

	@Override
	public Payment findByInvoice( Integer id_invoice) {
		Payment p = Ebean.find(Payment.class).where().eq("id_invoice", id_invoice).findUnique();
		return p;
	}
}

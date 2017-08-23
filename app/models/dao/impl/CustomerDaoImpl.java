package models.dao.impl;

import java.util.List;

import io.ebean.Ebean;
import models.dao.CustomerDao;
import models.dao.PartnerDao;
import models.dao.utils.ListPager;
import models.domain.Customer;
import models.domain.Partner;

public class CustomerDaoImpl extends AbstractDaoImpl<Integer, Customer> implements CustomerDao {
	
	public CustomerDaoImpl() {
        super(Customer.class);
    }

	@Override
	public ListPager findByPartner(Integer id_partner,Integer pageIndex, Integer pageSize) {
		List<Customer> entities = Ebean.find(Customer.class).where().eq("id_partner", id_partner).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public Customer findByIdentifier(String identifier) {
		Customer c = Ebean.find(Customer.class).where().eq("identifier_customer", identifier).findUnique();
		return c;
	}

	@Override
	public Customer findByPhone(String phone) {
		Customer c = Ebean.find(Customer.class).where().eq("phoneNumber_customer", phone).findUnique();
		return c;
	}

	@Override
	public ListPager findByStatus(Integer status,Integer pageIndex, Integer pageSize) {
		List<Customer> entities = Ebean.find(Customer.class).where().eq("status_customer", status).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public Customer findByContract(String num_contract) {
		Customer c = Ebean.find(Customer.class).where().eq("numContrac_customer", num_contract).findUnique();
		return c;
	}

	@Override
	public Customer findByEmail(String email) {
		Customer c = Ebean.find(Customer.class).where().eq("email_customer", email).findUnique();
		return c;
	}

	@Override
	public Customer findByInvoice(Integer id_invoice) {
		Customer c = Ebean.find(Customer.class).where().eq("idCurrent_invoice", id_invoice).findUnique();
		return c;
	}
}

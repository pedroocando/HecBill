package models.dao.impl;

import java.util.List;

import io.ebean.Ebean;
import models.dao.CreditCard_tokenDao;
import models.dao.PartnerDao;
import models.dao.utils.ListPager;
import models.domain.CreditCard_token;
import models.domain.Partner;

public class CreditCard_DaoImpl extends AbstractDaoImpl<Integer, CreditCard_token> implements CreditCard_tokenDao {
	
	public CreditCard_DaoImpl() {
        super(CreditCard_token.class);
    }

	@Override
	public ListPager findByCustomer(Integer id_customer,Integer pageIndex, Integer pageSize) {
		List<CreditCard_token> entities = Ebean.find(CreditCard_token.class).where().eq("id_customer", id_customer).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public Boolean findByTokenAndID(Integer id, String token) {
		CreditCard_token c = Ebean.find(CreditCard_token.class).where().eq("id", id).eq("token_creditCardToken", token).findUnique();
		if(c!=null){
			return true;
		}else{
			return false;
		}
	}
}

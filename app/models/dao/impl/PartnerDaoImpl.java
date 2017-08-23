package models.dao.impl;
import models.dao.PartnerDao;
import models.dao.utils.ListPager;
import models.domain.Partner;
import java.util.List;

import io.ebean.Ebean;
/**
*
* @author Pedro Ocando
* 2017
*/
public class PartnerDaoImpl extends AbstractDaoImpl<Integer, Partner> implements PartnerDao  {
	
	public PartnerDaoImpl() {
        super(Partner.class);
    }

	

	@Override
	public ListPager findByParent(Integer id_parent,Integer pageIndex, Integer pageSize) {
		List<Partner> entities = Ebean.find(Partner.class).where().eq("idParent_partner", id_parent).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
		
	}

	@Override
	public Partner findByPhone(String phone) {
		Partner p = Ebean.find(Partner.class).where().eq("phone_partner", phone).findUnique();
		return p;
	}
	
	@Override
	public Partner findByName(String name) {
		Partner p = Ebean.find(Partner.class).where().eq("name_partner", name).findUnique();
		return p;
	}

	@Override
	public ListPager findByCity(Integer id_city, Integer pageIndex,Integer pageSize) {
		List<Partner> entities = Ebean.find(Partner.class).where().eq("id_city", id_city).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	@Override
	public Boolean findByTokenAndID(Integer id, String token) {
		Partner p = Ebean.find(Partner.class).where().eq("id", id).eq("token", token).findUnique();
		if(p!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Partner findByEmail(String email) {
		Partner p = Ebean.find(Partner.class).where().eq("email_partner", email).findUnique();
		return p;
	}
}

package models.dao;

import java.util.List;

import models.dao.utils.ListPager;
import models.domain.User;

public interface UserDao extends AbstractDao<Integer, User> {
	
	ListPager findByRole(Integer role,Integer pageIndex,Integer pageSize);
	
	ListPager findByPartner(Integer partner,Integer pageIndex,Integer pageSize);
	

}

package models.dao;

import java.util.List;

import models.dao.utils.ListPager;
import models.domain.Partner;
/**
*
* @author Pedro Ocando
* 2017
*/

public interface PartnerDao extends AbstractDao<Integer, Partner> {

	ListPager findByParent(Integer id_parent, Integer pageIndex, Integer pageSize); // Busqueda por Parent del partner
	
	Partner findByPhone (String phone); 
	
	Partner findByName (String name);
	
	ListPager findByCity(Integer id_city,Integer pageIndex, Integer pageSize);// Listado de partners en una ciudad
	
	Boolean findByTokenAndID(Integer id, String token);
	
	Partner findByEmail(String email);
	
}

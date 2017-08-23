package models.dao;

import java.util.List;

import models.dao.utils.ListPager;
import models.domain.City;

/**
*
* @author Pedro Ocando
* 2017
*/

public interface CityDao extends AbstractDao<Integer, City> {
	
	ListPager findByCountry (Integer id_country,Integer pageIndex,Integer pageSize);

}

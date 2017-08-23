package models.dao.impl;

import java.util.List;

import io.ebean.Ebean;
import models.dao.CityDao;
import models.dao.utils.ListPager;
import models.domain.City;
/**
*
* @author Pedro Ocando
* 2017
*/
public class CityDaoImpl extends AbstractDaoImpl<Integer, City> implements CityDao {
	
	public CityDaoImpl() {
        super(City.class);
    }

	@Override
	public ListPager findByCountry(Integer id_country,Integer pageIndex,Integer pageSize) {
		List<City> entities = Ebean.find(City.class).where().eq("id_country", id_country).findList();
        if(pageIndex < 0 || pageSize < 0)
            return new ListPager(entities, entities.size(), pageIndex, pageSize);
        return new ListPager(entities, pageSize, pageSize, pageSize);
	}

	
}

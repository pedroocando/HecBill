package models.dao.impl;

import models.dao.CountryDao;
import models.domain.Country;
/**
*
* @author Pedro Ocando
* 2017
*/
public class CountryDaoImpl extends AbstractDaoImpl<Integer, Country> implements CountryDao {
	public CountryDaoImpl() {
        super(Country.class);
    }
}

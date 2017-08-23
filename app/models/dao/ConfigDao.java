package models.dao;

import models.domain.Config;;
/**
*
* @author Pedro Ocando
* 2017
*/

public interface ConfigDao extends AbstractDao<Integer, Config> {
	
	Config findByKey (String key);

}

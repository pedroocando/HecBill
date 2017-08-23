package models.dao.impl;

import io.ebean.Ebean;
import models.dao.ConfigDao;
import models.domain.Config;
/**
*
* @author Pedro Ocando
* 2017
*/


public class ConfigDaoImpl extends AbstractDaoImpl<Integer, Config> implements ConfigDao {
	
	public ConfigDaoImpl() {
        super(Config.class);
    }

	@Override
	public Config findByKey(String key) {
		Config c = Ebean.find(Config.class).where().eq("key_config", key).findUnique();
		return c;
	}

}

package models.dao.impl;
import io.ebean.Ebean;
import models.dao.FrecuencyDao;
import models.domain.Frecuency;
import models.domain.Partner;
/**
*
* @author Pedro Ocando
* 2017
*/
public class FrecuencyDaoImpl extends AbstractDaoImpl<Integer, Frecuency> implements FrecuencyDao {
	
	public FrecuencyDaoImpl() {
        super(Frecuency.class);
    }

	@Override
	public Frecuency findByPartner(Integer id_partner) {
		Frecuency f = Ebean.find(Frecuency.class).where().eq("id_partner", id_partner).findUnique();
		return f;
	}
}

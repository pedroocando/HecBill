package models.dao;

import models.domain.Frecuency;

/**
*
* @author Pedro Ocando
* 2017
*/


public interface FrecuencyDao extends AbstractDao<Integer, Frecuency> {
	
	Frecuency findByPartner (Integer id_partner);
}

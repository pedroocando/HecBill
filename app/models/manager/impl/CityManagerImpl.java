package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.CityDao;
import models.dao.PartnerDao;
import models.dao.impl.CityDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.City;
import models.manager.CityManager;
import models.manager.requestUtils.requestObject.CityRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.CityResponse;
import play.libs.Json;
import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public class CityManagerImpl implements CityManager {
	
	private static CityDao cityDao = new CityDaoImpl();
    private static ModelMapper modelMapper = new ModelMapper();
	private static PartnerDao pDao = new PartnerDaoImpl();

	@Override
	public Result create(Integer id) {
		try{
			JsonNode request = request().body().asJson();
			if(request == null)
	            return Response.requiredJson();
			
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(id, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			CityRequest cr = Json.fromJson(request.get("city"), CityRequest.class);
			City c = modelMapper.map(cr, City.class);
			c = cityDao.create(c);
			return Response.createdEntity(
	                Json.toJson(c));
		}catch(Exception e){
            return ExceptionsUtils.create(e);
        }
	}

	@Override
	public Result update(Integer partner,Integer id) {
		try{
			JsonNode request = request().body().asJson();
			if(request == null)
	            return Response.requiredJson();
			
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(cityDao.existEntity(id)){ // Comprueba existencia
				CityRequest cr = Json.fromJson(request.get("city"), CityRequest.class);
				City c = modelMapper.map(cr, City.class);
				c.setId(id);
				c = cityDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("City");
			}
		}catch(Exception e){
            return ExceptionsUtils.update(e);
        }
	}

	@Override
	public Result delete(Integer partner,Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
		  	if(cityDao.existEntity(id)){
		  		cityDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("City");
		  	}
        } catch (Exception e) {
            return ExceptionsUtils.delete(e);
        }
	}

	@Override
	public Result findById(Integer partner,Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(cityDao.existEntity(id)){
				City c = cityDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CityResponse.class));
			}else{
				return Response.notFoundEntity("City");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findByCountry(Integer partner,Integer id_country,Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
            ListPager listPager = cityDao.findByCountry(id_country, pageIndex, pageSize);

            return Response.foundEntity(
                    listPager,
                    CityResponse.class);
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}
	
	@Override
	   public Result findAll(Integer partner,Integer index,Integer size){  /// obtiene todos los registros de la Bd
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
         ListPager listPager = cityDao.findAll(index, size);
         return Response.foundEntity(
                 listPager,
                 CityResponse.class);
     }catch(Exception e){
         return ExceptionsUtils.find(e);
     }
	  }

}

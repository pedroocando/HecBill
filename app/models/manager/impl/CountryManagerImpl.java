package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.CountryDao;
import models.dao.PartnerDao;
import models.dao.impl.CountryDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Country;
import models.manager.CountryManager;
import models.manager.requestUtils.requestObject.CountryRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.CountryResponse;
import play.libs.Json;
import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public class CountryManagerImpl implements CountryManager {
	
	private static CountryDao countryDao = new CountryDaoImpl();
    private static ModelMapper modelMapper = new ModelMapper();
    private static PartnerDao pDao = new PartnerDaoImpl();
    
	@Override
	public Result create(Integer partner) {
		try{
			JsonNode request = request().body().asJson();
			if(request == null)
	            return Response.requiredJson();
			
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			CountryRequest cr = Json.fromJson(request.get("country"), CountryRequest.class);
			Country c = modelMapper.map(cr, Country.class);
			c = countryDao.create(c);
			return Response.createdEntity(
	                Json.toJson(c));
		}catch(Exception e){
            return ExceptionsUtils.create(e);
        }
	}
	@Override
	public Result update(Integer partner,Integer id) {
		try{
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			JsonNode request = request().body().asJson();
			if(request == null)
	            return Response.requiredJson();
			
			if(countryDao.existEntity(id)){ // Comprueba existencia
				CountryRequest cr = Json.fromJson(request.get("country"), CountryRequest.class);
				Country c = modelMapper.map(cr, Country.class);
				c.setId(id);
				c = countryDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Country");
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
			
		  	if(countryDao.existEntity(id)){
		  		countryDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Country");
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
			
			if(countryDao.existEntity(id)){
				Country c = countryDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CountryResponse.class));
			}else{
				return Response.notFoundEntity("Country");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}
	@Override
	public Result findAll(Integer partner,Integer index, Integer size) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = countryDao.findAll(index, size);
	         return Response.foundEntity(
	                 listPager,
	                 CountryResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}
	
    

}

package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.CityDao;
import models.dao.ExtraData_CustomerDao;
import models.dao.PartnerDao;
import models.dao.impl.CityDaoImpl;
import models.dao.impl.ExtraDataDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.City;
import models.domain.ExtraData_customer;
import models.manager.ExtraDataManager;
import models.manager.requestUtils.requestObject.CityRequest;
import models.manager.requestUtils.requestObject.ExtraDataRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.CityResponse;
import models.manager.responseUtils.responseObject.ExtraDataResponse;
import play.libs.Json;
import play.mvc.Result;

public class ExtraDataManagerImpl implements ExtraDataManager {
	
	private static ExtraData_CustomerDao extraDao = new ExtraDataDaoImpl();
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
			
			ExtraDataRequest cr = Json.fromJson(request.get("extra"), ExtraDataRequest.class);
			ExtraData_customer c = modelMapper.map(cr, ExtraData_customer.class);
			c = extraDao.create(c);
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
			
			if(extraDao.existEntity(id)){ // Comprueba existencia
				ExtraDataRequest cr = Json.fromJson(request.get("extra"), ExtraDataRequest.class);
				ExtraData_customer c = modelMapper.map(cr, ExtraData_customer.class);
				c.setId(id);
				c = extraDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("ExtraData");
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
			
		  	if(extraDao.existEntity(id)){
		  		extraDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("ExtraData");
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
			
			if(extraDao.existEntity(id)){
				ExtraData_customer c = extraDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, ExtraDataResponse.class));
			}else{
				return Response.notFoundEntity("ExtraData");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findAll(Integer partner,Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = extraDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 CityResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

}

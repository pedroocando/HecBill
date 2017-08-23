package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.ConfigDao;
import models.dao.PartnerDao;
import models.dao.impl.ConfigDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Config;
import models.manager.ConfigManager;
import models.manager.requestUtils.requestObject.ConfigRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.ConfigResponse;
import play.libs.Json;
import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/

public class ConfigManagerImpl implements ConfigManager{
	
	private static ConfigDao configDao = new ConfigDaoImpl();
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
			
			ConfigRequest cr = Json.fromJson(request.get("config"), ConfigRequest.class);
			Config c = modelMapper.map(cr, Config.class);
			c = configDao.create(c);
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
			
			if(configDao.existEntity(id)){ // Comprueba existencia
				ConfigRequest cr = Json.fromJson(request.get("config"), ConfigRequest.class);
				Config c = modelMapper.map(cr, Config.class);
				c.setId(id);
				c = configDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Config");
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
			
		  	if(configDao.existEntity(id)){
		  		configDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Config");
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
			
			if(configDao.existEntity(id)){
				Config c = configDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, ConfigResponse.class));
			}else{
				return Response.notFoundEntity("Config");
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
			
	         ListPager listPager = configDao.findAll(index, size);
	         return Response.foundEntity(
	                 listPager,
	                 ConfigResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}
	@Override
	public Result findByKey(Integer partner,String key) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			Config c = configDao.findByKey(key);
			if(c!= null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, ConfigResponse.class));
			}else{
				return Response.notFoundEntity("config");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

}

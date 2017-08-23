package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.FrecuencyDao;
import models.dao.PartnerDao;
import models.dao.impl.FrecuencyDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Frecuency;
import models.manager.FrecuencyManager;
import models.manager.requestUtils.requestObject.FrecuencyRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.FrecuencyResponse;
import play.libs.Json;
import play.mvc.Result;

public class FrecuencyManagerImpl implements FrecuencyManager {
	
	private static FrecuencyDao fDao = new FrecuencyDaoImpl();
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
			
			FrecuencyRequest cr = Json.fromJson(request.get("frecuency"), FrecuencyRequest.class);
			Frecuency c = modelMapper.map(cr, Frecuency.class);
			c = fDao.create(c);
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
			
			if(fDao.existEntity(id)){ // Comprueba existencia
				FrecuencyRequest cr = Json.fromJson(request.get("frecuency"), FrecuencyRequest.class);
				Frecuency c = modelMapper.map(cr, Frecuency.class);
				c.setId(id);
				c = fDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Frecuency");
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
			
		  	if(fDao.existEntity(id)){
		  		fDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Frecuency");
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
			
			if(fDao.existEntity(id)){
				Frecuency c = fDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, FrecuencyResponse.class));
			}else{
				return Response.notFoundEntity("Frecency");
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
			
	         ListPager listPager = fDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 FrecuencyResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByPartner(Integer partner,Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			Frecuency c = fDao.findById(id);
			if(c!=null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, FrecuencyResponse.class));
			}else{
				return Response.notFoundEntity("Frecency");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

}

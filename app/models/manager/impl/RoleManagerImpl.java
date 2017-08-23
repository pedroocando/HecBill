package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.PartnerDao;
import models.dao.RoleDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.RoleDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Role;
import models.manager.RoleManager;
import models.manager.requestUtils.requestObject.RoleRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.RoleResponse;
import play.libs.Json;
import play.mvc.Result;

public class RoleManagerImpl implements RoleManager {
	
	private static RoleDao rolDao = new RoleDaoImpl();
	private static PartnerDao pDao = new PartnerDaoImpl();
    private static ModelMapper modelMapper = new ModelMapper();
    
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
			
			RoleRequest cr = Json.fromJson(request.get("role"), RoleRequest.class);
			Role c = modelMapper.map(cr, Role.class);
			c = rolDao.create(c);
			return Response.createdEntity(
	                Json.toJson(c));
		}catch(Exception e){
            return ExceptionsUtils.create(e);
        }
	}

	@Override
	public Result update(Integer partner, Integer id) {
		try{
			JsonNode request = request().body().asJson();
			if(request == null)
	            return Response.requiredJson();
			
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(rolDao.existEntity(id)){ // Comprueba existencia
				RoleRequest cr = Json.fromJson(request.get("role"), RoleRequest.class);
				Role c = modelMapper.map(cr, Role.class);
				c.setId(id);
				c = rolDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Role");
			}
		}catch(Exception e){
            return ExceptionsUtils.update(e);
        }
	}

	@Override
	public Result delete(Integer partner, Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
		  	if(rolDao.existEntity(id)){
		  		rolDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Role");
		  	}
        } catch (Exception e) {
            return ExceptionsUtils.delete(e);
        }
	}

	@Override
	public Result findById(Integer partner, Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(rolDao.existEntity(id)){
				Role c = rolDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, RoleResponse.class));
			}else{
				return Response.notFoundEntity("Role");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findAll(Integer partner, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = rolDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 RoleResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

}

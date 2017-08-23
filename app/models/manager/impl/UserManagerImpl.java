package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.PartnerDao;
import models.dao.TagDao;
import models.dao.UserDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.TagDaoImpl;
import models.dao.impl.UserDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Tag;
import models.domain.User;
import models.manager.UserManager;
import models.manager.requestUtils.requestObject.TagRequest;
import models.manager.requestUtils.requestObject.UserRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.TagResponse;
import models.manager.responseUtils.responseObject.UserResponse;
import play.libs.Json;
import play.mvc.Result;

public class UserManagerImpl implements UserManager {

	private static UserDao userDao = new UserDaoImpl();
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
			
			UserRequest cr = Json.fromJson(request.get("user"), UserRequest.class);
			User c = modelMapper.map(cr, User.class);
			c = userDao.create(c);
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
			
			if(userDao.existEntity(id)){ // Comprueba existencia
				UserRequest cr = Json.fromJson(request.get("user"), UserRequest.class);
				User c = modelMapper.map(cr, User.class);
				c.setId(id);
				c = userDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("User");
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
			
		  	if(userDao.existEntity(id)){
		  		userDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("User");
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
			
			if(userDao.existEntity(id)){
				User c = userDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, UserResponse.class));
			}else{
				return Response.notFoundEntity("User");
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
			
	         ListPager listPager = userDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 UserResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}
	
	@Override
	public Result findByPartner(Integer partner, Integer id, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = userDao.findByPartner(id,pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 UserResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByRole(Integer partner, Integer role, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = userDao.findByRole(role,pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 UserResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

}

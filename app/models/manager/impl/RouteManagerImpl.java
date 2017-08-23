package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.PartnerDao;
import models.dao.RoleDao;
import models.dao.RouteDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.RoleDaoImpl;
import models.dao.impl.RouteDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Role;
import models.domain.Route;
import models.manager.RouteManager;
import models.manager.requestUtils.requestObject.RoleRequest;
import models.manager.requestUtils.requestObject.RouteRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.RoleResponse;
import models.manager.responseUtils.responseObject.RouteResponse;
import play.libs.Json;
import play.mvc.Result;

public class RouteManagerImpl implements RouteManager{
	
	private static RouteDao rouDao = new RouteDaoImpl();
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
			
			RouteRequest cr = Json.fromJson(request.get("route"), RouteRequest.class);
			Route c = modelMapper.map(cr, Route.class);
			c = rouDao.create(c);
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
			
			if(rouDao.existEntity(id)){ // Comprueba existencia
				RouteRequest cr = Json.fromJson(request.get("role"), RouteRequest.class);
				Route c = modelMapper.map(cr, Route.class);
				c.setId(id);
				c = rouDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Route");
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
			
		  	if(rouDao.existEntity(id)){
		  		rouDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Route");
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
			
			if(rouDao.existEntity(id)){
				Route c = rouDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, RouteResponse.class));
			}else{
				return Response.notFoundEntity("Route");
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
			
	         ListPager listPager = rouDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 RouteResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByStatus(Integer partner,Integer status, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = rouDao.findBystatus(status,pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 RouteResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByType(Integer partner,Integer type, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = rouDao.findByType(type,pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 RouteResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

}

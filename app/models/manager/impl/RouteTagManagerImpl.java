package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.PartnerDao;
import models.dao.Route_tagDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.RouteTagDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Route_tag;
import models.manager.RouteTagManager;
import models.manager.requestUtils.requestObject.RouteTagRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.RouteTagResponse;
import play.libs.Json;
import play.mvc.Result;

public class RouteTagManagerImpl implements RouteTagManager{
	
	private static Route_tagDao rouDao = new RouteTagDaoImpl();
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
			
			RouteTagRequest cr = Json.fromJson(request.get("routeTag"), RouteTagRequest.class);
			Route_tag c = modelMapper.map(cr, Route_tag.class);
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
				RouteTagRequest cr = Json.fromJson(request.get("routeTag"), RouteTagRequest.class);
				Route_tag c = modelMapper.map(cr, Route_tag.class);
				c.setId(id);
				c = rouDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("RouteTag");
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
		  		return Response.notFoundEntity("RouteTag");
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
				Route_tag c = rouDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, RouteTagResponse.class));
			}else{
				return Response.notFoundEntity("RouteTag");
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
	                 RouteTagResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

}

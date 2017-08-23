package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.PartnerDao;
import models.dao.TagDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.TagDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Tag;
import models.manager.TagManager;
import models.manager.requestUtils.requestObject.TagRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.TagResponse;
import play.libs.Json;
import play.mvc.Result;

public class TagManagerImpl implements TagManager {
	
	private static TagDao tagDao = new TagDaoImpl();
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
			
			TagRequest cr = Json.fromJson(request.get("role"), TagRequest.class);
			Tag c = modelMapper.map(cr, Tag.class);
			c = tagDao.create(c);
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
			
			if(tagDao.existEntity(id)){ // Comprueba existencia
				TagRequest cr = Json.fromJson(request.get("tag"), TagRequest.class);
				Tag c = modelMapper.map(cr, Tag.class);
				c.setId(id);
				c = tagDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Tag");
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
			
		  	if(tagDao.existEntity(id)){
		  		tagDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Tag");
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
			
			if(tagDao.existEntity(id)){
				Tag c = tagDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, TagResponse.class));
			}else{
				return Response.notFoundEntity("Tag");
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
			
	         ListPager listPager = tagDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 TagResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}


}

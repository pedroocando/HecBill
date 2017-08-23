package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.PartnerDao;
import models.dao.Tag_roleDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.TagRoleDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Tag_role;
import models.manager.TagRoleManager;
import models.manager.requestUtils.requestObject.TagRoleRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.TagRoleResponse;
import play.libs.Json;
import play.mvc.Result;

public class TagRoleManagerImpl implements TagRoleManager {
	
	private static Tag_roleDao tagDao = new TagRoleDaoImpl();
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
			
			TagRoleRequest cr = Json.fromJson(request.get("role"), TagRoleRequest.class);
			Tag_role c = modelMapper.map(cr, Tag_role.class);
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
				TagRoleRequest cr = Json.fromJson(request.get("tagrole"), TagRoleRequest.class);
				Tag_role c = modelMapper.map(cr, Tag_role.class);
				c.setId(id);
				c = tagDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("TagRole");
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
		  		return Response.notFoundEntity("TagRole");
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
				Tag_role c = tagDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, TagRoleResponse.class));
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
			
	         ListPager listPager = tagDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 TagRoleResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

}

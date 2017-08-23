package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.CustomerDao;
import models.dao.Item_typeDao;
import models.dao.PartnerDao;
import models.dao.impl.CustomerDaoImpl;
import models.dao.impl.ItemTypeDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Customer;
import models.domain.Item_type;
import models.manager.ItemTypeManager;
import models.manager.requestUtils.requestObject.ItemTypeRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.ItemTypeResponse;
import play.libs.Json;
import play.mvc.Result;

public class ItemTypeManagerImpl implements ItemTypeManager{
	
	private static Item_typeDao itemDao = new ItemTypeDaoImpl();
	private static PartnerDao pDao = new PartnerDaoImpl();
    private static ModelMapper modelMapper = new ModelMapper();
    
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
			
			ItemTypeRequest cr = Json.fromJson(request.get("itemtype"), ItemTypeRequest.class);
			Item_type c = modelMapper.map(cr, Item_type.class);
			c = itemDao.create(c);
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
			
			if(itemDao.existEntity(id)){ // Comprueba existencia
				ItemTypeRequest cr = Json.fromJson(request.get("itemtype"), ItemTypeRequest.class);
				Item_type c = modelMapper.map(cr, Item_type.class);
				c.setId(id);
				c = itemDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("ItemType");
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
			
		  	if(itemDao.existEntity(id)){
		  		itemDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("ItemType");
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
			
			if(itemDao.existEntity(id)){
				Item_type c = itemDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, ItemTypeResponse.class));
			}else{
				return Response.notFoundEntity("ItemType");
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
			
	         ListPager listPager = itemDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 ItemTypeResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}
	

}

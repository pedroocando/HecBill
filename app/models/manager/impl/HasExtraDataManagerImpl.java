package models.manager.impl;

import static play.mvc.Controller.request;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.JsonNode;
import models.dao.Customer_has_extraDataDao;
import models.dao.PartnerDao;
import models.dao.impl.HasExtraDataDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Customer_has_extraData;
import models.manager.HasExtraDataManager;
import models.manager.requestUtils.requestObject.CustomerExtraRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.CustomerExtraResponse;
import play.libs.Json;
import play.mvc.Result;

/**
*
* @author Pedro Ocando
* 2017
*/
public class HasExtraDataManagerImpl implements HasExtraDataManager {
	
	private static Customer_has_extraDataDao extraDao = new HasExtraDataDaoImpl();
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
			
			CustomerExtraRequest cr = Json.fromJson(request.get("hasExtra"), CustomerExtraRequest.class);
			Customer_has_extraData c = modelMapper.map(cr, Customer_has_extraData.class);
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
				CustomerExtraRequest cr = Json.fromJson(request.get("hasExtra"), CustomerExtraRequest.class);
				Customer_has_extraData c = modelMapper.map(cr, Customer_has_extraData.class);
				c.setId(id);
				c = extraDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("HasExtra");
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
		  		return Response.notFoundEntity("HasExtra");
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
				Customer_has_extraData c = extraDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CustomerExtraResponse.class));
			}else{
				return Response.notFoundEntity("City");
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
	                 CustomerExtraResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}
}

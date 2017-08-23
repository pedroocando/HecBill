package models.manager.impl;

import models.dao.PartnerDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Partner;
import models.manager.PartnerManager;
import models.manager.requestUtils.requestObject.PartnerRequest;
import play.mvc.Result;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.JsonNode;
import static play.mvc.Controller.request;

import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.PartnerResponse;
import play.libs.Json;
import java.security.SecureRandom;
import java.math.BigInteger;
import models.manager.responseUtils.JsonUtils;
/**
*
* @author Pedro Ocando
* 2017
*/
public class PartnerManagerImpl implements PartnerManager {
	
	private static PartnerDao partnerDao = new PartnerDaoImpl();
    private static ModelMapper modelMapper = new ModelMapper();

	@Override
	public Result create() { /// Crea un nuevo partner en el sistema
		try{
			JsonNode request = request().body().asJson();
			if(request == null)
	            return Response.requiredJson();
			
			PartnerRequest pr = Json.fromJson(request.get("partner"), PartnerRequest.class);
			Partner p = modelMapper.map(pr, Partner.class);
			p.setToken(tokenGenerator()); // se genera el token que tendra asociado el partner
			p.setStatus_partner(2);
			p = partnerDao.create(p);
			return Response.createdEntity(
	                Json.toJson(p));
		}catch(Exception e){
            return ExceptionsUtils.create(e);
        }
	}
	
	public String tokenGenerator(){ /// generador de tokens para partners
		SecureRandom random = new SecureRandom();
		String token = new BigInteger(130, random).toString(32);
		return token;
	}

	@Override
	public Result update(Integer id) { /// Actualiza un partner en la base de datos
		try{
			JsonNode request = request().body().asJson();
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			if(request == null)
	            return Response.requiredJson();
			
			if(partnerDao.existEntity(id)){ // compueba si el partner existe
				PartnerRequest pr = Json.fromJson(request.get("partner"), PartnerRequest.class);
				Partner p = modelMapper.map(pr, Partner.class);
				p.setId(id);
				p.setToken(token);
				p = partnerDao.update(p);
				return Response.updatedEntity(Json.toJson(p));
			}else{
				return Response.notFoundEntity("Partner");
			}
		}catch(Exception e){
            return ExceptionsUtils.update(e);
        }
	}

	@Override
	public Result delete(Integer id) { // elimina un partner de la base de datos
		  try {
			  	if(partnerDao.existEntity(id)){
			  		partnerDao.delete(id);
		            return Response.deletedEntity();
			  	}else{
			  		return Response.notFoundEntity("Partner");
			  	}
	        } catch (Exception e) {
	            return ExceptionsUtils.delete(e);
	        }
	}

	@Override
	public Result findById(Integer id) { /// Realiza una busqueda por id
		try {
			if(partnerDao.existEntity(id)){
				Partner p = partnerDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(p, PartnerResponse.class));
			}else{
				return Response.notFoundEntity("Partner");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}
	
	@Override
	   public Result findAll(Integer index,Integer size){  /// obtiene todos los registros de la Bd
		try {
            ListPager listPager = partnerDao.findAll(index, size);
            return Response.foundEntity(
                    listPager,
                    PartnerResponse.class);
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	  }

	@Override
	public Result findByParent(Integer id_parent,Integer pageIndex, Integer pageSize) { // Busqueda de Prartners por su id_parent
		try {
            ListPager listPager = partnerDao.findByParent(id_parent, pageIndex, pageSize);

            return Response.foundEntity(
                    listPager,
                    PartnerResponse.class);
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findByPhone(String phone) {
		try {
			Partner p = partnerDao.findByPhone(phone);
			if(p!= null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(p, PartnerResponse.class));
			}else{
				return Response.notFoundEntity("Partner");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findByCity(Integer id_city,Integer pageIndex, Integer pageSize) {
		try {
            ListPager listPager = partnerDao.findByCity(id_city, pageIndex, pageSize);
            return Response.foundEntity(
                    listPager,
                    PartnerResponse.class);
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}
	
	@Override
	public Result findByName(String name) {
		try {
			Partner p = partnerDao.findByName(name);
			if(p!= null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(p, PartnerResponse.class));
			}else{
				return Response.notFoundEntity("Partner");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}


	@Override
	public Result findByTokenAndId(String token, Integer id) {
		return null;
	}

	@Override
	public Result findByemail(String email) {
		try {
			Partner p = partnerDao.findByEmail(email);
			if(p!= null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(p, PartnerResponse.class));
			}else{
				return Response.notFoundEntity("Partner");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        
	}
	}
}

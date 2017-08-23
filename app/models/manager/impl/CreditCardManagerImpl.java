package models.manager.impl;
import static play.mvc.Controller.request;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.CreditCard_tokenDao;
import models.dao.CustomerDao;
import models.dao.PartnerDao;
import models.dao.impl.CreditCard_DaoImpl;
import models.dao.impl.CustomerDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.CreditCard_token;
import models.manager.CreditCardManager;
import models.manager.requestUtils.requestObject.CreditCardRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.CityResponse;
import models.manager.responseUtils.responseObject.CreditCardResponse;
import play.libs.Json;
import play.mvc.Result;
/**
*
* @author Pedro Ocando
* 2017
*/
public class CreditCardManagerImpl implements CreditCardManager {
	
	private static CreditCard_tokenDao creditDao = new CreditCard_DaoImpl();
    private static ModelMapper modelMapper = new ModelMapper();
    private static PartnerDao pDao = new PartnerDaoImpl();
    private static CustomerDao cDao = new CustomerDaoImpl();
    
	@Override
	public Result create(Integer partner,Integer customer) {
		try{
			JsonNode request = request().body().asJson();
			if(request == null)
	            return Response.requiredJson();
			
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			boolean exist = cDao.existEntity(customer);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(exist == false)// Valida que el customer exista
				return Response.notFoundEntity("Customer");
			
			CreditCardRequest cr = Json.fromJson(request.get("creditCard"), CreditCardRequest.class);
			CreditCard_token c = modelMapper.map(cr, CreditCard_token.class);
			c.setToken_creditCardToken(tokenGenerator()); // Se genera el token de la creditCard 
			c = creditDao.create(c);
			return Response.createdEntity(
	                Json.toJson(c));
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
	public Result update(Integer partner,Integer customer,Integer id) {
		try{
			JsonNode request = request().body().asJson();
			if(request == null)
	            return Response.requiredJson();
			
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			boolean exist = cDao.existEntity(customer);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(exist == false)// Valida que el customer exista
				return Response.notFoundEntity("Customer");
			
			if(creditDao.existEntity(id)){ // Comprueba existencia
				CreditCardRequest cr = Json.fromJson(request.get("creditCard"), CreditCardRequest.class);
				CreditCard_token c = modelMapper.map(cr, CreditCard_token.class);
				c.setId(id);
				c = creditDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Credit Card");
			}
		}catch(Exception e){
            return ExceptionsUtils.update(e);
        }
	}

	@Override
	public Result delete(Integer partner,Integer customer,Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			boolean exist = cDao.existEntity(customer);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(exist == false)// Valida que el customer exista
				return Response.notFoundEntity("Customer");
			
		  	if(creditDao.existEntity(id)){
		  		creditDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Credit Card");
		  	}
        } catch (Exception e) {
            return ExceptionsUtils.delete(e);
        }
	}

	@Override
	public Result findById(Integer partner,Integer customer,Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			boolean exist = cDao.existEntity(customer);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(exist == false)// Valida que el customer exista
				return Response.notFoundEntity("Customer");
			
			if(creditDao.existEntity(id)){
				CreditCard_token c = creditDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CreditCardResponse.class));
			}else{
				return Response.notFoundEntity("Credit Card");
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
			
	         ListPager listPager = creditDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 CityResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByCustomer(Integer partner,Integer id_customer, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			boolean exist = cDao.existEntity(id_customer);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(exist == false) // Valida que el customer exista
				return Response.notFoundEntity("Customer");
			
            ListPager listPager = creditDao.findByCustomer(id_customer, pageIndex, pageSize);

            return Response.foundEntity(
                    listPager,
                    CreditCardResponse.class);
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

}

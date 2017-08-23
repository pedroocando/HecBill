package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.CreditCard_tokenDao;
import models.dao.CustomerDao;
import models.dao.PartnerDao;
import models.dao.PlanDao;
import models.dao.impl.CreditCard_DaoImpl;
import models.dao.impl.CustomerDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.PlanDaoImpl;
import models.dao.utils.ListPager;
import models.domain.CreditCard_token;
import models.domain.Customer;
import models.domain.Plan;
import models.manager.CustomerManager;
import models.manager.requestUtils.requestObject.CreditCardRequest;
import models.manager.requestUtils.requestObject.CustomerRequest;
import models.manager.requestUtils.requestObject.PlanRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.CustomerResponse;
import play.libs.Json;
import play.mvc.Result;

public class CustomerManagerImpl implements CustomerManager {
	
	private static CustomerDao cusDao = new CustomerDaoImpl();
	private static PartnerDao pDao = new PartnerDaoImpl();
	private static PlanDao planDao = new PlanDaoImpl();
	private static CreditCard_tokenDao  creDao = new CreditCard_DaoImpl();
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
			// Tomamos la informacion del customer
			CustomerRequest cr = Json.fromJson(request.get("customer"), CustomerRequest.class);
			Customer c = modelMapper.map(cr, Customer.class);
			c.setId_partner(id);
			// Tomamos la informacion del plan del customer
			PlanRequest pr = Json.fromJson(request.get("plan"), PlanRequest.class);
			Plan p = modelMapper.map(pr, Plan.class);
			p.setId_partner(id);
			// Tomamos la informacion de la creditcard del customer
			CreditCardRequest cc = Json.fromJson(request.get("creditcard"), CreditCardRequest.class);
			CreditCard_token cre = modelMapper.map(cc, CreditCard_token.class);
			cre.setId_customer(c.getId());
			// Creamos la entidades en DB
			c = cusDao.create(c);
			p = planDao.create(p);
			cre = creDao.create(cre);
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
			
			if(cusDao.existEntity(id)){ // Comprueba existencia
				CustomerRequest cr = Json.fromJson(request.get("customer"), CustomerRequest.class);
				Customer c = modelMapper.map(cr, Customer.class);
				c.setId(id);
				c = cusDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Customer");
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
			
		  	if(cusDao.existEntity(id)){
		  		cusDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Customer");
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
			
			if(cusDao.existEntity(id)){
				Customer c = cusDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CustomerResponse.class));
			}else{
				return Response.notFoundEntity("Customer");
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
			
	         ListPager listPager = cusDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 CustomerResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByPartner(Integer partner,Integer id_partner, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
            ListPager listPager = cusDao.findByPartner(id_partner, pageIndex, pageSize);

            return Response.foundEntity(
                    listPager,
                    CustomerResponse.class);
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findByIdentifier(Integer partner,String identifier) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			Customer c = cusDao.findByIdentifier(identifier);
			if(c!=null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CustomerResponse.class));
			}else{
				return Response.notFoundEntity("Customer");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findByPhone(Integer partner,String phone) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			Customer c = cusDao.findByPhone(phone);
			if(c!=null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CustomerResponse.class));
			}else{
				return Response.notFoundEntity("Customer");
			}
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
			
            ListPager listPager = cusDao.findByStatus(status, pageIndex, pageSize);

            return Response.foundEntity(
                    listPager,
                    CustomerResponse.class);
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findByContract(Integer partner,String num_contract) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			Customer c = cusDao.findByContract(num_contract);
			if(c!=null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CustomerResponse.class));
			}else{
				return Response.notFoundEntity("Customer");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findByEmail(Integer partner,String email) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			Customer c = cusDao.findByEmail(email);
			if(c!=null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CustomerResponse.class));
			}else{
				return Response.notFoundEntity("Customer");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

	@Override
	public Result findByInvoice(Integer partner,Integer id_invoice) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			Customer c = cusDao.findByInvoice(id_invoice);
			if(c!=null){
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CustomerResponse.class));
			}else{
				return Response.notFoundEntity("Customer");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

}

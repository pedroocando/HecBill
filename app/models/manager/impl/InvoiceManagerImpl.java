package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.CustomerDao;
import models.dao.InvoiceDao;
import models.dao.PartnerDao;
import models.dao.impl.CustomerDaoImpl;
import models.dao.impl.InvoiceDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Invoice;
import models.manager.InvoiceManager;
import models.manager.requestUtils.requestObject.InvoiceRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.InvoiceResponse;
import play.libs.Json;
import play.mvc.Result;

public class InvoiceManagerImpl implements InvoiceManager {
	
	private static InvoiceDao invDao = new InvoiceDaoImpl();
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
				return Response.notFoundEntity("Invoice");
			
			InvoiceRequest cr = Json.fromJson(request.get("invoice"), InvoiceRequest.class);
			Invoice c = modelMapper.map(cr, Invoice.class);
			c = invDao.create(c);
			return Response.createdEntity(
	                Json.toJson(c));
		}catch(Exception e){
            return ExceptionsUtils.create(e);
        }
	}

	@Override
	public Result update(Integer partner,Integer customer, Integer id) {
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
				return Response.notFoundEntity("Invoice");
			
			if(invDao.existEntity(id)){ // Comprueba existencia
				InvoiceRequest cr = Json.fromJson(request.get("invoice"), InvoiceRequest.class);
				Invoice c = modelMapper.map(cr, Invoice.class);
				c.setId(id);
				c = invDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Invoice");
			}
		}catch(Exception e){
            return ExceptionsUtils.update(e);
        }
	}

	@Override
	public Result delete(Integer partner,Integer customer, Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			boolean exist = cDao.existEntity(customer);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(exist == false)// Valida que el customer exista
				return Response.notFoundEntity("Invoice");
			
		  	if(invDao.existEntity(id)){
		  		invDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Invoice");
		  	}
        } catch (Exception e) {
            return ExceptionsUtils.delete(e);
        }
	}

	@Override
	public Result findById(Integer partner,Integer customer, Integer id) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			boolean exist = cDao.existEntity(customer);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(exist == false)// Valida que el customer exista
				return Response.notFoundEntity("Invoice");
			
			if(invDao.existEntity(id)){
				Invoice c = invDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, InvoiceResponse.class));
			}else{
				return Response.notFoundEntity("Invoice");
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
			
	         ListPager listPager = invDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 InvoiceResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByCustomer(Integer partner, Integer Customer, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = invDao.findByCustomer( Customer, pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 InvoiceResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByStatus(Integer partner, Integer status, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = invDao.findByStatus(status,pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 InvoiceResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

}

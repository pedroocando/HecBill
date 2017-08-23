package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.PartnerDao;
import models.dao.PaymentDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.PaymentDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Payment;
import models.manager.PaymentManager;
import models.manager.requestUtils.requestObject.PaymentRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.PaymentResponse;
import play.libs.Json;
import play.mvc.Result;

public class PaymentManagerImpl implements PaymentManager {
	
	private static PaymentDao payDao = new PaymentDaoImpl();
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
			
			PaymentRequest cr = Json.fromJson(request.get("payment"), PaymentRequest.class);
			Payment c = modelMapper.map(cr, Payment.class);
			c = payDao.create(c);
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
			
			if(payDao.existEntity(id)){ // Comprueba existencia
				PaymentRequest cr = Json.fromJson(request.get("payment"), PaymentRequest.class);
				Payment c = modelMapper.map(cr, Payment.class);
				c.setId(id);
				c = payDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Payment");
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
			
		  	if(payDao.existEntity(id)){
		  		payDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Payment");
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
			
			if(payDao.existEntity(id)){
				Payment c = payDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, PaymentResponse.class));
			}else{
				return Response.notFoundEntity("Payment");
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
			
	         ListPager listPager = payDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 PaymentResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByInvoice(Integer partner, Integer invoice) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(payDao.existEntity(invoice)){
				Payment c = payDao.findByInvoice(invoice);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, PaymentResponse.class));
			}else{
				return Response.notFoundEntity("Payment");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

}

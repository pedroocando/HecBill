package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.Invoice_lineDao;
import models.dao.PartnerDao;
import models.dao.impl.InvoiceLineDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Invoice_line;
import models.manager.InvoiceLineManager;
import models.manager.requestUtils.requestObject.InvoiceLineRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.InvoiceLineRespose;
import play.libs.Json;
import play.mvc.Result;

/**
*
* @author Pedro Ocando
* 2017
*/
public class InvoiceLineManagerImple implements InvoiceLineManager {
	
	private static Invoice_lineDao invDao = new InvoiceLineDaoImpl();
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
			
			InvoiceLineRequest cr = Json.fromJson(request.get("line"), InvoiceLineRequest.class);
			Invoice_line c = modelMapper.map(cr, Invoice_line.class);
			c = invDao.create(c);
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
			
			if(invDao.existEntity(id)){ // Comprueba existencia
				InvoiceLineRequest cr = Json.fromJson(request.get("line"), InvoiceLineRequest.class);
				Invoice_line c = modelMapper.map(cr, Invoice_line.class);
				c.setId(id);
				c = invDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("InvoiceLine");
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
			
		  	if(invDao.existEntity(id)){
		  		invDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("InvoiceLine");
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
			
			if(invDao.existEntity(id)){
				Invoice_line c = invDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, InvoiceLineRespose.class));
			}else{
				return Response.notFoundEntity("InvoiceLine");
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
			
	         ListPager listPager = invDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 InvoiceLineRespose.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByInvoice(Integer partner,Integer id_invoice, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = invDao.findByInvoice(id_invoice,pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 InvoiceLineRespose.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

}

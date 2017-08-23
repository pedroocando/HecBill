package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;

import models.dao.Customer_has_planDao;
import models.dao.PartnerDao;
import models.dao.impl.CityDaoImpl;
import models.dao.impl.HasPlanDaoImpl;
import models.dao.impl.PartnerDaoImpl;
import models.dao.utils.ListPager;
import models.domain.City;
import models.domain.Customer_has_plan;
import models.manager.HasPlanManager;
import models.manager.requestUtils.requestObject.CityRequest;
import models.manager.requestUtils.requestObject.CustomerPlanRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.CityResponse;
import models.manager.responseUtils.responseObject.CustomerPlanResponse;
import play.libs.Json;
import play.mvc.Result;

public class HasPlanManagerImpl implements HasPlanManager {
	
	private static Customer_has_planDao planDao = new HasPlanDaoImpl();
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
			
			CustomerPlanRequest cp = Json.fromJson(request.get("hasPlan"), CustomerPlanRequest.class);
			Customer_has_plan c = modelMapper.map(cp, Customer_has_plan.class);
			c = planDao.create(c);
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
			
			if(planDao.existEntity(id)){ // Comprueba existencia
				CustomerPlanRequest cr = Json.fromJson(request.get("hasPlan"), CustomerPlanRequest.class);
				Customer_has_plan c = modelMapper.map(cr, Customer_has_plan.class);
				c.setId(id);
				c = planDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("CustomerHasPlan");
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
			
		  	if(planDao.existEntity(id)){
		  		planDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("CustomerHasPlan");
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
			
			if(planDao.existEntity(id)){
				Customer_has_plan c = planDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, CustomerPlanResponse.class));
			}else{
				return Response.notFoundEntity("CustomerhasPlan");
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
			
	         ListPager listPager = planDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 CustomerPlanResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByCustomer(Integer partner,Integer id_customer, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
            ListPager listPager = planDao.findByCustomer(id_customer, pageIndex, pageSize);

            return Response.foundEntity(
                    listPager,
                    CustomerPlanResponse.class);
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
			
            ListPager listPager = planDao.findByStatus(status, pageIndex, pageSize);

            return Response.foundEntity(
                    listPager,
                    CustomerPlanResponse.class);
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

}

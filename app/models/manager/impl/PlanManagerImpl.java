package models.manager.impl;

import static play.mvc.Controller.request;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.JsonNode;
import models.dao.PartnerDao;
import models.dao.PlanDao;
import models.dao.impl.PartnerDaoImpl;
import models.dao.impl.PlanDaoImpl;
import models.dao.utils.ListPager;
import models.domain.Plan;
import models.manager.PlanManager;
import models.manager.requestUtils.requestObject.PlanRequest;
import models.manager.responseUtils.ExceptionsUtils;
import models.manager.responseUtils.JsonUtils;
import models.manager.responseUtils.Response;
import models.manager.responseUtils.responseObject.PlanResponse;
import play.libs.Json;
import play.mvc.Result;

public class PlanManagerImpl implements PlanManager {
	
	private static PlanDao planDao = new PlanDaoImpl();
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
			
			PlanRequest cr = Json.fromJson(request.get("plan"), PlanRequest.class);
			Plan c = modelMapper.map(cr, Plan.class);
			c = planDao.create(c);
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
			
			if(planDao.existEntity(id)){ // Comprueba existencia
				PlanRequest cr = Json.fromJson(request.get("plan"), PlanRequest.class);
				Plan c = modelMapper.map(cr, Plan.class);
				c.setId(id);
				c = planDao.update(c);
				return Response.updatedEntity(Json.toJson(c));
			}else{
				return Response.notFoundEntity("Plan");
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
			
		  	if(planDao.existEntity(id)){
		  		planDao.delete(id);
	            return Response.deletedEntity();
		  	}else{
		  		return Response.notFoundEntity("Plan");
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
			
			if(planDao.existEntity(id)){
				Plan c = planDao.findById(id);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, PlanResponse.class));
			}else{
				return Response.notFoundEntity("Plan");
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
			
	         ListPager listPager = planDao.findAll(pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 PlanResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByPartner(Integer id_partner, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(id_partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = planDao.findByPartner(id_partner,pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 PlanResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findByStatus(Integer id_partner, Integer status, Integer pageIndex, Integer pageSize) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(id_partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
	         ListPager listPager = planDao.findBystatus(status,pageIndex, pageSize);
	         return Response.foundEntity(
	                 listPager,
	                 PlanResponse.class);
	     }catch(Exception e){
	         return ExceptionsUtils.find(e);
	     }
	}

	@Override
	public Result findPlanPartner(Integer partner, Integer plan) {
		try {
			String token = request().getHeader("Apy_key"); // obtiene el token del usuario
			Boolean accept = pDao.findByTokenAndID(partner, token);
			if(accept == false) // Si el Id NO corresponde con el Token del usuario
				return Response.accessDenied();
			
			if(planDao.existEntity(plan)){
				Plan c = planDao.findPlanPartner(partner,plan);
	            return Response.foundEntity(
	                    JsonUtils.toJson(c, PlanResponse.class));
			}else{
				return Response.notFoundEntity("Plan");
			}
        }catch(Exception e){
            return ExceptionsUtils.find(e);
        }
	}

}

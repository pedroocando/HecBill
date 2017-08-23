package models.manager.requestUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.format.DateTimeFormatter;

/**
 * @author  yenny on 9/22/16.
 */
public class Request{

    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static JsonNode removeParameter(JsonNode json, String parameter){
        JsonNode jsonRemoved = null;

        if(json.get(parameter) != null && json instanceof ObjectNode){
            jsonRemoved = json.get(parameter);
            ObjectNode object = (ObjectNode) json;
            object.remove(parameter);
        }
        return jsonRemoved;
    }

    public static JsonNode removeParameters(JsonNode json, String[] parameters){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonRemoved = mapper.createObjectNode();

        for(int i = 0; i < parameters.length; ++i) {
            if (json.get(parameters[i]) != null && json instanceof ObjectNode) {
                jsonRemoved.set(parameters[i], json.get(parameters[i]));
                ObjectNode object = (ObjectNode) json;
                object.remove(parameters[i]);
            }
        }
        return jsonRemoved;
    }
}

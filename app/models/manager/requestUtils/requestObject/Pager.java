package models.manager.requestUtils.requestObject;

import play.mvc.QueryStringBindable;

import java.util.Map;
import java.util.Optional;

// https://www.playframework.com/documentation/2.5.3/api/java/play/mvc/QueryStringBindable.html
public class Pager implements QueryStringBindable<Pager> {
    public int index;
    public int size;

    public Optional<Pager> bind(String key, Map<String, String[]> data) {
        if (data.containsKey(key + ".index") && data.containsKey(key + ".size")) {
            try {
                index = Integer.parseInt(data.get(key + ".index")[0]);
                size = Integer.parseInt(data.get(key + ".size")[0]);
                return Optional.<Pager>ofNullable(this);
            } catch (NumberFormatException e) {
                return Optional.<Pager>empty();
            }
        } else {
            return Optional.<Pager>empty();
        }
    }

    public String unbind(String key) {
        return key + ".index=" + index + "&" + key + ".size=" + size;
    }

    public String javascriptUnbind() {
        return "function(k,v) {\n" +
                "    return encodeURIComponent(k+'.index')+'='+v.index+'&'+encodeURIComponent(k+'.size')+'='+v.size;\n" +
                "}";
    }
}
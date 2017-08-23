package models.manager.requestUtils.requestObject;

import play.mvc.PathBindable;

import java.time.format.DateTimeFormatter;

/**
 * Created by yenny on 11/25/16.
 */
public class Date implements PathBindable<Date> {
    public String value;
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Date bind(String key, String value) {
        Date date = new Date();
        if(!value.equals("-1")) {
            try {
                date.value = dateFormatter.parse(value).toString();
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }else{
            date.value = value;
        }
        return date;
    }

    @Override
    public String unbind(String key) {
        return null;
    }

    @Override
    public String javascriptUnbind() {
        return null;
    }
}

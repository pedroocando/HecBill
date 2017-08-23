package models.manager.responseUtils.responseObject;


import com.fasterxml.jackson.annotation.JsonFormat;
import play.data.format.Formats;

import java.sql.Timestamp;

/**
 * Created by yenny on 10/28/16.
 */
public class AbstractEntityResponse {
    public Long id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp createdAt;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp updatedAt;
}

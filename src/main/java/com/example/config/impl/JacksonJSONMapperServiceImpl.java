package com.example.config.impl;

import com.example.config.JSONMapperService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;


//@Service("JSONMapperService")
public class JacksonJSONMapperServiceImpl implements JSONMapperService {

    @Autowired
    private ObjectMapper objectMapper;

    private final JsonFactory jsonFactory = new JsonFactory();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public String toJSON(Object object) {
        try {

            final StringWriter sw = new StringWriter();
            JsonGenerator jg = jsonFactory.createGenerator(sw);
            objectMapper.writeValue(jg, object);

            return sw.toString();
        } catch (Exception e) {
            logger.error("Failed to serialise to JSON", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to convert JSON to destination class, if JSON is empty or null, null will be return.
     * @param type the destination class type
     * @param json the JSON stream
     * @param <T>
     * @return Instance of type, null if json is empty.
     */
    public <T> T toObject(Class<T> type, String json) {
        try {
            if (ObjectUtils.nullSafeToString(json).isEmpty()) {
                // if the source is empty then just return null.
                return null;
            } else {
                return objectMapper.readValue(json, type);
            }
        } catch (Exception e) {
            return this.handleException(type, e);
        }
    }

    public <T> List<T> toList(Class<T> type, String json) {
        type.getClass();
        try {
            final CollectionType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, type);
            return objectMapper.readValue(json, javaType);

        } catch (Exception e) {
            return this.handleException(type, e);
        }
    }

    public <T> T toObject(TypeReference<?> type, String json) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception e) {
            return this.handleException(type.getType().getClass(), e);
        }
    }

    @Override
    public boolean isValidJSON(String str) {
        try {
            objectMapper.readValue(str, Map.class);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * When Jackson unable to unmarshalle JSON to POJO it will provide the full JSON string,
     * the API we have are sensitive to personal information, so need to cut the full json string from the error message.
     * @param e The exception
     * @return Error message that cut the json.
     */
    private String chopJacksonExceptionMessage(final Exception e) {
        if (e == null) {
            return "";
        }

        String choppedError = e.getMessage();
        if (JsonMappingException.class.isAssignableFrom(e.getClass())) {
            choppedError = choppedError.substring(0, choppedError.indexOf("\n at"));
        } else {
            choppedError = e.getMessage();
        }

        return choppedError;
    }

    private <T> T handleException(final Class type, final Exception e) throws RuntimeException {
        final String errMsg = "Failed to parse JSON to type: " +  type.getName() + " error: " + this.chopJacksonExceptionMessage(e);

        // don't need to log as error as in the exception handler will catch any runtime exception and log before
        // returning response to client.
        if (logger.isDebugEnabled()) {
            logger.debug(errMsg);
        }

        throw new RuntimeException(errMsg);
    }

}
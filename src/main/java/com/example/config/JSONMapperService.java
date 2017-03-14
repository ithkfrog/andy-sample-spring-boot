package com.example.config;


import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

/**
 * Parses/writes JSON
 */
public interface JSONMapperService {
    /**
     * Marshall POJO to JSON
     *
     * @param object
     * @return
     */
    String toJSON(Object object);

    /**
     * Unmarshall JSON to POJO
     *
     * @param type the destination class type
     * @param json the JSON stream
     * @param <T>  erasure
     * @return
     */
    <T> T toObject(Class<T> type, String json);

    <T> T toObject(TypeReference<?> type, String json);

    /**
     * Converts to a list of objects
     * @param type
     * @param json
     * @param <T>
     * @return
     */
    public <T> List<T> toList(Class<T> type, String json);
    
    boolean isValidJSON(String str);

}

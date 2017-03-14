package com.example.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Override spring config to inject customized Jackson ObjectMapper.
 * This configuration will be called and initialized when MVC Servlet been created. In example for identity app
 * is the <code>IdentityRestAPI-servlet.xml</code>
 *
 *
 * http://stackoverflow.com/questions/4823358/spring-configure-responsebody-json-format
 *
 * @author Andy Chau
 * @see <a herf="/webapp/WEB-INF/IdentityResetAPI-servlet.xml>IdentityRestAPI-servlet.xml</a>
 */
//@Configuration
public class JacksonConfig {
    /**
     * SLF4j logger
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.writer().without(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // set the mapper to only include NON_NULL properties.
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        logger.info("Register customized Jackson object mapper successfully.");
        return objectMapper;
    }

}

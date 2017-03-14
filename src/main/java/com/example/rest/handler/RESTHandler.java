package com.example.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Andy Chau on 14/03/17.
 */
public class RESTHandler<T> {

    public static <T>ResponseEntity<T> buildAccepted(T response){
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    public static <T>ResponseEntity<T> buildError(T response){
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    public static <T>ResponseEntity<T> buildOK(T response){
        return new ResponseEntity(response, HttpStatus.OK);
    }
}

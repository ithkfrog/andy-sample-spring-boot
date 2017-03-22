package com.example.rest.parties;

import com.example.presistence.CustomerCrudRepository;
import com.example.rest.handler.RESTHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Chau on 14/03/17.
 */
@Controller
@RestController
public class CustomerController {

    @Autowired
    CustomerCrudRepository customerCrudRepository;

    @RequestMapping("/parties/customers")
    public ResponseEntity<?> customers() {

        Object response = customerCrudRepository.findAll();
        return RESTHandler.buildOK(response);
    }

    @RequestMapping("/parties/customers/{customerId}")
    public ResponseEntity<?> customer(
            @PathVariable(value="customerId") Long customerId) {

        Object response = customerCrudRepository.findById(customerId);

        return RESTHandler.buildOK(response);
    }
}

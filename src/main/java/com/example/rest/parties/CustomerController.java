package com.example.rest.parties;

import com.example.presistence.CustomerPersistence;
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
    CustomerPersistence customerPersistence;

    @RequestMapping("/parties/customers")
    public ResponseEntity<?> customers() {

        Object response = customerPersistence.findAll();
        return RESTHandler.buildOK(response);
    }

    @RequestMapping("/parties/customers/{customerID}")
    public ResponseEntity<?> customer(
            @PathVariable(value="customerID") Long customerID) {

        Object response = customerPersistence.findByCustomerId(customerID);

        return RESTHandler.buildOK(response);
    }
}

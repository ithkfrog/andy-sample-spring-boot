package com.example.rest.parties;

import com.example.presistence.SupplierCurdRepository;
import com.example.rest.handler.RESTHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Chau on 14/03/17.
 */
@Controller
@RestController
public class SupplierHandler {

    @Autowired
    private SupplierCurdRepository supplierCurdRepository;

    @RequestMapping("/parties/suppliers")
    public ResponseEntity<?> suppliers(@RequestParam(value="supplierName", required=false) String supplierName) {

        Object response;

        if (!StringUtils.isEmpty(supplierName)) {

            response = supplierCurdRepository.findByNameContainsAllIgnoreCase(supplierName);
        } else {
            response = supplierCurdRepository.findAll();
        }

        return RESTHandler.buildOK(response);
    }


    @RequestMapping("/parties/suppliers/{supplierId}")
    public ResponseEntity<?> supplier(
            @PathVariable(value="supplierId") Long supplierId) {

        Object response = supplierCurdRepository.findById(supplierId);

        return RESTHandler.buildOK(response);
    }
}

package com.lambdaschool.ordersapp.controllers;

// let Spring know this is a controller for REST operations

import com.lambdaschool.ordersapp.model.Customers;
import com.lambdaschool.ordersapp.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer") // optional - sets designated URL
public class CustomersController
{
    @Autowired // some magic, i guess. basically gives us stuff off of CustomersService service
    private CustomersService customersService;

    // get all customers
    @GetMapping(value = "/order", produces = {"application/json"}) // tells Spring we want to create endpoint
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customers> theCustomers = customersService.findAllCustomers();
        return new ResponseEntity<>(theCustomers, HttpStatus.OK);
    }

//    get customer by name
    @GetMapping(value = "/name/{custname}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(@PathVariable String custname)
    {
        Customers aCustomer = customersService.findByCustname(custname);
        return new ResponseEntity<>(aCustomer, HttpStatus.OK);
    }

}

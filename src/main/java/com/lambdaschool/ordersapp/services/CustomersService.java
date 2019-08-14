package com.lambdaschool.ordersapp.services;

import com.lambdaschool.ordersapp.model.Customers;

import java.util.List;

public interface CustomersService
{
    // we need to
    // find all customers
    // find customers by id
    // find customers by name
    // create a new customer
    // update a customer by id
    // delete a customer by id

    // find all customers will be function of type list with items of the Customers data type
    List<Customers> findAllCustomers();

    // find customers by id
    Customers findCustomersById(long id);

    // find customers by name
    Customers findCustomersByName(String name);

    // create a new customer
    Customers save(Customers customer);

    // update a customer by id
    Customers update(Customers customer, long id);

    // delete a customer by id
    void delete(long id);




}

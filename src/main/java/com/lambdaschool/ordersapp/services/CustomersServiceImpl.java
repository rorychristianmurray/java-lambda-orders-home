package com.lambdaschool.ordersapp.services;

import com.lambdaschool.ordersapp.model.Customers;
import com.lambdaschool.ordersapp.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional // annotation
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService
{
    @Autowired
    private CustomersRepository custyrepos;


    //implement findAllCustomers method
    @Override
    public List<Customers> findAllCustomers()
    {
        List<Customers> list = new ArrayList<>();

        //findAll built in method returns an iterator which we need to convert
        custyrepos.findAll().iterator().forEachRemaining(list::add);


    }



}

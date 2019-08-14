package com.lambdaschool.ordersapp.repos;

import com.lambdaschool.ordersapp.model.Customers;
import org.springframework.data.repository.CrudRepository;


// I don't really understand why we only need one method here

public interface CustomersRepository extends CrudRepository<Customers, Long>
{
    Customers findCustomersByName(String name);
}

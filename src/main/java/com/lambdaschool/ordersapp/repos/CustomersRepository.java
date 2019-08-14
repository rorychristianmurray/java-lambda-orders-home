package com.lambdaschool.ordersapp.repos;

import com.lambdaschool.ordersapp.model.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers, Long>
{
    Customers findCustomersByName(String name);
}

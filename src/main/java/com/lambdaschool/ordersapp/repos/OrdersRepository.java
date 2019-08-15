package com.lambdaschool.ordersapp.repos;

import com.lambdaschool.ordersapp.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long>
{
}

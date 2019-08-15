package com.lambdaschool.ordersapp.services;

import com.lambdaschool.ordersapp.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrdersServiceImpl implements OrdersService
{
    @Autowired
    private OrdersRepository ordersrepos;

}

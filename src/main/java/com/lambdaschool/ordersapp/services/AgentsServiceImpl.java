package com.lambdaschool.ordersapp.services;


import com.lambdaschool.ordersapp.repos.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lambdaschool.orders.model.Agents;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "agentsService")
public class AgentsServiceImpl
{
    @Autowired
    private AgentsRepository agentsrepos;

    @Override
    public Agents findAgentById(long id) throws EntityNotFoundException // I don't get why we do this
    {
        // wiring the AgentsRepository to the CrudRepository gives us access to the findById method
        return agentsrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)))
    }


}

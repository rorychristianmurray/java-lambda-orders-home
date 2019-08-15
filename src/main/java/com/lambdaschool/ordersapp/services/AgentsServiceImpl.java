package com.lambdaschool.ordersapp.services;


import com.lambdaschool.ordersapp.repos.AgentsRepository;
import com.lambdaschool.ordersapp.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lambdaschool.ordersapp.model.Agents;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "agentsService")
public class AgentsServiceImpl implements AgentsService
{
    @Autowired
    private AgentsRepository agentsrepos;

    @Autowired
    private CustomersRepository custrepos;

    @Override
    public Agents findAgentById(long id) throws EntityNotFoundException // I don't get why we do this
    {
        // wiring the AgentsRepository to the CrudRepository gives us access to the findById method
        return agentsrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public void deleteUnassigned(long agentid)
    {
        {
            if (agentsrepos.findById(agentid).isPresent())
            {
                if (custrepos.findByAgent_Agentcode(agentid) == null)
                {
                    agentsrepos.deleteById(agentid);
                }
                else
                {
                    throw new EntityNotFoundException("Found " + Long.toString(agentid));
                }
            }
            else
            {
                throw new EntityNotFoundException(Long.toString(agentid));
            }
        }
    }


}

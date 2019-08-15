package com.lambdaschool.ordersapp.services;
import com.lambdaschool.ordersapp.model.Agents;
public interface AgentsService
{
    Agents findAgentById(long id);
    void deleteUnassigned(long agentid);
}

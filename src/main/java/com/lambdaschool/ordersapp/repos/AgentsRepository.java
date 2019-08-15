package com.lambdaschool.ordersapp.repos;

import org.springframework.data.repository.CrudRepository;
import com.lambdaschool.orders.model.Agents;

public interface AgentsRepository extends CrudRepository<Agents, Long>
{
}

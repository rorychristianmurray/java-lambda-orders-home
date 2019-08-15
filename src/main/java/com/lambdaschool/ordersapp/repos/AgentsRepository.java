package com.lambdaschool.ordersapp.repos;

import com.lambdaschool.ordersapp.model.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agents, Long>
{
}

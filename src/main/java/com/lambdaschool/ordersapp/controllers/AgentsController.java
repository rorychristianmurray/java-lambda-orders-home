package com.lambdaschool.ordersapp.controllers;

import com.lambdaschool.ordersapp.services.AgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentsController
{

    @Autowired
    AgentsService agentsService;

    @DeleteMapping(value = "/agent/{agentid}")
    public ResponseEntity<?> deleteUnassignedAgentById(@PathVariable long agentid)
    {
        agentsService.deleteUnassigned(agentid);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

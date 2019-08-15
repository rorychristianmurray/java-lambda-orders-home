package com.lambdaschool.orders.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.ordersapp.model.Customers;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// name your table
// table and field names are lower case

@Entity
@Table(name = "agents")
public class Agents {
    // fields - state
    //makes this the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;
    private String name;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    // type of relational mapping goes here
    // One agent will have many customers, hence it is a OneToMany relationship
    // dont forget foreign key mapping for this table
    @OneToMany(mappedBy = "agents",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("agents")
    private List<Customers> customers = new ArrayList<>();

    // Spring needs a blank default constructor
    public Agents()
    {
    }

    // now add our regular constructor
    public Agents(String name, String workingarea, double commission, String phone, String country) {
        this.name = name;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
        this.customers = customers;
    }
    // generate getters and setter, but not List
    public long getAgentcode() {
        return agentcode;
    }
    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWorkingarea() {
        return workingarea;
    }
    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }
    public double getCommission() {
        return commission;
    }
    public void setCommission(double commission) {
        this.commission = commission;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    // handle list
}
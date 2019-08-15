package com.lambdaschool.ordersapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import com.lambdaschool.orders.model.Agents;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table() // why doesn't this have a name/value?

public class Customers
{
    // fields - values - state

    // custcode will be the primary key, needs @ID and @GeneratedValue
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    //custname is required, therefore needs a @Column
    @Column(nullable = false)
    private String custname;

    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamount;
    private double receiveamount;
    private double paymentamount; // *** ADD IN ***
    private double outstandingamount;
    private String phone;

    // agentcode needs to be the foreign key
    // define the relational data type
    // There will be many customers, but they will map to one agent
    // Therefore, the Customers class needs an agent field of Agent type
    @ManyToOne
    @JoinColumn(name = "agentcode",
    nullable = false)
    @JsonIgnoreProperties("customers") // prevent infinite loop
    private Agents agent;

    // telling our database what type of relationship this will have and to what
    // handled by Spring Boot **check this. Is it Spring Data? JPA (Java Protection Agency)
    // This field is an ArrayList holding data of the Orders type
    @OneToMany(mappedBy = "customers", // *** CHECK THIS ***
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("customers") // prevent infinite loop // *** CHECK THIS ***
    private List<Orders> orders = new ArrayList<>();

    // base constructor for Spring Boot
    public Customers()
    {
    }

    // regular constructor for our getters and setters

    public Customers(String custname, String custcity, String workingarea, String custcountry, String grade, double openingamount, double receiveamount, double paymentamount, double outstandingamount, String phone, Agents agent)
    {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamount = openingamount;
        this.receiveamount = receiveamount;
        this.outstandingamount = outstandingamount;
        this.paymentamount = paymentamount;
        this.phone = phone;
        this.agent = agent;
    }

    // generate getters and setters


    public long getCustcode()
    {
        return custcode;
    }

    public void setCustcode(long custcode)
    {
        this.custcode = custcode;
    }

    public String getCustname()
    {
        return custname;
    }

    public void setCustname(String custname)
    {
        this.custname = custname;
    }

    public String getCustcity()
    {
        return custcity;
    }

    public void setCustcity(String custcity)
    {
        this.custcity = custcity;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public String getCustcountry()
    {
        return custcountry;
    }

    public void setCustcountry(String custcountry)
    {
        this.custcountry = custcountry;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public double getOpeningamount()
    {
        return openingamount;
    }

    public void setOpeningamount(double openingamount)
    {
        this.openingamount = openingamount;
    }

    public double getReceiveamount()
    {
        return receiveamount;
    }

    public void setReceiveamount(double receiveamount)
    {
        this.receiveamount = receiveamount;
    }

    public double getPaymentamt()
    {
        return paymentamount;
    }

    public void setPaymentamt(double paymentamt)
    {
        this.paymentamount = paymentamt;
    }


    public double getOutstandingamount()
    {
        return outstandingamount;
    }

    public void setOutstandingamount(double outstandingamount)
    {
        this.outstandingamount = outstandingamount;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Agents getAgent()
    {
        return agent;
    }

    public void setAgent(Agents agent)
    {
        this.agent = agent;
    }


    // handle getting and setting list

    public List<Orders> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Orders> orders)
    {
        this.orders = orders;
    }


}

package com.lambdaschool.ordersapp.model;
// @Entity tells that this is a table
// @Table names our table

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{
    //fields - state

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum; // primary key

    // foreign key, many orders to one customer (ManyToOne)
    // when using ManyToOne, we need to specify which column to join by
    @ManyToOne
    @JoinColumn(name = "custcode",
    nullable = false)
    @JsonIgnoreProperties("orders") // prevent infinite loop
    private Customers customer;
    private double ordamount;
    private double advanceamount;
    private String orddescription;

// generate default constructor for Spring
    public Orders()
    {
    }

    // generate regular constructor for our getters and setter
    public Orders(Customers customer, double ordamount, double advanceamount, String orddescription)
    {
        this.customer = customer;
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orddescription = orddescription;
    }

    // generate getters and setter


    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public Customers getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customers customer)
    {
        this.customer = customer;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public String getOrddescription()
    {
        return orddescription;
    }

    public void setOrddescription(String orddescription)
    {
        this.orddescription = orddescription;
    }
}

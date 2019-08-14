package com.lambdaschool.ordersapp.services;

import com.lambdaschool.ordersapp.model.Customers;
import com.lambdaschool.ordersapp.model.Orders;
import com.lambdaschool.ordersapp.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional // annotation
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService
{
    @Autowired
    private CustomersRepository custyrepos;


    //implement findAllCustomers method
    @Override
    public List<Customers> findAllCustomers()
    {
        List<Customers> list = new ArrayList<>();

        //findAll built in method returns an iterator which we need to convert
        custyrepos.findAll().iterator().forEachRemaining(list::add);

        // now return as normal as ArrayList
        return list;
    }

        // implement findCustomersById method using built in methods from CrudRepository
        @Override
        public Customers findCustomersById(long id)
        {
            return custyrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        }

        // implement findCustomersByName method using built in methods from CrudRepository
        @Override
        public Customers findCustomersByName(String name)
        {
            Customers customer = custyrepos.findCustomersByName(name);

            if (customer == null)
            {
                throw new EntityNotFoundException("Customer " + name + " not found, ya rascal!");
            }
            return customer;
        }

        // implement save
    @Transactional // tell Spring we are changing data and handles everything as single trx
    @Override
    public Customers save(Customers customer)
    {
        Customers newCustomer = new Customers();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamount(customer.getOpeningamount());
        newCustomer.setReceiveamount(customer.getReceiveamount());
        newCustomer.setOutstandingamount(customer.getOutstandingamount());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());

        for (Orders o : customer.getOrders())
        {
            customer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), customer, o.getOrddescription()));
        }
        return custyrepos.save(customer);

    }

        // implement update

    @Override
    public Customers update(Customers customer, long id)
    {
        Customers customer = custyrepos.findById(id).orElseThrow(() -> EntityNotFoundException(Long.toString(id)));

        if (customer.getCustname() != null)
        {
            customer.setCustname(customer.getCustname());
        }
        else if (customer.getCustcity() != null)
        {
            customer.setCustcity(customer.getCustcity());
        }
        else if (customer.getWorkingarea() != null)
        {
            customer.setWorkingarea(customer.getWorkingarea());
        }
        else if (customer.getCustcountry() != null)
        {
            customer.setCustcountry(customer.getCustcountry());
        }
        else if (customer.getGrade() != null)
        {
            customer.setGrade(customer.getGrade());
        }
        else if (customer.getOpeningamount() != null)
        {
            customer.setOpeningamount(customer.getOpeningamount());
        }
        else if (customer.setReceiveamount() != null)
        {
            customer.setReceiveamount(customer.getReceiveamount());
        }
        else if (customer.setOutstandingamount() != null )
        {
            customer.setOutstandingamount(customer.getOutstandingamount());
        }
        else if (customer.setPhone() != null)
        {
            customer.setPhone(customer.getPhone());
        }
        else if (customer.setAgent() != null)
        {
            customer.setAgent(customer.getAgent());
        }

        // add new orders
        if (customer.getOrders().size() > 0)
        {
            for (Orders o : customer.getOrders())
            {
                customer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), o.getOrddescription()));
            }

            return custyrepos.save(customer);
        }

    }

        // implement delete
    @Transactional
    @Override
    public void delete(long id)
    {
        if (custyrepos.findById(id).isPresent())
        {
            custyrepos.deleteById();
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }
    
}

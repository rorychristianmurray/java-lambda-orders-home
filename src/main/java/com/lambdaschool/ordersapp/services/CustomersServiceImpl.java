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

    @Autowired
    private AgentsService agentsService;


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
        public Customers findCustomersById(long id) throws EntityNotFoundException
        {
            return custyrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        }

        // implement findCustomersByName method using built in methods from CrudRepository
        @Override
        public Customers findByCustname(String custname)
        {
            Customers customer = custyrepos.findByCustname(custname);

            if (customer == null)
            {
                throw new EntityNotFoundException("Customer " + custname + " not found, ya rascal!");
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
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamount(customer.getOutstandingamount());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(agentsService.findAgentById(customer.getAgent().getAgentcode()));

        for (Orders o : customer.getOrders())
        {
            customer.getOrders().add(new Orders(customer, o.getOrdamount(), o.getAdvanceamount(), o.getOrddescription()));
        }
        return custyrepos.save(customer);

    }

        // implement update

    @Override
    public Customers update(Customers customer, long id)
    {
        Customers thisCustomer = custyrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (customer.getCustname() != null)
        {
            thisCustomer.setCustname(customer.getCustname());
        }
        else if (customer.getCustcity() != null)
        {
            thisCustomer.setCustcity(customer.getCustcity());
        }
        else if (customer.getWorkingarea() != null)
        {
            thisCustomer.setWorkingarea(customer.getWorkingarea());
        }
        else if (customer.getCustcountry() != null)
        {
            thisCustomer.setCustcountry(customer.getCustcountry());
        }
        else if (customer.getGrade() != null)
        {
            thisCustomer.setGrade(customer.getGrade());
        }
        else if (customer.getOpeningamount() != 0)
        {
            thisCustomer.setOpeningamount(customer.getOpeningamount());
        }
        else if (customer.getReceiveamount() != 0)
        {
            thisCustomer.setReceiveamount(customer.getReceiveamount());
        }
        else if (customer.getOutstandingamount() != 0 )
        {
            thisCustomer.setOutstandingamount(customer.getOutstandingamount());
        }
        else if (customer.getPhone() != null)
        {
            thisCustomer.setPhone(customer.getPhone());
        }
        else if (customer.getAgent() != null)
        {
            thisCustomer.setAgent(customer.getAgent());
        }

        // add new orders
        if (customer.getOrders().size() > 0)
        {
            for (Orders o : customer.getOrders())
            {
                thisCustomer.getOrders().add(new Orders(customer, o.getOrdamount(), o.getAdvanceamount(), o.getOrddescription()));
            }
        }
        return custyrepos.save(customer);

    }

        // implement delete
    @Transactional
    @Override
    public void delete(long id)
    {
        if (custyrepos.findById(id).isPresent())
        {
            custyrepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

}

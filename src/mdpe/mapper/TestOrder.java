package mdpe.mapper;

import mdpe.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import javax.print.attribute.standard.Destination;

/**
 * Created by Administrator on 2018/6/22.
 */
public class TestOrder {

    public static void main(String[] args) {


    }

    @Test
    public void test(){


        Name name = new Name();
        name.setFirstName("firstName");
        name.setLastName("lastName");
        Address address = new Address();
        address.setStreet("street");
        address.setCity("city");

        Customer customer = new Customer();
        customer.setName(name);

        Order order = new Order();
        order.setCustomer(customer);
        order.setBillingAddress(address);

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings((order1, orderDTO) -> {

        });

        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        Assert.assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
    }
}

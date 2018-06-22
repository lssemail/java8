package mdpe.model;

/**
 * Created by Administrator on 2018/6/22.
 */
public class Order {

    private Customer customer;

    private Address billingAddress;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}

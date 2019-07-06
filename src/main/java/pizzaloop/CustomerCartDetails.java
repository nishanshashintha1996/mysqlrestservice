package pizzaloop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CustomerCartDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerCartId;
    private String nationalIC;
    private String address;
    private String city;

    public int getCustomerCartId() {
        return customerCartId;
    }

    public void setCustomerCartId(int customerCartId) {
        this.customerCartId = customerCartId;
    }

    public String getNationalIC() {
        return nationalIC;
    }

    public void setNationalIC(String nationalIC) {
        this.nationalIC = nationalIC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

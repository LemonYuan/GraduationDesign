package scau.mappers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import scau.models.Customer;

public interface ICustomerDAO {
public Customer selectCustomerByID(int id);
public List<Customer> getAddressCustomerByID(int address_id);
public List<Customer> getAllCustomer();
public List<LinkedHashMap> getCustomerNumByStore(HashMap map);
}
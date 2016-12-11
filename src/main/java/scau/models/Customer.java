package scau.models;

import java.sql.Timestamp;

public class Customer {
   private int customer_id;
   private String first_name;
   private String last_name;
   private int store_id;
   private Address address;
   private int active;
   private Timestamp create_date;
   private Timestamp last_update;
public int getCustomer_id() {
	return customer_id;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public Timestamp getCreate_date() {
	return create_date;
}
public void setCreate_date(Timestamp create_date) {
	this.create_date = create_date;
}
public Timestamp getLast_update() {
	return last_update;
}
public void setLast_update(Timestamp last_update) {
	this.last_update = last_update;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public int getStore_id() {
	return store_id;
}
public void setStore_id(int store_id) {
	this.store_id = store_id;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
   
}

package application;

import java.util.*;

public class Customer implements Comparable<Customer> {

	// A customer has a name, address as string , a plan ,id
	protected int hashCode;
	protected String id;
	protected String name;
	protected String address;
	protected String plan;
	protected String mobile;
	protected ArrayList<String> receiving; // One list represent the media the customer is interested in receiving " the
											// cart "
	protected ArrayList<String> rented; // the second one represents the media already received (rented) by the customer

	public Customer() {

	}

	public Customer(String id, String name, String address, String plan, String mobile) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.mobile = mobile;

		receiving = new ArrayList<String>();
		rented = new ArrayList<String>();

		if (plan.trim().equalsIgnoreCase("unlimited") || plan.trim().equalsIgnoreCase("limited")) {
			// to trim plan and see if its Limited or unlimited
			this.plan = plan.toUpperCase().trim();
		} else {
			throw new IllegalArgumentException("Invalid plan!");
		}

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPlan() {
		return plan;
	}

	public String getMobile() {
		return mobile;
	}

	@Override
	public String toString() {

		return (id + " " + name + " " + address + " " + plan + " " + mobile + " , Rented :" + rented + ", In cart:"
				+ receiving);
	}

	@Override
	public int compareTo(Customer o) {// this method for comparing the instance of
		Customer temp = (Customer) o;

		return this.getId().compareTo(temp.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) { // if this object is equally to this object "customer"
			return true; // return true
		}
		if (obj == null || getClass() != obj.getClass()) { // if this object is null or not from this class
			return false; // return false
		}
		Customer customer = (Customer) obj; // make this object a customer object

		return id.equals(customer.getId());
	}

}
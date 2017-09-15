package com.formrest;

public class Employee {
	private String personId;
	private String lastname;
	private String firstName;
	private String address;
	private String city;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	@Override
	public String toString() {
		return "Employee [personId=" + personId + ", lastname=" + lastname + ", firstName=" + firstName + ", address="
				+ address + ", city=" + city + "]";
	}

}

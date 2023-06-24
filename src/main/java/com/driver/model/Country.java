// Note: Do not write @Enumerated annotation above CountryName in this model.
package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
	private String code;
	private CountryName countryName;
	@OneToOne
    @JoinColumn
	private User user;
	@ManyToOne
    @JoinColumn
	private ServiceProvider serviceProvider;
	public Country(int id, String code, CountryName countryName, User user, ServiceProvider serviceProvider) {
		super();
		this.id = id;
		this.code = code;
		this.countryName = countryName;
		this.user = user;
		this.serviceProvider = serviceProvider;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public CountryName getCountryName() {
		return countryName;
	}
	public void setCountryName(CountryName countryName) {
		this.countryName = countryName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
}
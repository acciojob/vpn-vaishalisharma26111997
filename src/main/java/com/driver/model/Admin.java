package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
    private String  userName;
    private String password;
    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	private List<ServiceProvider>serviceProviders;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id, String userName, String password, List<ServiceProvider> serviceProviders) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.serviceProviders = serviceProviders;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}
	public void setServiceProviders(List<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}
	
}

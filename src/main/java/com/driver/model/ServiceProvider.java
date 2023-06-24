package com.driver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;
@Entity
@Table(name="service_provider")
public class ServiceProvider {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private  int id;
	    private String  name;
	    @ManyToOne
	    @JoinColumn
	    private Admin admin;
	    @ManyToMany(mappedBy="serviceProviderList", cascade=CascadeType.ALL)
	    private List<User>users;
	    public ServiceProvider() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ServiceProvider(int id, String name, Admin admin, List<User> users, List<Connection> connectionList,
				List<CountryName> countryList) {
			super();
			this.id = id;
			this.name = name;
			this.admin = admin;
			this.users = users;
			this.connectionList = connectionList;
			this.countryList = countryList;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Admin getAdmin() {
			return admin;
		}
		public void setAdmin(Admin admin) {
			this.admin = admin;
		}
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
		public List<Connection> getConnectionList() {
			return connectionList;
		}
		public void setConnectionList(List<Connection> connectionList) {
			this.connectionList = connectionList;
		}
		public List<CountryName> getCountryList() {
			return countryList;
		}
		public void setCountryList(List<CountryName> countryList) {
			this.countryList = countryList;
		}
		@OneToMany(mappedBy="serviceProvider", cascade=CascadeType.ALL)
		private List<Connection>connectionList;
		@OneToMany(mappedBy="country", cascade=CascadeType.ALL)
		private List<CountryName>countryList;
	    
}

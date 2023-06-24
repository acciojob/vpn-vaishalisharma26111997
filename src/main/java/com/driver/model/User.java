package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private  int id;
	    private String userName;
	    private String password;
	    private String originalIp;
	    private String maskedIp;
	    private boolean connected;
	    @OneToMany(mappedBy="country",cascade=CascadeType.ALL)
	    private Country country;
	    @ManyToMany
	    @JoinColumn
	    private List<ServiceProvider>serviceProviderList;
	    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	    private List<Connection>connectionList;
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(int id, String userName, String password, String originalIp, String maskedIp, boolean connected,
				Country country, List<ServiceProvider> serviceProviderList, List<Connection> connectionList) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.originalIp = originalIp;
			this.maskedIp = maskedIp;
			this.connected = connected;
			this.country = country;
			this.serviceProviderList = serviceProviderList;
			this.connectionList = connectionList;
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
		public String getOriginalIp() {
			return originalIp;
		}
		public void setOriginalIp(String originalIp) {
			this.originalIp = originalIp;
		}
		public String getMaskedIp() {
			return maskedIp;
		}
		public void setMaskedIp(String maskedIp) {
			this.maskedIp = maskedIp;
		}
		public boolean isConnected() {
			return connected;
		}
		public void setConnected(boolean connected) {
			this.connected = connected;
		}
		public Country getCountry() {
			return country;
		}
		public void setCountry(Country country) {
			this.country = country;
		}
		public List<ServiceProvider> getServiceProviderList() {
			return serviceProviderList;
		}
		public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
			this.serviceProviderList = serviceProviderList;
		}
		public List<Connection> getConnectionList() {
			return connectionList;
		}
		public void setConnectionList(List<Connection> connectionList) {
			this.connectionList = connectionList;
		}
	    
	    
}

package com.niit.backend.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="details")
public class UserModel {
	@Id
	@Column(name="name")
	String name;
	@Column(name="phone_number")
	long phno;
	@Column(name="date_of_birth")
	String dob;
	@Column(name="mail_id")
	String mail;
	@Column(name="password")
	String pwd;
	@Column(name="gender")
	String gender;
	@Column(name="occupation")
	String occ;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="basketId")
	private BasketModel basket;
 
	
	
	public BasketModel getBasket() {
		return basket;
	}

	public void setBasket(BasketModel basket) {
		this.basket = basket;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOcc() {
		return occ;
	}
	public void setOcc(String occ) {
		this.occ = occ;
	}
	
	
}


package com.revature.SpringProject0Backend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.SpringProject0Backend.models.dtos.AccountDTO;

@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="balance", nullable=false)
	private double balance;
	
	@Column(name="status", nullable=false)
	private AccountStatus status;
	
	@Column(name="type", nullable=false)
	private AccountType type;
	
	@JsonBackReference //this prevents recursion when account is returned as a json value
	@ManyToMany(mappedBy="accounts", cascade= {CascadeType.ALL})
	private List<User> users;
	
	public Account() {}
	public Account(int id, double balance, AccountStatus status, AccountType type) {
		this.id = id;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}
	public Account(AccountDTO accountDTO) {
		this.id = accountDTO.getId();
		this.balance = accountDTO.getBalance();
		this.status = accountDTO.getStatus();
		this.type = accountDTO.getType();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", status=" + status + ", type=" + type + "]";
	}
}

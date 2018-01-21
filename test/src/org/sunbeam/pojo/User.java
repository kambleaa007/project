package org.sunbeam.pojo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class User {

	private Integer id;
	
	@NotNull
	@NotEmpty(message="Name cant empty")
	@Column()
	private String name;
	@NotNull
	@NotEmpty(message="Password cant empty")
	
	private String password;
	@NotNull
	@NotEmpty(message="Email cant empty")
	private String email;
	private String role;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date regDate;

	public User() {
	
	}

	
	
	public User(Integer id, String name, String password, String email, String role, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
		
		this.regDate = regDate;
	}


	@Column(name="password")
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name="role")
	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}


	@Column(name="regDate")
	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="email",unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", regDate=" + regDate + "]";
	}

	

}

package org.sunbeam.pojo;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="jobseeker")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="userid")
	private Integer userid;
	
	@NotNull
	@NotEmpty(message="Name cant empty")
	@Column()
	private String name;
	
	@NotNull
	@NotEmpty(message="Phone Number cant empty")
	@Column()
	private String phno;
		
	@NotNull
	@NotEmpty(message="Location cant empty")
	@Column()
	private String location;
	
	@Column()
	private String experience;
	
	@Column()
	private String skills;
	
	@NotNull
	@NotEmpty(message="Education cant empty")
	@Column()
	private String education;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	
	// .....................................................
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="skillsid")
//	private List<Skills> skillList;
	
	
		
	// .....................................................
	
	
	
	public JobSeeker() {
	
	}



	



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getUserid() {
		return userid;
	}



	public void setUserid(Integer userid) {
		this.userid = userid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhno() {
		return phno;
	}



	public void setPhno(String phno) {
		this.phno = phno;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
	}



	public String getSkills() {
		return skills;
	}



	public void setSkills(String skills) {
		this.skills = skills;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public JobSeeker(Integer id, Integer userid, String name, String phno, String location, String experience,
			String skills, String education, Date dob) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.phno = phno;
		this.location = location;
		this.experience = experience;
		this.skills = skills;
		this.education = education;
		this.dob = dob;
	}



	@Override
	public String toString() {
		return "JobSeeker [id=" + id + ", userid=" + userid + ", name=" + name + ", phno=" + phno + ", location="
				+ location + ", experience=" + experience + ", skills=" + skills + ", education=" + education + ", dob="
				+ dob + "]";
	}



	
}

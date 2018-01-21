package org.sunbeam.pojo;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="company")
public class Company {

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
	@NotEmpty(message="Company Type cant empty")
	private String ctype;
	@NotNull
	@NotEmpty(message="Branch cant empty")
	private String branch;
	@NotNull
	@NotEmpty(message="Qualification cant empty")
	private String qualification;
	
	@NotNull
	@NotEmpty(message="Package cant empty")
	private String pkg;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date postDate;

	
	
	public Company() {
	
	}

	public Company(Integer id, String name, String ctype, String branch, String qualification, String pkg,
			Date postDate) {
		super();
		this.id = id;
		this.name = name;
		this.ctype = ctype;
		this.branch = branch;
		this.qualification = qualification;
		this.pkg = pkg;
		this.postDate = postDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", userid=" + userid + ", name=" + name + ", ctype=" + ctype + ", branch=" + branch
				+ ", qualification=" + qualification + ", pkg=" + pkg + ", postDate=" + postDate + "]";
	}

	
	
	

}

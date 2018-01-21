package org.sunbeam.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="skills")
public class Skills {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	// ..........................................................
	
	
	
	@Column(nullable = false, unique = false, length = 256)
    private String text;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Skills(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}


	@Override
	public String toString() {
		return "Skills [id=" + id + ", text=" + text + "]";
	}

//    @ManyToOne
//    private JobSeeker jobSeeker;
    
    
    // ..........................................................
    
    
       
   
    
    

}

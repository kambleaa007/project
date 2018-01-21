package org.sunbeam.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.sunbeam.dao.CompanyDao;
import org.sunbeam.dao.JobSeekerDao;
import org.sunbeam.pojo.Company;
import org.sunbeam.pojo.JobSeeker;
import org.sunbeam.pojo.Skills;
import org.sunbeam.service.UserService;


@Controller
@RequestMapping("role")
public class roleController 
{
	
	@Autowired
	private JobSeekerDao jsdao;
	
	@Autowired
	private CompanyDao cdao;
	
	
	public roleController() {
	System.out.println("Inside Role Controller....");
	
	}
		
	
	@RequestMapping("/goHomeAdmin") 
	public String admin(){
		System.out.println("going to Admin page ....");
	    return "/login/Admin"; 
	} 
	
	

	//..................................................
	
	//   /role/registerCompany
	
	@GetMapping("/registerCompany")
	public String beforeCompany(Company company){
		System.out.println("going to before Registration Company page ....");
		return "/company/RegisterCompany";
	}
	
	@PostMapping("/registerCompany")
	public String afterCompany(@ModelAttribute("company") @Valid Company company, BindingResult result, HttpSession session){
		System.out.println("going to after Registration Company page ....");
		
		if(result.hasErrors()){return "/company/RegisterCompany";}
		
		//session.setAttribute("company", company);
		
		//
		// service    dao	
		
		
			Transaction tx ;
			Integer i = cdao.insertUser(company);
			System.out.println(i+" chk me plz...");
			//session.setAttribute("company", company);
			Company c = (Company) session.getAttribute("user");
		
		
		
		
		return "/company/HomeCompany";
	}
	
	@GetMapping("/registerJobSeeker")
	public String beforeJobSeeker(JobSeeker jobSeeker, ModelMap map){
		System.out.println("going to before Registration JobSeeker page ....");
		
		//map.put("skillList", new ArrayList<>());
		return "/jobseeker/RegisterJobseeker";
	}
	
	@PostMapping("/registerJobSeeker")
	public String afterJobSeeker(@ModelAttribute("jobSeeker") @Valid JobSeeker jobSeeker, BindingResult result, HttpSession session){
		System.out.println("going to after Registration JobSeeker page ....");
		
		//
		if(result.hasErrors()){return "/jobseeker/RegisterJobseeker";}
		
		
		
		System.out.println(jobSeeker);
		System.out.println();
		
		// service    dao	
		
		Integer i = jsdao.insertUser(jobSeeker);
//		JobSeeker js = jsdao.insert(jobSeeker);
//		System.out.println(js+" chk me plz...");
		System.out.println(i+" chk me plz...");
		session.setAttribute("jobSeeker", jobSeeker);
		
		JobSeeker c = (JobSeeker) session.getAttribute("user");
		
		return "/jobseeker/HomeJobseeker";
	}
	
	//..................................................
	
	//   /role/goHome     for Company
	
	@GetMapping("/goHomeCompany")
	public String homeCompany(ModelMap model, HttpSession session){
		//System.out.println("going to before Registration JobSeeker page ....");
		
		
		/*Company company = (Company) session.getAttribute("company");
		
		System.out.println("Look what u get.....");
		
		System.out.println(company);*/
		
		Company c = (Company) session.getAttribute("user");
		
		
		return "/company/HomeCompany";
	}
	
	
	@GetMapping("/goProfileCompany")
	public String profileCompany(ModelMap model, HttpSession session){
		//System.out.println("going to before Registration JobSeeker page ....");
		
		/*Company company = (Company) session.getAttribute("company");
		
		System.out.println("Look what u get.....");
		
		System.out.println(company);*/
		
		Company c = (Company) session.getAttribute("user");
		
		return "/company/ProfileCompany";
	}
	
	
	@GetMapping("/goSettingCompany")
	public String settingCompany(ModelMap model, HttpSession session){
		//System.out.println("going to before Registration JobSeeker page ....");
		
		/*Company company = (Company) session.getAttribute("company");
		
		System.out.println("Look what u get.....");
		
		System.out.println(company);*/
		
		Company c = (Company) session.getAttribute("user");
		
		return "/company/SettingCompany";
	}
	
	//...................................................
	
//  /role/goHome     for JobSeeker
	
	@GetMapping("/goHomeJobSeeker")
	public String homeJobSeeker(){
		//System.out.println("going to before Registration JobSeeker page ....");
		JobSeeker c = (JobSeeker) session.getAttribute("user");
		return "/jobseeker/HomeJobseeker";
	}
	@GetMapping("/goProfileJobSeeker")
	public String profileJobSeeker(){
		//System.out.println("going to before Registration JobSeeker page ....");
		return "/jobseeker/ProfileJobseeker";
	}
	@GetMapping("/goSettingJobSeeker")
	public String settingJobSeeker(){
		//System.out.println("going to before Registration JobSeeker page ....");
		return "/jobseeker/SettingJobseeker";
	}
	
	
	//...................................................
	
	
	
	
	// 
	
	
	
	
	
	
}

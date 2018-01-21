package org.sunbeam.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.sunbeam.pojo.User;
import org.sunbeam.service.UserService;

@Controller
@RequestMapping("user")
public class UserController 
{
	public UserController() {
	System.out.println("Inside User Controller....");
	
	}
	@Autowired
	private UserService service;
	
//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        sdf.setLenient(true);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//    }
	
	
	@RequestMapping("/go") 
	public String home(){
	    return "Index"; 
	} 
	
	@GetMapping("/one")
	public String oneget(){
		System.out.println("Inside my get work ....");
		return "/ashish/one";
	}
	
	@PostMapping("/one")
	public String onepost(){
		System.out.println("Inside my post work ....");
		return "/ashish/two";
	}


	@GetMapping("/register")
	public String showRegistrationForm( User user, Model model)
	{
		System.out.println("Inside show registration form");
//		Map<String, String> roles = new LinkedHashMap<String, String>();
//		roles.put("JobSeeker", "JobSeeker");
//		roles.put("Company", "Company");
//		model.addAttribute("roles", roles);
		return "/user/Registration";
	}	
	
	@PostMapping("/register")
	public String insertUser( @ModelAttribute("user") @Valid User user,BindingResult result, Model model, final RedirectAttributes redirectAttributes )
	{
		System.out.println("Inside insert User "+user);
		
		
				
		if(result.hasErrors()){return "/user/Registration";}
		
		
		String regStatus = service.insertUser(user);
		if( regStatus.equals("success") == true)
			{
			
				System.out.println("Here i am "+regStatus+" result "+result.hasErrors()+result);
				model.addAttribute("user", new User());
				return "redirect:/user/login";
			
			}
		return "/user/Registration";
	}
	
//	@GetMapping("/login")
//	public String showLoginForm(Model model )
//	{
//		model.addAttribute("user", new User());
//		return "/user/Login";
//	}
	
	@GetMapping("/login")
	public String showLoginForm(User user )
	{
		//model.addAttribute("user", new User());
		return "/user/Login";
	}
	
	
	@PostMapping("/login")
	public String validateCustomer(@ModelAttribute("user") @Valid User user,BindingResult result, Model model, HttpSession session, final RedirectAttributes redirectAttributes )
	{
		
		System.out.println("Here see..."+user);
		
		//if(result.hasErrors()){return "/user/Login";}
		System.out.println(service.validateUser(user.getEmail(), user.getPassword()));
		User Udetails = service.validateUser(user.getEmail(), user.getPassword());
		
		System.out.println(""+Udetails);
		if(Udetails != null )
		{
			session.setAttribute("UserDetails", Udetails);
			
			session.setAttribute("UID", Udetails.getId());
			
			session.setAttribute("user", Udetails);
			
			String role = Udetails.getRole();
			System.out.println(role);
			
			if(role.equals("Admin")){
				return "redirect:/role/goHomeAdmin";
			}else if (role.equals("Company")) {
				
			}else if (role.equals("JobSeeker")){
				
			}
			
			return "redirect:/user/details";
		}
		return "/user/Login";
	}
	
	@RequestMapping("/allUsersList")
	public String getAllUsers(Model model){
		List<User> userList = new ArrayList<User>();
		System.out.println(service.getUserList());
		userList = service.getUserList();
		model.addAttribute("userList", userList);
		return "/user/UserList";
	}
	
	@RequestMapping("/updateUser/{id}")
	public String updateUser(@PathVariable("id") int id, Model model){
		
		model.addAttribute("user", this.service.getPersonById(id));
        model.addAttribute("listUser", this.service.getUserList());
		
		return "";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.service.getUserList());
		return "user/User";
	}
	//For add and update person both
		@RequestMapping(value= "/add", method = RequestMethod.POST)
		public String addPerson(@ModelAttribute("user") User user){
			
			System.out.println("................");
			System.out.println(user);
			if(user.getId() == null){
				//new person, add it
				System.out.println("INSERTING......");
				user.setPassword(user.getEmail());
				user.setRole("");
				this.service.insertUser(user);
			}else{
				//existing person, call update
				System.out.println("UPDATING.......");
				user.setPassword(user.getEmail());
				user.setRole("");
				this.service.updateUser(user);
			}
			
			return "redirect:/user/users";
			
		}
		
		@RequestMapping("/remove/{id}")
	    public String removePerson(@PathVariable("id") int id){
			
	        this.service.removePerson(id);
	        return "redirect:/user/users";
	    }
	 
	    @RequestMapping("/edit/{id}")
	    public String editPerson(@PathVariable("id") int id, Model model){
	    	System.out.println("ID IS "+ id +" done or not "+this.service.getPersonById(id));
	        model.addAttribute("user", this.service.getPersonById(id));
	        model.addAttribute("listUsers", this.service.getUserList());
	        return "user/User";
	    }
	
	
	@RequestMapping("/details")
	public String showDetailsForm( )
	{
		return "/user/Details";
	}
	
	
	@RequestMapping("/logout")
	public String showLogoutForm( HttpSession session )
	{
		System.out.println("Logout");
		session.invalidate();
		return "/user/Logout";
	}
}

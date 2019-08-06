package com.example.springregister;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@RestController
@RequestMapping("/product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository userrepository;
	

	@Autowired
	SellerRepository sellerrepository;
	
	@Autowired 
	private TestRestTemplate restTemplate;
	
	
     private int port=8090;
	
     private String getRootUrl() {
         return "http://localhost:" + port;
     }
     
	
	@GetMapping("/allusers")
	public List<User> getAllusers(){
		logger.info("entered -->UserController Class-->getAllusers method -->with parameters username,user,password,address,age,gender");
		return userrepository.findAll();
		
	}
	//get function
	@GetMapping("/{username}")
	public User getEmployeeById(@PathVariable(name="username") String username) {
		if(username.equalsIgnoreCase("krishna@gmail.com")) {
			throw new RuntimeException("Something Went Wrong");
		}
		
		logger.info("entered -->UserController Class-->getEmployeeById method -->with parameters username,user,password,address,age,gender\");");
		logger.info("exiting  -->UserController Class-->getEmployeeById method -->with parameters username,user,password,address,age,gender\");");
		
		return userrepository.getOne(username);
	}
	
	//post function
	
	@PostMapping("/saveusers")
	public String saveUsers(@RequestBody User user){
		logger.info("entered  saveusers method");
		userrepository.save(user);
		return "user registered successfully into database";
	}
	//delete function

	@DeleteMapping("/deleteuser/{username}")
	public String deleteById(String username){
		logger.info("entered  deletebyId method");
		userrepository.deleteById(username);
		return "Deleting user success";
	}
	
//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	@GetMapping("/allsellers")
	public List<Seller> getAllsellers(){
		logger.info("entered -->UserController Class-->getAllusers method -->with parameters username,user,password,address,age,gender");
		return sellerrepository.findAll();
		
	}
	
	//get function
		@GetMapping("/seller/{username}")
		public Seller getSellerById(@PathVariable(name="username") String username) {
			if(username.equalsIgnoreCase("krishna@gmail.com")) {
				throw new RuntimeException("Something Went Wrong");
			}
			
			logger.info("entered -->SellerController Class-->getEmployeeById method -->with parameters username,user,password,address,age,gender\");");
			logger.info("exiting  -->SellerController Class-->getEmployeeById method -->with parameters username,user,password,address,age,gender\");");
			
			return sellerrepository.getOne(username);
		}
		
	
		//post function
		
		@PostMapping("/saveseller")
		public String saveSellers(@RequestBody Seller seller){
			logger.info("entered  saveusers method");
			sellerrepository.save(seller);
			return "user registered successfully into database";
		}
		//delete function

		@DeleteMapping("/deleteseller/{username}")
		public String deleteSellerById(String username){
			logger.info("entered  deletebyId method");
			sellerrepository.deleteById(username);
			return "Deleting user success";
		}
		
	

		@GetMapping("/anotherproject")
		public String  getAllUsers() {
	     HttpHeaders headers = new HttpHeaders();
		     HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/allusers",
		      HttpMethod.GET, entity, String.class);
		      //System.out.println("-----------the output is ----------------"+response);
		        return response.getBody().toString();
	     }
		
	
	
	
	
}

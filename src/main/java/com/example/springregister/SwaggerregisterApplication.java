package com.example.springregister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.example.springregister.Seller;
import com.example.springregister.SellerRepository;

import com.example.springregister.User;
import com.example.springregister.UserRepository;


//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.example.springregister")
@EntityScan(basePackages = "com.example.springregister")
public class SwaggerregisterApplication  implements CommandLineRunner  {

	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	SellerRepository sellerrepository;
	
	
	//@Autowired
	//private ApplicationIntegration applicationintegration;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	/* @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder SwaggerregisterApplication) {
	        return SwaggerregisterApplication.sources(SwaggerregisterApplication.class);
	    }
	*/
	public static void main(String[] args) {
		SpringApplication.run(SwaggerregisterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Entering -->SwaggerregisterApplication Class-->run method-->adding users");
	
		userrepository.save(new User("krishna@gmail.com","krishna","password","myaddressssssss",22,'m'));
		userrepository.save(new User("bala@gmail.com","bala","password","myaddressssssss",22,'m'));
		userrepository.save(new User("newuser@gmail.com","newuser","password","myaddressssssss",22,'m'));
		
		sellerrepository.save(new Seller("newseller1@gmail.com","krishna1","password","myaddress",22,'m',"asianshoes","shoes"));
		sellerrepository.save(new Seller("newseller2@gmail.com","krishna2","password","myaddress",22,'m',"indiamobiles","mobiles"));
		sellerrepository.save(new Seller("newseller2@gmail.com","krishna3","password","myaddress",22,'m',"indiaclothes","clothes"));
		
		//applicationintegration.getAllUsers();
		
		
		logger.info("Exiting -->SwaggerregisterApplication Class-->run method");
		
	}

	
	
	
}
